package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.{NEvent, ReactNative}
import japgolly.scalajs.react.ReactComponentU_

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 *
 *
 * key: PropTypes.string,
  ref: PropTypes.string,
style: PropTypes.object,
    renderError: PropTypes.func,
    renderLoading: PropTypes.func,
    url: PropTypes.string.isRequired,
    automaticallyAdjustContentInsets: PropTypes.bool,
    shouldInjectAJAXHandler: PropTypes.bool,
    contentInset: EdgeInsetsPropType,
    onNavigationStateChange: PropTypes.func,
    startInLoadingState: PropTypes.bool,

 */


object WebView {


  def apply(url: String,
            ref : UndefOr[String] = undefined,
            style: UndefOr[js.Any] = undefined,
            shouldInjectAJAXHandler: UndefOr[Boolean] = undefined,
            key: UndefOr[String] = undefined,
            onNavigationStateChange: UndefOr[(NavigationState) => _] = undefined,
            renderLoading: UndefOr[js.Function] = undefined,
            automaticallyAdjustContentInsets: UndefOr[Boolean] = undefined,
            renderError: UndefOr[js.Function] = undefined,
            startInLoadingState: UndefOr[Boolean] = undefined) = {
    val p = js.Dynamic.literal()
    p.updateDynamic("url")(url)
    style.foreach(v => p.updateDynamic("style")(v))
    shouldInjectAJAXHandler.foreach(v => p.updateDynamic("shouldInjectAJAXHandler")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    onNavigationStateChange.foreach(v => p.updateDynamic("onNavigationStateChange")(v))
    renderLoading.foreach(v => p.updateDynamic("renderLoading")(v))
    renderError.foreach(v => p.updateDynamic("renderError")(v))
    automaticallyAdjustContentInsets.foreach(v => p.updateDynamic("automaticallyAdjustContentInsets")(v))
    startInLoadingState.foreach(v => p.updateDynamic("startInLoadingState")(v))
    val f = ReactNative.createFactory(ReactNative.WebView)
    f(p).asInstanceOf[ReactComponentU_]
  }
}

trait NavigationState extends js.Object {

  def url: String = js.native
  def title: String = js.native
  def loading: Boolean = js.native
  def canGoBack: Boolean = js.native
  def canGoForward: Boolean = js.native

}

trait WebViewM extends js.Object {

  def reload(): Unit = js.native

  def updateNavigationState(event: NEvent): NavigationState = js.native

  def getWebWiewHandle(): js.Dynamic = js.native

  def goForward(): Unit = js.native

  def goBack(): Unit = js.native

  def onLoadingStart(event: NEvent): Unit = js.native

  def onLoadingError(event: NEvent): Unit = js.native

  def onLoadingFinish(event: NEvent): Unit = js.native

}
