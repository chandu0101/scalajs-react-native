package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactNode, ReactComponentU_}

import scala.scalajs.js
import scala.scalajs.js.{undefined, UndefOr}

/**
 * Created by chandrasekharkode on 4/2/15.
 *
 *  key: PropTypes.string,
    onPress: PropTypes.func,
    onPressIn: PropTypes.func,
    onPressOut: PropTypes.func,
    onLongPress: PropTypes.func,
    activeOpacity:PropTypes.number,
 */

case class TouchableOpacity(onPressIn : UndefOr[js.Function] = undefined ,
                            onPress : UndefOr[js.Function] = undefined ,
                            onPressOut : UndefOr[js.Function] = undefined ,
                            key : UndefOr[String] = undefined,
                            onLongPress : UndefOr[js.Function] = undefined ,
                            activeOpacity : UndefOr[Int] = undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    onPressIn.foreach(v => p.updateDynamic("onPressIn")(v))
    onPress.foreach(v => p.updateDynamic("onPress")(v))
    onPressOut.foreach(v => p.updateDynamic("onPressOut")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onLongPress.foreach(v => p.updateDynamic("onLongPress")(v))
    activeOpacity.foreach(v => p.updateDynamic("activeOpacity")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.TouchableOpacity)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
     