package chandu0101.scalajs.rn.examples.movies

import chandu0101.scalajs.rn.components.{Image, ScrollView, Text, View}
import chandu0101.scalajs.rn.examples.movies.MoviesUtil._
import chandu0101.scalajs.rn.{ReactNative, ReactNativeComponentB}
import japgolly.scalajs.react._
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}


object MovieScreen {

  class Backend(t: BackendScope[_, _]) {

    val props = t.propsDynamic

  }

  val Ratings = ReactNativeComponentB[js.Dynamic]("Ratings")
    .render(P => {
    val criticsScore = P.critics_score.asInstanceOf[Int]
    val audienceScore = P.audience_score.asInstanceOf[Int]
    View()(
      View(style = styles.rating)(
        Text(style = styles.ratingTitle)("Critics:"),
        Text(style = styles.ratingValue)(getTextFromScore(criticsScore))
      ),
      View(style = styles.rating)(
        Text(style = styles.ratingTitle)("Audience:"),
        Text(style = styles.ratingValue)(getTextFromScore(audienceScore))
      )
    )
  }).build

  val Cast = ReactNativeComponentB[js.Array[js.Dynamic]]("Cast")
    .render(P => {
    View()(
      Text(style = styles.castTitle)("Actors"),
      P.map(actor => Text(key = actor.name.toString, style = styles.castActor)(s"${actor.name.toString}"))
    )
  }).build

  val component = ReactNativeComponentB[Props]("MovieScreen")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    val movie = B.props.route.passProps
    ScrollView(contentContainerStyle = styles.contentContainer)(
      View()(
        View(style = styles.mainSection)(
          Image(style = styles.detailsImage, source = getImageSource(movie, "det")),
          View(style = styles.rightPane)(
            Text()(movie.year.toString),
            View(style = styles.mpaaWrapper)(
              Text(style = styles.mpaaText)(movie.mpaa_rating.toString)
            ),
            Ratings(movie.ratings)
          )
        ),
        View(style = styles.separator)(),
        Text()(movie.synopsis.toString),
        View(style = styles.separator)(),
        Cast(movie.abridged_cast.asInstanceOf[js.Array[js.Dynamic]])
      )

    )
  })
    .buildNative


  case class Props(movie: js.Dynamic)


  object styles extends NativeStyleSheet {

    val contentContainer = style(
      padding := 10
    )
    val rightPane = style(
      justifyContent.spaceBetween,
      flex := 1
    )
    val movieTitle = style(
      flex := 1,
      fontSize := 16,
      fontWeight._500
    )
    val rating = style(
      marginTop := 10
    )
    val ratingTitle = style(
      fontSize := 14
    )
    val ratingValue = style(
      fontSize := 28,
      fontWeight._500
    )
    val mpaaWrapper = style(
      alignSelf.flexStart,
      borderColor := "black",
      borderWidth := 1,
      paddingHorizontal := 3,
      marginVertical := 5
    )
    val mpaaText = style(
      fontFamily := "Palatino",
      fontSize := 13,
      fontWeight._500
    )
    val mainSection = style(
      flexDirection.row
    )
    val detailsImage = style(
      width := 134,
      height := 200,
      backgroundColor := "#eaeaea",
      marginRight := 10
    )
    val separator = style(
      backgroundColor := "rgba(0, 0, 0, 0.1)",
      height := 1.0 / ReactNative.PixelRatio.get(),
      marginVertical := 10
    )
    val castTitle = style(
      fontWeight._500,
      marginBottom := 3
    )
    val castActor = style(
      marginLeft := 2
    )
  }


}
