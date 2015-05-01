package chandu0101.scalajs.rn.apis

import scala.scalajs.js


trait Animation extends js.Object {

  def startAnimation(node : Any,duration : Int,delay : Int,easing : String,properties : js.Dictionary[Any]):Int = js.native

  def stopAnimation(tag : Int): Unit = js.native

}
