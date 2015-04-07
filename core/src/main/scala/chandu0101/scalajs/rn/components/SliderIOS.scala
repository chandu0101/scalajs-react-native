package chandu0101.scalajs.rn.components

import chandu0101.scalajs
import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/1/15.
 *
 * key: PropTypes.string,
   style: PropTypes.object,
    value: PropTypes.number,
    minimumValue: PropTypes.number,
    maximumValue: PropTypes.number,
    onValueChange: PropTypes.func,
    onSlidingComplete: PropTypes.func,
 */


case class SliderIOS(style : UndefOr[js.Object] = undefined,
                     minimumValue : UndefOr[Int] = undefined,
                     onSlidingComplete : UndefOr[js.Function] = undefined ,
                     key : UndefOr[String] = undefined,
                     onValueChange : UndefOr[js.Function] = undefined ,
                     value : UndefOr[Int] = undefined,
                     maximumValue : UndefOr[Int] = undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    style.foreach(v => p.updateDynamic("style")(v))
    minimumValue.foreach(v => p.updateDynamic("minimumValue")(v))
    onSlidingComplete.foreach(v => p.updateDynamic("onSlidingComplete")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onValueChange.foreach(v => p.updateDynamic("onValueChange")(v))
    value.foreach(v => p.updateDynamic("value")(v))
    maximumValue.foreach(v => p.updateDynamic("maximumValue")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.SliderIOS)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
     
