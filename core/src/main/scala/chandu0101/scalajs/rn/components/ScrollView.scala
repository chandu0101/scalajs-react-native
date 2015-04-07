package chandu0101.scalajs.rn.components

import chandu0101.scalajs
import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/1/15.
 *
 * key:PropTypes.string,
style:PropTypes.Dynamic
automaticallyAdjustContentInsets: PropTypes.bool,
    contentInset: EdgeInsetsPropType,
    contentOffset: PointPropType,
    onScroll: PropTypes.func,
    onScrollAnimationEnd: PropTypes.func,
    scrollEnabled: PropTypes.bool,
    scrollIndicatorInsets: EdgeInsetsPropType,
    showsHorizontalScrollIndicator: PropTypes.bool,
    showsVerticalScrollIndicator: PropTypes.bool,
    throttleScrollCallbackMS: PropTypes.number,
    alwaysBounceHorizontal: PropTypes.bool,
    alwaysBounceVertical: PropTypes.bool,
    centerContent: PropTypes.bool,
    contentContainerStyle: PropTypes.Dynamic,
    decelerationRate: PropTypes.number,
    horizontal: PropTypes.bool,
    keyboardDismissMode: PropTypes.string,
    keyboardShouldPersistTaps: PropTypes.bool,
    maximumZoomScale: PropTypes.number,
    minimumZoomScale: PropTypes.number,
    pagingEnabled: PropTypes.bool,
    scrollsToTop: PropTypes.bool,
    stickyHeaderIndices: PropTypes.arrayOf(PropTypes.number),
    removeClippedSubviews: PropTypes.bool,
    zoomScale: PropTypes.number,
 */


case class ScrollView(zoomScale : UndefOr[Int] = undefined,
                      contentContainerStyle : UndefOr[js.Dynamic] = undefined,
                      alwaysBounceVertical : UndefOr[Boolean]=undefined,
                      decelerationRate : UndefOr[Int] = undefined,
                      minimumZoomScale : UndefOr[Int] = undefined,
                      scrollsToTop : UndefOr[Boolean]=undefined,
                      keyboardDismissMode : UndefOr[String] = undefined,
                      style : UndefOr[js.Dynamic] = undefined,
                      horizontal : UndefOr[Boolean]=undefined,
                      centerContent : UndefOr[Boolean]=undefined,
                      removeClippedSubviews : UndefOr[Boolean]=undefined,
                      onScroll : UndefOr[js.Function] = undefined ,
                      throttleScrollCallbackMS : UndefOr[Int] = undefined,
                      showsHorizontalScrollIndicator : UndefOr[Boolean]=undefined,
                      key : UndefOr[String] = undefined,
                      scrollEnabled : UndefOr[Boolean]=undefined,
                      alwaysBounceHorizontal : UndefOr[Boolean]=undefined,
                      maximumZoomScale : UndefOr[Int] = undefined,
                      automaticallyAdjustContentInsets : UndefOr[Boolean]=undefined,
                      onScrollAnimationEnd : UndefOr[js.Function] = undefined ,
                      stickyHeaderIndices :  UndefOr[js.Array[Int]] = undefined,
                      keyboardShouldPersistTaps : UndefOr[Boolean]=undefined,
                      pagingEnabled : UndefOr[Boolean]=undefined,
                      showsVerticalScrollIndicator : UndefOr[Boolean]=undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    zoomScale.foreach(v => p.updateDynamic("zoomScale")(v))
    contentContainerStyle.foreach(v => p.updateDynamic("contentContainerStyle")(v))
    alwaysBounceVertical.foreach(v => p.updateDynamic("alwaysBounceVertical")(v))
    decelerationRate.foreach(v => p.updateDynamic("decelerationRate")(v))
    minimumZoomScale.foreach(v => p.updateDynamic("minimumZoomScale")(v))
    scrollsToTop.foreach(v => p.updateDynamic("scrollsToTop")(v))
    keyboardDismissMode.foreach(v => p.updateDynamic("keyboardDismissMode")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    horizontal.foreach(v => p.updateDynamic("horizontal")(v))
    centerContent.foreach(v => p.updateDynamic("centerContent")(v))
    removeClippedSubviews.foreach(v => p.updateDynamic("removeClippedSubviews")(v))
    onScroll.foreach(v => p.updateDynamic("onScroll")(v))
    throttleScrollCallbackMS.foreach(v => p.updateDynamic("throttleScrollCallbackMS")(v))
    showsHorizontalScrollIndicator.foreach(v => p.updateDynamic("showsHorizontalScrollIndicator")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    scrollEnabled.foreach(v => p.updateDynamic("scrollEnabled")(v))
    alwaysBounceHorizontal.foreach(v => p.updateDynamic("alwaysBounceHorizontal")(v))
    maximumZoomScale.foreach(v => p.updateDynamic("maximumZoomScale")(v))
    automaticallyAdjustContentInsets.foreach(v => p.updateDynamic("automaticallyAdjustContentInsets")(v))
    onScrollAnimationEnd.foreach(v => p.updateDynamic("onScrollAnimationEnd")(v))
    stickyHeaderIndices.foreach(v => p.updateDynamic("stickyHeaderIndices")(v))
    keyboardShouldPersistTaps.foreach(v => p.updateDynamic("keyboardShouldPersistTaps")(v))
    pagingEnabled.foreach(v => p.updateDynamic("pagingEnabled")(v))
    showsVerticalScrollIndicator.foreach(v => p.updateDynamic("showsVerticalScrollIndicator")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.ScrollView)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
     
