package chandu0101.scalajs.rn.examples.movies

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components.{NavigatorIOS, NavigatorIOSRoute}
import chandu0101.scalajs.rn.styles.NativeStyleSheet

object MoviesApp {

  val component = ReactNativeComponentB[Unit]("MoviesApp")
    .render(P => {
    NavigatorIOS(style = Styles.container,
      initialRoute = NavigatorIOSRoute(title = "Scala-JS Movies",
        component = SearchScreen.component))
  }).buildU

  object Styles extends NativeStyleSheet {

    def container = style(flex := 1, backgroundColor := "#F5FCFF")
  }

  def apply() = component()
}
