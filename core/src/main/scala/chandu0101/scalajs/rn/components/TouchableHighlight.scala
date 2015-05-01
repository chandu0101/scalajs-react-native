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
   style: PropTypes.object,
   activeOpacity: PropTypes.number,
   animationVelocity: PropTypes.number,
   underlayColor: PropTypes.string,
   onPress: PropTypes.func,
   onPressIn: PropTypes.func,
   onPressOut: PropTypes.func,
   onLongPress: PropTypes.func,
 */


object TouchableHighlight {


  def apply(onPressIn: UndefOr[js.Function] = undefined,
            onPress: UndefOr[() => _] = undefined,
            style: UndefOr[js.Any] = undefined,
            onPressOut: UndefOr[js.Function] = undefined,
            key: UndefOr[String] = undefined,
            onLongPress: UndefOr[js.Function] = undefined,
            underlayColor: UndefOr[String] = undefined,
            activeOpacity: UndefOr[Int] = undefined,
            animationVelocity: UndefOr[Int] = undefined)(children: ReactNode = null) = {
    val p = js.Dynamic.literal()
    onPressIn.foreach(v => p.updateDynamic("onPressIn")(v))
    onPress.foreach(v => p.updateDynamic("onPress")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    onPressOut.foreach(v => p.updateDynamic("onPressOut")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onLongPress.foreach(v => p.updateDynamic("onLongPress")(v))
    underlayColor.foreach(v => p.updateDynamic("underlayColor")(v))
    activeOpacity.foreach(v => p.updateDynamic("activeOpacity")(v))
    animationVelocity.foreach(v => p.updateDynamic("animationVelocity")(v))
    val f = ReactNative.createFactory(ReactNative.TouchableHighlight)
    if (children != null) f(p, children).asInstanceOf[ReactComponentU_]
    else f(p).asInstanceOf[ReactComponentU_]
  }
}

