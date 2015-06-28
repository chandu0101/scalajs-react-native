package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/2/15.
 *
 *  key: PropTypes.string,
   style: PropTypes.js.Any,
   activeOpacity: PropTypes.number,
   animationVelocity: PropTypes.number,
   underlayColor: PropTypes.string,
   onPress: PropTypes.() => Unit,
   onPressIn: PropTypes.() => Unit,
   onPressOut: PropTypes.() => Unit,
   onLongPress: PropTypes.() => Unit,
    activeOpacity:PropTypes.number,
 */



case class TouchableOpacity(onPressIn : js.UndefOr[() => Unit] = js.undefined,
                            onPress : js.UndefOr[() => Unit] = js.undefined,
                            style : js.UndefOr[js.Any] = js.undefined,
                            onPressOut : js.UndefOr[() => Unit] = js.undefined,
                            key : js.UndefOr[String] = js.undefined,
                            animationVelocity : js.UndefOr[Int] = js.undefined,
                            onLongPress : js.UndefOr[() => Unit] = js.undefined,
                            underlayColor : js.UndefOr[String] = js.undefined,
                            activeOpacity : js.UndefOr[Int] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    onPressIn.foreach(v => p.updateDynamic("onPressIn")(v))
    onPress.foreach(v => p.updateDynamic("onPress")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    onPressOut.foreach(v => p.updateDynamic("onPressOut")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    animationVelocity.foreach(v => p.updateDynamic("animationVelocity")(v))
    onLongPress.foreach(v => p.updateDynamic("onLongPress")(v))
    underlayColor.foreach(v => p.updateDynamic("underlayColor")(v))
    activeOpacity.foreach(v => p.updateDynamic("activeOpacity")(v))
    p
  }

  def apply(children : ReactNode) = {
    val f = ReactNative.createFactory(ReactNative.TouchableOpacity)
    f(toJS,children).asInstanceOf[ReactComponentU_]
  }
}
