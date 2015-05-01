package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.ReactComponentU_

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}
/**
 * Created by chandrasekharkode on 4/1/15.
 *
 *  key: PropTypes.string,
    style: PropTypes.Any,
    source: PropTypes.ImageSource,
    accessible: PropTypes.bool,
    accessibilityLabel: PropTypes.string,
    capInsets: EdgeInsetsPropType,
    testID: PropTypes.string,
 */


object Image {

  def apply(source : UndefOr[ImageSource] = undefined,
            style : UndefOr[js.Any] = undefined,
            accessibilityLabel : UndefOr[String] = undefined,
            key : UndefOr[String] = undefined,
            testID : UndefOr[String] = undefined,
            accessible : UndefOr[Boolean]=undefined) = {
    def toJS = {
      val p = js.Dynamic.literal()
      source.foreach(v => p.updateDynamic("source")(if(v != null) v.toJson else null))
      style.foreach(v => p.updateDynamic("style")(v))
      accessibilityLabel.foreach(v => p.updateDynamic("accessibilityLabel")(v))
      key.foreach(v => p.updateDynamic("key")(v))
      testID.foreach(v => p.updateDynamic("testID")(v))
      accessible.foreach(v => p.updateDynamic("accessible")(v))
      p
    }
    val f = ReactNative.createFactory(ReactNative.Image)
    f(toJS).asInstanceOf[ReactComponentU_]
  }
}
     
