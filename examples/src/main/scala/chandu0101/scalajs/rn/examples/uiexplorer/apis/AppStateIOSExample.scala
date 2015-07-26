package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js

object AppStateIOSExample extends UIExample {

  val AppSateIOS = rn.ReactNative.AppStateIOS

  case class State(appState : String = AppSateIOS.currentState.get ,previousAppSates : js.Array[String] = js.Array())

  class Backend(t: BackendScope[_, State]) {
    val handleAppStateChange = (appState : String) => {
      t.modState(s => s.copy(appState,s.previousAppSates.+:(appState)))
    }
  }

  val AppStateSubscription = ReactNativeComponentB[Boolean]("AppStateSubscription")
    .initialState(State())
    .backend(new Backend(_))
    .render((P,S,B) => {
       View()(
        if(P) Text()(S.appState)
        else Text()(S.previousAppSates.mkString(","))
       )
    })
    .componentDidMount(scope => AppSateIOS.addEventListener("change",scope.backend.handleAppStateChange))
    .componentWillUnmount(scope => AppSateIOS.removeEventListener("change",scope.backend.handleAppStateChange))
    .build


  val component = ReactNativeComponentB[Unit]("AppStateIOSExample")
    .render(P => {
    UIExplorerPage(
      UIExplorerBlock("AppStateIOS.currentState")(
        Text()(AppSateIOS.currentState.get)
      ),
      UIExplorerBlock("Subscribed AppStateIOS:")(
       AppStateSubscription(true)
      ),
      UIExplorerBlock("Previous states:")(
       AppStateSubscription(false)
      )
    )
  }).buildNative

  object styles extends NativeStyleSheet {


  }

  override def title: String = "AppStateIOS"

  override def description: String = "iOS app background status"
}
