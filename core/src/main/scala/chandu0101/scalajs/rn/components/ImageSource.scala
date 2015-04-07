package chandu0101.scalajs.rn.components
import scalajs.js.Dynamic.{literal => json}

/**
 * Created by chandrasekharkode on 4/1/15.
 */
case class ImageSource(uri : String,isStatic : Boolean = true) {
 def toJson = json("uri" -> uri,"isStatic" -> isStatic)
}
