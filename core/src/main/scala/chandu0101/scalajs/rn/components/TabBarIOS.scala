package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn._
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
/**
 * Created by chandrasekharkode on 4/1/15.
 */
object TabBarIOS {

  def toJS = {
    val p = js.Dynamic.literal()

    p
  }

  def apply(children : ReactNode*) = {
//    val f = ReactNative.createFactory(ReactNative.TabBarIOS)
    val f = ReactNative.createFactory(ReactNative.TabBarIOS)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}