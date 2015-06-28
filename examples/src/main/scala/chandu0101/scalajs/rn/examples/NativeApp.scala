package chandu0101.scalajs.rn.examples

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.examples.movies.MoviesApp
import chandu0101.scalajs.rn.examples.uiexplorer.UIExplorerApp

import scala.scalajs.js.Dynamic.{literal => lit}
import scala.scalajs.js.JSApp


object NativeApp extends JSApp {
  def main() = {
    val ScalaJSReactNative = ReactNativeComponentB[Unit]("ScalaJSReactNative")
      .render((P) => {
//      HelloNative()
      MoviesApp()
//       UIExplorerApp()
    }).buildNative

    ReactNative.AppRegistry.registerComponent("ScalaJSReactNative", () => ScalaJSReactNative)
  }
}
