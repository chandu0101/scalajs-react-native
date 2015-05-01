package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn._
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/1/15.
 * key: PropTypes.string,
style: PropTypes.object,
    icon: PropTypes.ImageSource.isRequired,
    onPress: PropTypes.func.isRequired,
    selected: PropTypes.bool.isRequired,
    badge: PropTypes.string,
    title: PropTypes.string,

 */


object TabBarItemIOS {


  def apply(onPress: => Unit,
            style: UndefOr[js.Object] = undefined,
            icon: ImageSource,
            selected: Boolean,
            key: UndefOr[String] = undefined,
            badge: UndefOr[String] = undefined,
            title: UndefOr[String] = undefined)(children: ReactNode) = {
    def toJS = {
      val p = js.Dynamic.literal()
      p.updateDynamic("onPress")(() => onPress)
      style.foreach(v => p.updateDynamic("style")(v))
      p.updateDynamic("icon")(icon.toJson)
      p.updateDynamic("selected")(selected)
      key.foreach(v => p.updateDynamic("key")(v))
      badge.foreach(v => p.updateDynamic("badge")(v))
      title.foreach(v => p.updateDynamic("title")(v))
      p
    }
    val f = ReactNative.createFactory(ReactNative.TabBarIOS.asInstanceOf[js.Dynamic].Item.asInstanceOf[js.Object])
    f(toJS, children).asInstanceOf[ReactComponentU_]
  }
}


