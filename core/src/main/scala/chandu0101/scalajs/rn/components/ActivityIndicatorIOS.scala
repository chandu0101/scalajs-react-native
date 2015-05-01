package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.ReactComponentU_

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 3/31/15.
 *
 *  key: PropTypes.string,
 *  style: PropTypes.dynamic,
    animating: PropTypes.bool,
    color: PropTypes.string,
    size: PropTypes.string,
 */


object ActivityIndicatorIOS {

  def apply(key : UndefOr[String] = undefined,
            animating : UndefOr[Boolean]=undefined,
            style : UndefOr[js.Any]=undefined,
            color : UndefOr[String] = undefined,
            size : UndefOr[String] = undefined) = {
    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    animating.foreach(v => p.updateDynamic("animating")(v))
    color.foreach(v => p.updateDynamic("color")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    size.foreach(v => p.updateDynamic("size")(v))
    val f = ReactNative.createFactory(ReactNative.ActivityIndicatorIOS)
    f(p).asInstanceOf[ReactComponentU_]
  }
}
     

