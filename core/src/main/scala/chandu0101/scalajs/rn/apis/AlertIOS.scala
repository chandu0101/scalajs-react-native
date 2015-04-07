package chandu0101.scalajs.rn.apis

import scala.scalajs.js

/**
 * Created by chandrasekharkode on 4/1/15.
 */
trait AlertIOS extends js.Object{

  def alert(title : String = ???, message : String = ??? ,buttons :js.Array[AlertButton] = ???):Unit = js.native

}

class AlertButton extends js.Object {
  def this(text : String = ???,onPress : js.Function = ???) = this()
}