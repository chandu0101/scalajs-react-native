package chandu0101.scalajs.rn.examples

import chandu0101.scalajs.rn._

import scala.scalajs.js.JSApp

/**
 * Created by chandrasekharkode .
 */
object NativeApp extends JSApp {
  def main() = {
    val ScalaJSReactNative = ReactNativeComponentB[Unit]("ScalaJSReactNative")
      .render((P) => {
      HelloNative()
//      ViewExample()
//      TabBarExample()
    }).buildNative

    ReactNative.AppRegistry.registerComponent("ScalaJSReactNative", () => ScalaJSReactNative)
  }
}
