package chandu0101.scalajs.rn.components

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.{UndefOr, undefined}



case class NavigatorIOSRoute(onRightButtonPress: UndefOr[js.Function] = undefined,
                             passProps: UndefOr[js.Any] = undefined,
                             rightButtonTitle: UndefOr[String] = undefined,
                             wrapperStyle: UndefOr[js.Object] = undefined,
                             backButtonTitle: UndefOr[String] = undefined,
                             title: String,
                             component: js.Object) {
  def toJson = {
    val p = json()
    p.updateDynamic("component")(component)
    p.updateDynamic("title")(title)
    passProps.foreach(v => p.updateDynamic("passProps")(v))
    rightButtonTitle.foreach(v => p.updateDynamic("rightButtonTitle")(v))
    onRightButtonPress.foreach(v => p.updateDynamic("onRightButtonPress")(v))
    wrapperStyle.foreach(v => p.updateDynamic("wrapperStyle")(v))
    backButtonTitle.foreach(v => p.updateDynamic("backButtonTitle")(v))
    p
  }
}
