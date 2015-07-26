package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js

/**
 * Created by chandrasekharkode on 4/2/15.
 *
 * key: PropTypes.string,
    ref: PropTypes.string,
    style: PropTypes.js.Any,
 accessible:PropTypes.bool,
   delayLongPress: PropTypes.number,
   delayPressIn: PropTypes.number,
   delayPressOut: PropTypes.number,
    onLongPress: PropTypes.() => Unit,
   onPress: PropTypes.() => Unit,
   onPressIn: PropTypes.() => Unit,
   onPressOut: PropTypes.() => Unit,
 */


case class TouchableWithoutFeedback(onPressIn : js.UndefOr[() => Unit] = js.undefined,
                                    onPress : js.UndefOr[() => Unit] = js.undefined,
                                    style : js.UndefOr[js.Any] = js.undefined,
                                    delayPressIn : js.UndefOr[Int] = js.undefined,
                                    ref : js.UndefOr[String] = js.undefined,
                                    onPressOut : js.UndefOr[() => Unit] = js.undefined,
                                    key : js.UndefOr[String] = js.undefined,
                                    onLongPress : js.UndefOr[() => Unit] = js.undefined,
                                    delayPressOut : js.UndefOr[Int] = js.undefined,
                                    delayLongPress : js.UndefOr[Int] = js.undefined,
                                    accessible : js.UndefOr[Boolean]=js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    onPressIn.foreach(v => p.updateDynamic("onPressIn")(v))
    onPress.foreach(v => p.updateDynamic("onPress")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    delayPressIn.foreach(v => p.updateDynamic("delayPressIn")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    onPressOut.foreach(v => p.updateDynamic("onPressOut")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onLongPress.foreach(v => p.updateDynamic("onLongPress")(v))
    delayPressOut.foreach(v => p.updateDynamic("delayPressOut")(v))
    delayLongPress.foreach(v => p.updateDynamic("delayLongPress")(v))
    accessible.foreach(v => p.updateDynamic("accessible")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.TouchableWithoutFeedback)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}