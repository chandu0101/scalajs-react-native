package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/2/15.
 */



case class PickerIOS[T](key : UndefOr[String] = undefined,
                     onValueChange : UndefOr[(T) => _] = undefined ,
                     selectedValue : UndefOr[T] = undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    onValueChange.foreach(v => p.updateDynamic("onValueChange")(v))
    selectedValue.foreach(v => p.updateDynamic("selectedValue")(if(v.isInstanceOf[Int]) v.asInstanceOf[Int] else v.toString))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.PickerIOS)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
     