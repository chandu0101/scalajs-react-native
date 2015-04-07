package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn._
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 3/31/15.
 *
 * key: PropTypes.string,
style: PropTypes.Dynamic,
     numberOfLines: PropTypes.number,
    onPress: PropTypes.func,
    suppressHighlighting: PropTypes.bool,
    testID: PropTypes.string,

 */

case class Text(suppressHighlighting: UndefOr[Boolean] = undefined,
                onPress: UndefOr[js.Function] = undefined,
                style: UndefOr[js.Dynamic] = undefined,
                numberOfLines: UndefOr[Int] = undefined,
                key: UndefOr[String] = undefined,
                testID: UndefOr[String] = undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    suppressHighlighting.foreach(v => p.updateDynamic("suppressHighlighting")(v))
    onPress.foreach(v => p.updateDynamic("onPress")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    numberOfLines.foreach(v => p.updateDynamic("numberOfLines")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    testID.foreach(v => p.updateDynamic("testID")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.Text)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

