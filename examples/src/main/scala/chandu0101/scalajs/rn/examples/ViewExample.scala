package chandu0101.scalajs.rn.examples

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components.{Text, View}
import japgolly.scalajs.react._

import scala.scalajs.js.Dynamic.{literal => json}


/**
 * Created by chandrasekharkode on 4/4/15.
 */
object ViewExample {


  val component = ReactNativeComponentB[Unit]("ViewExample")
    .render(P => {
    View(style = styles.container)(
      Text(style = styles.textCenter)("Background Color"),
      View(style = json(backgroundColor = "#527FE4", padding = 5))(
        Text(style = json(fontSize = 11))("Blue background")
      ),
      Text(style = styles.textCenter)("Border"),
      View(style = json(borderColor = "#527FE4", padding = 10 ,borderWidth = 5))(
        Text(style = json(fontSize = 11))("5px blue border")
      ),
      Text(style = styles.textCenter)("Border Radius"),
      View(style = json(borderRadius = 5, padding = 5 ,borderWidth = 0.5))(
        Text(style = json(fontSize = 11))("Too much use of `borderRadius` (especially large radii) on\n            anything which is scrolling may result in dropped frames.\n            Use sparingly.")
      ),
      Text(style = styles.textCenter)("Circle with Border Radius"),
      View(style = json(borderRadius = 10,borderWidth = 1, width = 20 , height = 20))()
    )
  }).buildU


  val styles = rn.ReactNative.StyleSheet.create(
    json(
      container = json(flex = 1,
        marginTop = 30,
        backgroundColor = "#F5FCFF"),
      textCenter = json(textAlign = "center",marginTop = 10)
    )
  )

  def apply() = component()

}
