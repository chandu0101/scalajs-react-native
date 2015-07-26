package chandu0101.scalajs.rn.examples.uiexplorer

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components.{NavigatorIOS, NavigatorIOSRoute}
import chandu0101.scalajs.rn.styles.NativeStyleSheet


object UIExplorerApp {

  val component = ReactNativeComponentB[Unit]("UIExplorerApp")
    .render(P => {
    NavigatorIOS(style = styles.container, initialRoute = NavigatorIOSRoute(title = "Scala-JS UIExplorer", component = UIExplorerList.component))
  }).buildU

  object styles extends NativeStyleSheet {
    val container = style(flex := 1, backgroundColor := "red")
  }

  def apply() = component()
}
