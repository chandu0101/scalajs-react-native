package chandu0101.scalajs.rn.apis

import scala.scalajs.js

/**
 * Created by chandrasekharkode on 4/2/15.
 */
trait InteractionManager extends js.Object {

  def runAfterInteractions(callback: js.Function): Unit = js.native

  def createInteractionHandle(): Unit = js.native

  def clearInteractionHandle(handle: Int): Unit = js.native

}
