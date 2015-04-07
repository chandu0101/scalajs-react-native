package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn
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
   underlayColor: PropTypes.string,
   onPress: PropTypes.func,
   onPressIn: PropTypes.func,
   onPressOut: PropTypes.func,
   onLongPress: PropTypes.func,
 */


case class TouchableHighlight(onPressIn: UndefOr[js.Function] = undefined,
                              onPress: UndefOr[js.Function] = undefined,
                              style: UndefOr[js.Object] = undefined,
                              onPressOut: UndefOr[js.Function] = undefined,
                              key: UndefOr[String] = undefined,
                              onLongPress: UndefOr[js.Function] = undefined,
                              underlayColor: UndefOr[String] = undefined,
                              activeOpacity: UndefOr[Int] = undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    onPressIn.foreach(v => p.updateDynamic("onPressIn")(v))
    onPress.foreach(v => p.updateDynamic("onPress")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    onPressOut.foreach(v => p.updateDynamic("onPressOut")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onLongPress.foreach(v => p.updateDynamic("onLongPress")(v))
    underlayColor.foreach(v => p.updateDynamic("underlayColor")(v))
    activeOpacity.foreach(v => p.updateDynamic("activeOpacity")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.TouchableHighlight)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

