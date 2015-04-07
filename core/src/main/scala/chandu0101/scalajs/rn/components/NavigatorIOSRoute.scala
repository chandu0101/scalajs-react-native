package chandu0101.scalajs.rn.components

import japgolly.scalajs.react.ReactComponentB.P
import japgolly.scalajs.react.ReactComponentType

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.{UndefOr, undefined}


/**
 * Created by chandrasekharkode on 4/1/15.
 */
case class NavigatorIOSRoute(onRightButtonPress: UndefOr[js.Function] = undefined,
                             passProps: UndefOr[js.Object] = undefined,
                             rightButtonTitle: UndefOr[String] = undefined,
                             wrapperStyle: UndefOr[js.Object] = undefined,
                             backButtonTitle: UndefOr[String] = undefined,
                             title: String,
                             component: js.Object) {
  def toJson = json("backButtonTitle" -> backButtonTitle, "rightButtonTitle" -> rightButtonTitle, "component" -> component, "wrapperStyle" -> wrapperStyle, "title" -> title, "passProps" -> passProps, "onRightButtonPress" -> onRightButtonPress)
}
