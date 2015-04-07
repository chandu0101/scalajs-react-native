package chandu0101.scalajs.rn.apis

import scala.scalajs.js

/**
 * Created by chandrasekharkode on 4/2/15.
 */
trait CameraRoll extends js.Object{

  def saveImageWithTag(tag :String,successCallback : js.Function,errorCallback : js.Function):Unit = js.native
  def getPhotos(params : js.Object,callback : js.Function,errorCallback : js.Function):Unit = js.native

}
