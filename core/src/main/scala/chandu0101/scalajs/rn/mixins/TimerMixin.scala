package chandu0101.scalajs.rn.mixins

import chandu0101.scalajs.rn
import japgolly.scalajs.react.extra.OnUnmount

import scala.scalajs.js

/**
 *  this mixin depends on js module react-timer-mixin
 *   user must add    "react-timer-mixin": " 0.13.1" dependency to package.json

 */
abstract class TimerMixin extends OnUnmount{
  
  val timerMixin : TimerMixinJS = rn.load[TimerMixinJS]("react-timer-mixin/TimerMixin")

  onUnmount {
    timerMixin.componentWillUnmount()
  }

}

trait TimerMixinJS extends js.Object {
  def setTimeout(fn : js.Function,timeout : Double) : js.Any  = js.native

  def clearTimeout(timeout : js.Any):Unit = js.native

  def componentWillUnmount() : Unit = js.native

}
