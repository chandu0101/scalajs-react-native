package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 3/31/15.
 *
 * key: PropTypes.string,
style: PropTypes.object,
  accessible: PropTypes.bool,
    accessibilityLabel: PropTypes.string,
    testID: PropTypes.string,
    onMoveShouldSetResponder: PropTypes.func,
    onResponderGrant: PropTypes.func,
    onResponderMove: PropTypes.func,
    onResponderReject: PropTypes.func,
    onResponderRelease: PropTypes.func,
    onResponderTerminate: PropTypes.func,
    onResponderTerminationRequest: PropTypes.func,
    onStartShouldSetResponder: PropTypes.func,
    onStartShouldSetResponderCapture: PropTypes.func,
    pointerEvents: PropTypes.string,
    removeClippedSubviews: PropTypes.bool,

 */



case class View(onResponderReject : UndefOr[js.Function] = undefined ,
                onStartShouldSetResponder : UndefOr[js.Function] = undefined ,
                onResponderRelease : UndefOr[js.Function] = undefined ,
                onResponderMove : UndefOr[js.Function] = undefined ,
                style : UndefOr[js.Any] = undefined,
                accessibilityLabel : UndefOr[String] = undefined,
                onMoveShouldSetResponder : UndefOr[js.Function] = undefined ,
                removeClippedSubviews : UndefOr[Boolean]=undefined,
                key : UndefOr[String] = undefined,
                onResponderTerminationRequest : UndefOr[js.Function] = undefined ,
                testID : UndefOr[String] = undefined,
                pointerEvents : UndefOr[String] = undefined,
                onResponderTerminate : UndefOr[js.Function] = undefined ,
                onStartShouldSetResponderCapture : UndefOr[js.Function] = undefined ,
                onResponderGrant : UndefOr[js.Function] = undefined ,
                accessible : UndefOr[Boolean]=undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    onResponderReject.foreach(v => p.updateDynamic("onResponderReject")(v))
    onStartShouldSetResponder.foreach(v => p.updateDynamic("onStartShouldSetResponder")(v))
    onResponderRelease.foreach(v => p.updateDynamic("onResponderRelease")(v))
    onResponderMove.foreach(v => p.updateDynamic("onResponderMove")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    accessibilityLabel.foreach(v => p.updateDynamic("accessibilityLabel")(v))
    onMoveShouldSetResponder.foreach(v => p.updateDynamic("onMoveShouldSetResponder")(v))
    removeClippedSubviews.foreach(v => p.updateDynamic("removeClippedSubviews")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onResponderTerminationRequest.foreach(v => p.updateDynamic("onResponderTerminationRequest")(v))
    testID.foreach(v => p.updateDynamic("testID")(v))
    pointerEvents.foreach(v => p.updateDynamic("pointerEvents")(v))
    onResponderTerminate.foreach(v => p.updateDynamic("onResponderTerminate")(v))
    onStartShouldSetResponderCapture.foreach(v => p.updateDynamic("onStartShouldSetResponderCapture")(v))
    onResponderGrant.foreach(v => p.updateDynamic("onResponderGrant")(v))
    accessible.foreach(v => p.updateDynamic("accessible")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.View)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


