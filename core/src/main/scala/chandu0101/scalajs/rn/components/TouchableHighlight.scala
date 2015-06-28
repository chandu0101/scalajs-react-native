package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn._
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/2/15.
 *
 * props
 *
 * key: PropTypes.string,
   style: PropTypes.js.Any,
   activeOpacity: PropTypes.number,
   animationVelocity: PropTypes.number,
   underlayColor: PropTypes.string,
   onPress: PropTypes.() => Unit,
   onPressIn: PropTypes.() => Unit,
   onPressOut: PropTypes.() => Unit,
   onLongPress: PropTypes.() => Unit,
   activeOpacity: PropTypes.number,
   animationVelocity: PropTypes.number,
   underlayColor: PropTypes.string,
 onShowUnderlay:PropTypes.() => Unit,
 onHideUnderlay:PropTypes.() => Unit,
 */


case class TouchableHighlight(onPressIn : js.UndefOr[() => Unit] = js.undefined,
                              onPress : js.UndefOr[() => Unit] = js.undefined,
                              style : js.UndefOr[js.Any] = js.undefined,
                              onHideUnderlay : js.UndefOr[() => Unit] = js.undefined,
                              onPressOut : js.UndefOr[() => Unit] = js.undefined,
                              key : js.UndefOr[String] = js.undefined,
                              animationVelocity : js.UndefOr[Int] = js.undefined,
                              onLongPress : js.UndefOr[() => Unit] = js.undefined,
                              underlayColor : js.UndefOr[String] = js.undefined,
                              onShowUnderlay : js.UndefOr[() => Unit] = js.undefined,
                              activeOpacity : js.UndefOr[Int] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    onPressIn.foreach(v => p.updateDynamic("onPressIn")(v))
    onPress.foreach(v => p.updateDynamic("onPress")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    onHideUnderlay.foreach(v => p.updateDynamic("onHideUnderlay")(v))
    onPressOut.foreach(v => p.updateDynamic("onPressOut")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    animationVelocity.foreach(v => p.updateDynamic("animationVelocity")(v))
    onLongPress.foreach(v => p.updateDynamic("onLongPress")(v))
    underlayColor.foreach(v => p.updateDynamic("underlayColor")(v))
    onShowUnderlay.foreach(v => p.updateDynamic("onShowUnderlay")(v))
    activeOpacity.foreach(v => p.updateDynamic("activeOpacity")(v))
    p
  }

  def apply(children : ReactNode) = {
    val f = ReactNative.createFactory(ReactNative.TouchableHighlight)
    if (children != null) f(toJS, children).asInstanceOf[ReactComponentU_]
    else f(toJS).asInstanceOf[ReactComponentU_]
  }
}
