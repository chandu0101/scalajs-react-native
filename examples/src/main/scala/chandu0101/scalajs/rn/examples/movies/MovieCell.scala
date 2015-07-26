package chandu0101.scalajs.rn.examples.movies

import chandu0101.scalajs.rn.components.{Image, Text, TouchableHighlight, View}
import chandu0101.scalajs.rn.examples.movies.MoviesUtil._
import chandu0101.scalajs.rn.{ReactNative, ReactNativeComponentB}
import japgolly.scalajs.react._
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}


object MovieCell {

  val component = ReactNativeComponentB[Props]("MovieCell")
    .render((P) => {
    val criticScore = P.movie.ratings.critics_score.asInstanceOf[Int]
    View()(
      TouchableHighlight(key = "th", onPress = P.onSelect)(
        View(key ="pap", style = styles.row)(
          Image(key = "is", source = getImageSource(P.movie,"det"),style = styles.cellImage),
          View(key = "sv", style = styles.textContainer)(
            Text(key = "tt", style = styles.movieTitle)(P.movie.title.toString),
            Text(key = "year", style = styles.movieYear,numberOfLines = 1)(
               P.movie.year.toString,
               Text(key = "hello")(
                s"Critcs ${getTextFromScore(criticScore)}"
               )
            )
          )
        )
      ),
      View(key = "cb", style = styles.cellBorder)()
    )
  })
    .build


  case class Props(movie: js.Dynamic, onSelect: () => Unit)

  object styles extends NativeStyleSheet {
    val  textContainer = style(
      flex := 1
    )
    val movieTitle = style(
      flex := 1,
      fontSize := 16,
      fontWeight._500,
      marginBottom := 2
    )
    val  movieYear = style(
      color := "#999999",
      fontSize := 12
    )
    val row = style(
      alignItems.center,
      backgroundColor := "white",
      flexDirection.row,
      padding := 5
    )
    val cellImage = style(
      backgroundColor := "#dddddd",
      height := 93,
      marginRight := 10,
      width := 60
    )
    val cellBorder = style(
      backgroundColor := "rgba(0, 0, 0, 0.1)",
      height := 1.0 / ReactNative.PixelRatio.get(),
      marginLeft := 4
    )
  }

  def apply(movie: js.Dynamic, onSelect: () => Unit,key : String = "") = component.withKey(key)(new Props(movie, onSelect))

}
