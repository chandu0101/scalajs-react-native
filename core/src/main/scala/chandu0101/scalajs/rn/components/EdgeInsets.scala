package chandu0101.scalajs.rn.components

import scala.scalajs.js.Dynamic.{literal => json}

/**
 * Created by chandrasekharkode on 4/1/15.
 */
case class EdgeInsets(top : Double,left : Double,bottom : Double,right : Double) {
  def toJson = json( "bottom" -> bottom , "top" -> top , "left" -> left , "right" -> right )
}
