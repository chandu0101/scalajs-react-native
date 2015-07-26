package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components.{Text, View}
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import org.scalajs.dom
import org.scalajs.dom.raw.{Position, PositionError}

import scala.scalajs.js.JSON


object GeoLocationExample extends UIExample {

  case class State(initialPoistion : Position = null,lastPosition : Position = null )

  class Backend(t: BackendScope[_, State]) {

    var watchID : Int = 0

  }

  val component = ReactNativeComponentB[Unit]("GeoLocationExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P,S,B) => {
      UIExplorerPage(
       UIExplorerBlock("navigator.geolocation")(
         View()(
           Text()(
             Text(style = styles.title)("Initial Position : "),
             JSON.stringify(S.initialPoistion)
           ),
           Text()(
             Text(style = styles.title)("Current Position : "),
             JSON.stringify(S.lastPosition)
           )
         )
       )
      )
    })
    .componentDidMount(scope => {
      dom.window.navigator.geolocation.getCurrentPosition((pos : Position) => {
        scope.modState(_.copy(initialPoistion = pos))
      },(error : PositionError) => println(s"Error getting geo data ${error}"))
     scope.backend.watchID = dom.window.navigator.geolocation.watchPosition(
       (pos : Position) => scope.modState(_.copy(lastPosition = pos))
     )
    })
    .componentWillMount(scope => {
      dom.window.navigator.geolocation.clearWatch(scope.backend.watchID)
    })
    .buildNative

  object styles extends NativeStyleSheet {
  val title = style(fontWeight._500)

  }

  override def title: String = "Geolocation"

  override def description: String = "Examples of using the Geolocation API."
}
