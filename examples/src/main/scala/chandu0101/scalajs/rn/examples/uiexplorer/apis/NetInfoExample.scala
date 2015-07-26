package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.rn.{ReactNative, ReactNativeComponentB}
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet


object NetInfoExample extends UIExample {

  val NetInfo = ReactNative.NetInfo

  case class State1(isConnected: Boolean = false)

  class Backend1(t: BackendScope[_, State1]) {

    val connectivityHandler = (c: Boolean) => {
      t.modState(_.copy(isConnected = c))
    }


  }

  val IsConnected = ReactNativeComponentB[Unit]("IsConnected")
    .initialState(State1())
    .backend(new Backend1(_))
    .render((P, S, B) => {
    View()(
      Text()(if (S.isConnected) "Online " else "Offline")
    )
  })
    .componentDidMount(scope => {
    NetInfo.isConnected.addEventListener("change", scope.backend.connectivityHandler)
    NetInfo.isConnected.fetch().done(
      (isConnected: Boolean) => {
        scope.modState(_.copy(isConnected = isConnected))
      }
    )
  })
    .componentWillUnmount(scope => NetInfo.isConnected.removeEventListener("change", scope.backend.connectivityHandler))
    .buildU


  val component = ReactNativeComponentB[Unit]("WebViewExample")
    .render(P => {
    UIExplorerPage(
      UIExplorerBlock("Asyncronously load and observe connectivity")(
        IsConnected()
      )
    )
  }).buildNative

  object styles extends NativeStyleSheet {


  }

  override def title: String = "NetInfo"

  override def description: String = "Monitor network status"
}
