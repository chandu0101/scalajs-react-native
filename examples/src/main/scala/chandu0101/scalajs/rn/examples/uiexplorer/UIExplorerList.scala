package chandu0101.scalajs.rn.examples.uiexplorer

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.apis._
import chandu0101.scalajs.rn.examples.uiexplorer.components._
import chandu0101.scalajs.rn.examples.uiexplorer.components.navigator.NavigatorExample
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import chandu0101.scalajs.rn.{ReactNative, ReactNativeComponentB}
import japgolly.scalajs.react.BackendScope

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}


object UIExplorerList {

  val COMPONENTS: js.Array[UIExample] = js.Array(TabBarIOSExample,
    ViewExample,
    WebViewExample,
    TouchableExample,
    SegmentedControlExample,
    SwitchIOSExample,
    SliderIOSExample,
    ScrollViewExample,
    ActivityIndicatorIOSExample,
    PickerIOSExample,
    DatePickerIOSExample,
    MapViewExample,
    TextInputExample,
    ListViewExample,
    ListViewPagingExample,
    NavigatorExample)

  val APIS: js.Array[UIExample] = js.Array(AlertIOSExample,
    GeoLocationExample,
    AppStateIOSExample,
    AsyncStorageExample,
    NetInfoExample)

  val ds = rn.createListViewDataSource(rowHasChanged = (r1: UIExample, r2: UIExample) => r1 != r2, sectionHeaderHasChanged = (h1: String, h2: String) => h1 != h2)

  case class State(datasource: ListViewDataSource[UIExample] = ds.cloneWithRowsAndSections(json(componenets = COMPONENTS, apis = APIS)))

  class Backend(t: BackendScope[_, State]) {

    def onPressRow(example: UIExample): Unit = {
      t.propsDynamic.navigator.push(
        NavigatorIOSRoute(title = example.title, component = example.component).toJson
      )
    }

    def handleSearchTextChange(text: String): Unit = {
      val filter = (e: UIExample) => e.title.toLowerCase.contains(text.toLowerCase.trim)
      val filteredComponents = COMPONENTS.filter(filter)
      val filteredAPIS = APIS.filter(filter)
      t.modState(_.copy(datasource = ds.cloneWithRowsAndSections(json(componenets = filteredComponents, apis = filteredAPIS))))
    }

    def renderRow(example: UIExample, sectionID: String, rowId: String) = {
      View(key = example.title)(
        TouchableHighlight(onPress = () => onPressRow(example))(
          View(style = styles.row)(
            Text(style = styles.rowTitleText)(
              example.title
            ),
            Text(style = styles.rowDetailText)(
              example.description
            )
          )
        ),
        View(style = styles.separator)()
      )
    }

    def renderSectionHeader(data: js.Dynamic, sectionID: js.Dynamic) = {
      View(style = styles.sectionHeader)(
        Text(style = styles.sectionHeaderTitle)(
          sectionID.toString.toUpperCase
        )
      )
    }
  }

  val component = ReactNativeComponentB[Any]("UIExplorerList")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    View(style = styles.listContainer)(
      View(style = styles.searchRow)(
        TextInput(autoCapitalize = AutoCapitalize.NONE,
          autoCorrect = false,
          clearButtonMode = "always",
          onChangeText = B.handleSearchTextChange _,
          placeholder = "Search ..",
          style = styles.searchTextInput)()
      ),
      ListView(style = styles.list,
        dataSource = S.datasource,
        renderRow = B.renderRow,
        renderSectionHeader = B.renderSectionHeader _,
        automaticallyAdjustContentInsets = false)
    )
  }).buildNative


  object styles extends NativeStyleSheet {
    val listContainer = style(
      flex := 1
    )
    val list = style(
      backgroundColor := "#eeeeee"
    )
    val sectionHeader = style(
      padding := 5
    )
    val group = style(
      backgroundColor := "white"
    )
    val sectionHeaderTitle = style(
      fontWeight._500,
      fontSize := 11
    )
    val row = style(
      backgroundColor := "white",
      justifyContent.center,
      paddingHorizontal := 15,
      paddingVertical := 8
    )
    val separator = style(
      height := 1.0 / ReactNative.PixelRatio.get(),
      backgroundColor := "#bbbbbb",
      marginLeft := 15
    )
    val rowTitleText = style(
      fontSize := 17,
      fontWeight._500
    )
    val rowDetailText = style(
      fontSize := 15,
      color := "#888888",
      lineHeight := 20
    )
    val searchRow = style(
      backgroundColor := "#eeeeee",
      paddingTop := 75,
      paddingLeft := 10,
      paddingRight := 10,
      paddingBottom := 10
    )
    val searchTextInput = style(
      backgroundColor := "white",
      borderColor := "#cccccc",
      borderRadius := 3,
      borderWidth := 1,
      height := 30,
      paddingLeft := 8
    )
  }

}
