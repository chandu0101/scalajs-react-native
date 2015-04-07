package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 3/31/15.
 *
 * key: PropTypes.string,
style: PropTypes.object,
    renderError: PropTypes.func.isRequired,
    renderLoading: PropTypes.func.isRequired,
    url: PropTypes.string.isRequired,
    automaticallyAdjustContentInsets: PropTypes.bool,
    shouldInjectAJAXHandler: PropTypes.bool,
    contentInset: EdgeInsetsPropType,
    onNavigationStateChange: PropTypes.func,
    startInLoadingState: PropTypes.bool,

 */


case class WebView(url: String,
                   style: UndefOr[js.Object] = undefined,
                   shouldInjectAJAXHandler: UndefOr[Boolean] = undefined,
                   key: UndefOr[String] = undefined,
                   onNavigationStateChange: UndefOr[js.Function] = undefined,
                   renderLoading: js.Function,
                   automaticallyAdjustContentInsets: UndefOr[Boolean] = undefined,
                   renderError: js.Function,
                   startInLoadingState: UndefOr[Boolean] = undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    p.updateDynamic("url")(url)
    style.foreach(v => p.updateDynamic("style")(v))
    shouldInjectAJAXHandler.foreach(v => p.updateDynamic("shouldInjectAJAXHandler")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onNavigationStateChange.foreach(v => p.updateDynamic("onNavigationStateChange")(v))
    p.updateDynamic("renderLoading")(renderLoading)
    automaticallyAdjustContentInsets.foreach(v => p.updateDynamic("automaticallyAdjustContentInsets")(v))
    p.updateDynamic("renderError")(renderError)
    startInLoadingState.foreach(v => p.updateDynamic("startInLoadingState")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.WebView)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
     


