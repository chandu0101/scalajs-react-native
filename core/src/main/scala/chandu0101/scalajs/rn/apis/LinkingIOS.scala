package chandu0101.scalajs.rn.apis

import scala.scalajs.js

/**
 * Created by chandrasekharkode on 4/2/15.
 */
trait LinkingIOS extends js.Object {

  def addEventListener(tpe : String,handler : js.Function):Unit = js.native
  def removeEventListener(tpe : String,handler : js.Function):Unit = js.native
  def openURL(url : String):Unit = js.native
  def popInitialURL():Unit = js.native
  def canOpenURL(url : String, callback : js.Function):Unit = js.native

}
