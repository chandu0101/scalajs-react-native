package chandu0101.scalajs.rn.apis

import scala.scalajs.js

/**
 * Created by chandrasekharkode on 4/2/15.
 */
trait AppStateIOS extends js.Object {

  def addEventListener(tpe :String,handler : js.Function):Unit = js.native
  def removeEventListener(tpe :String,handler : js.Function):Unit = js.native

}
