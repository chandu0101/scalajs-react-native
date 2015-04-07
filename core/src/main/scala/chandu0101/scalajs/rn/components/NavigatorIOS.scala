package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/1/15.
 *
 *
key: PropTypes.string,
  itemWrapperStyle: View.propTypes.style,
    tintColor: PropTypes.string,
initialRoute:PropTypes.NavigatorIOSRoute
 */


object NavigatorIOS {

  def apply(key: UndefOr[String] = undefined,
            style: UndefOr[js.Object] = undefined,
            tintColor: UndefOr[String] = undefined,
            initialRoute: UndefOr[NavigatorIOSRoute] = undefined) = {
    def toJS = {
      val p = js.Dynamic.literal()
      key.foreach(v => p.updateDynamic("key")(v))
      style.foreach(v => p.updateDynamic("style")(v))
      tintColor.foreach(v => p.updateDynamic("tintColor")(v))
      initialRoute.foreach(v => p.updateDynamic("initialRoute")(v.toJson))
      p
    }
    val f = ReactNative.createFactory(ReactNative.NavigatorIOS)
    f(toJS).asInstanceOf[ReactComponentU_]
  }
}
     