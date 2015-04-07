
package chandu0101.scalajs


import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}


package object rn {
  private def load[T](lib: String): T = g.require(lib).asInstanceOf[T]

  lazy val ReactNative = load[ReactNative]("react-native")

  lazy val Fetch = load[js.Dynamic]("fetch")


}