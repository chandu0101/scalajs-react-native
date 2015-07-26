package chandu0101.scalajs.rn.examples.movies

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.mixins.TimerMixinNative
import japgolly.scalajs.react._
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import org.scalajs.dom.ext.Ajax

import scala.async.Async._
//import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.{JSON, URIUtils}
import scala.scalajs.concurrent.JSExecutionContext.Implicits.runNow


object SearchScreen {

  val API_URL = "http://api.rottentomatoes.com/api/public/v1.0/"
  val API_KEYS = List("7waqfqbprs7pajbz28mqf6vz", "y4vwv8m33hed9ety83jmv52f")

  val LOADING = collection.mutable.Map.empty[String, Boolean].withDefaultValue(false)

  case class ResultsCache(dataForQuery: Map[String, js.Array[js.Dynamic]] = Map().withDefaultValue(js.Array()), nextPageNumberForQuery: Map[String, Int] = Map().withDefaultValue(0), totalForQuery: Map[String, Int] = Map().withDefaultValue(0))

  case class State(isLoading: Boolean = false, isLoadingTail: Boolean = false, dataSource: ListViewDataSource[js.Dynamic] = createListViewDataSource((row1: js.Dynamic, row2: js.Dynamic) => row1 != row2), filter: String = "", queryNumber: Int = 0)

  class Backend(t: BackendScope[_, State]) extends TimerMixinNative{

    var resultsCache = ResultsCache()

    var timeoutID: Int = _

    def _urlForQueryAndPage(query: String, pageNumber: Int) = {
      val apiKey = API_KEYS(t.state.queryNumber % API_KEYS.length)
      if (query.nonEmpty) s"${API_URL}movies.json?apikey=${apiKey}&q=${URIUtils.encodeURIComponent(query)}&page_limit=20&page=$pageNumber"
      else s"${API_URL}lists/movies/in_theaters.json?apikey=${apiKey}&page_limit=20&page=${pageNumber}"
    }

    def getDataSource(movies: js.Array[js.Dynamic]) = {
      t.state.dataSource.cloneWithRows(movies)
    }

    def searchMovies(query: String) = {
      t.modState(_.copy(filter = query))
      val cachedResultsForQuery = resultsCache.dataForQuery.getOrElse(query, null)
      if (cachedResultsForQuery != null) {
        if (!LOADING.getOrElse(query, false)) {
          t.modState(_.copy(dataSource = getDataSource(cachedResultsForQuery), isLoading = false))
        } else {
          t.modState(_.copy(isLoading = true))
        }
      } else {
        LOADING += query -> true
        resultsCache = resultsCache.copy(dataForQuery = resultsCache.dataForQuery.updated(query, null))
        t.modState(s => s.copy(isLoading = true, queryNumber = s.queryNumber + 1, isLoadingTail = false))
        val page = resultsCache.nextPageNumberForQuery.getOrElse(query, 1)
        async {
          val result = await(Ajax.get(_urlForQueryAndPage(query, page)))
          val response = JSON.parse(result.responseText)
          val movies = response.movies.asInstanceOf[js.Array[js.Dynamic]]
          LOADING.update(query, false)
          resultsCache = resultsCache.copy(dataForQuery = resultsCache.dataForQuery.updated(query, movies),
            nextPageNumberForQuery = resultsCache.nextPageNumberForQuery.updated(query, 2),
            totalForQuery = resultsCache.totalForQuery.updated(query, response.total.asInstanceOf[Int]))
          if (t.state.filter == query) t.modState(_.copy(isLoading = false, dataSource = getDataSource(movies)))
        }.recover {
          case ex => {
            LOADING.update(query, false)
            t.modState(_.copy(isLoading = false))
            println(s"Error searching movies with query $query ")
          }
        }
      }

    }

    def hasMore = {
      val query = t.state.filter
      if (resultsCache.dataForQuery.getOrElse(query, null) == null) true
      else resultsCache.totalForQuery(query) != resultsCache.dataForQuery(query).length
    }

    def onEndReached : Unit = {
      val query = t.state.filter
      if (hasMore || !t.state.isLoadingTail || !LOADING(query)) {
        // if we have all elements or fetching don't do anything
        LOADING += query -> true
        t.modState(s => s.copy(queryNumber = s.queryNumber + 1, isLoadingTail = true))
        val page = resultsCache.nextPageNumberForQuery(query)
        async {
          val result = await(Ajax.get(_urlForQueryAndPage(query, page)))
          val response = JSON.parse(result.responseText)
          val moviesForQuery = resultsCache.dataForQuery(query)
          LOADING.update(query, false)
          if (js.isUndefined(response.movies)) {
            resultsCache = resultsCache.copy(totalForQuery = resultsCache.totalForQuery.updated(query, moviesForQuery.length))
          } else {
            val movies = response.movies.asInstanceOf[js.Array[js.Dynamic]]
            movies.foreach(m => moviesForQuery.push(m))
            resultsCache = resultsCache.copy(dataForQuery = resultsCache.dataForQuery.updated(query, moviesForQuery),
              nextPageNumberForQuery = resultsCache.nextPageNumberForQuery.updated(query, resultsCache.nextPageNumberForQuery(query) + 1))
          }
          if (t.state.filter == query) t.modState(_.copy(isLoadingTail = false, dataSource = getDataSource(resultsCache.dataForQuery(query))))
        }
      }
    }

    def selectMovie(movie: js.Dynamic) = {
      t.propsDynamic.navigator.push(NavigatorIOSRoute(title = movie.title.toString,
        component = MovieScreen.component,
        passProps = movie.asInstanceOf[js.Object]).toJson)
    }


    def renderRow(movie: js.Dynamic,sectionID : String, rowID : String):ReactElement  = {
      MovieCell(movie = movie, onSelect = () => selectMovie(movie), key = movie.title.toString)
    }

    def renderFooter = {
      if (!hasMore || !t.state.isLoadingTail) View(style = styles.scrollSpinner)()
      else ActivityIndicatorIOS(style = styles.scrollSpinner)
    }

    def onSearchChange(event: NEvent) = {
      val filter = event.nativeEvent.text.toString.toLowerCase()
      clearTimeout(timeoutID)
      timeoutID = setTimeout(() => searchMovies(filter), 100)
      println(s" text string $filter")
    }

    def dude[T <: js.Object](name: String) = "dude".asInstanceOf[T]

    def onSearchInputFocus(e: NEvent) = {
      val lref = listViewRef(t)
      println(s" on input focused $lref")
      if (lref.isDefined) lref.get.getScrollResponder().scrollTo(0, 0)
    }
  }


  val NoMovies = ReactNativeComponentB[(String, Boolean)]("NoMovies")
    .render(P => {
    val (filter, isLoading) = P
    var text = ""
    if (filter.nonEmpty) text = s"No results for $filter"
    else if (!isLoading) text = "No movies found"
    View(style = styles.container)(
      Text(style = styles.noMoviesText)(text)
    )
  }).build

  val SearchBar = ReactNativeComponentB[((NEvent) => Unit, NEvent => Unit, Boolean)]("SearchBar")
    .render(P => {
    val (onChnage, onFocus, isLoading) = P
    View(style = styles.searchBar)(
      TextInput(autoCapitalize = AutoCapitalize.NONE, autoCorrect = false,
        onChange = onChnage, onFocus = onFocus, placeholder = "Search a movie..", style = styles.searchBarInput
      )(),
      ActivityIndicatorIOS(animating = isLoading, style = styles.spinner)
    )
  }).build

  val LREF = "lref"
  val listViewRef = Ref.toJS[ListViewM](LREF)
  val component = ReactNativeComponentB[Any]("SearchScreen")
    .initialState(State(false))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val content: ReactNode = if (S.dataSource.getRowCount() == 0) NoMovies((S.filter, S.isLoading))
    else ListView[js.Dynamic,String](
      ref = LREF,
      dataSource = S.dataSource,
      renderRow = B.renderRow,
      onEndReached = B.onEndReached _,
      renderFooter = B.renderFooter _,
      showsVerticalScrollIndicator = false,
      keyboardShouldPersistTaps = true,
      automaticallyAdjustContentInsets = false
    )
    View(style = styles.container)(
      SearchBar((B.onSearchChange, B.onSearchInputFocus, S.isLoading)),
      View(style = styles.separator)(),
      content
    )
  })
    .componentDidMount(scope => {
    scope.backend.searchMovies("")
  })
    .buildNative

  case class Props(navigator: js.Object)

  object styles extends NativeStyleSheet {

    val container = style(
      flex := 1,
      backgroundColor := "white"
    )
    val centerText = style(
      alignItems.center
    )
    val noMoviesText = style(
      marginTop := 80,
      color := "#888888"
    )
    val searchBar = style(
      marginTop := 64,
      padding := 3,
      paddingLeft := 8,
      flexDirection.row,
      alignItems.center
    )
    val searchBarInput = style(
      fontSize := 15,
      flex := 1,
      height := 30
    )
    val separator = style(
      height := 1,
      backgroundColor := "#eeeeee"
    )
    val spinner = style(
      width := 30
    )
    val scrollSpinner = style(
      marginVertical := 20
    )

  }

}