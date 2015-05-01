package chandu0101.scalajs.rn.apis

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}


trait AlertIOS extends js.Object{

  def alert(title : String = ???, message : String = ??? ,buttons :js.Array[js.Object] = ???):Unit = js.native

}



case class AlertButton(text : String,onPress : js.Function) {
  def toJson = json(text = text,onPress = onPress)
}