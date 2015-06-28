package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactElement, ReactComponentU_}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/1/15.
 *
 * key:PropTypes.string,
   ref:PropTypes.string,
style:PropTypes.js.Any,
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
    contentContainerStyle: PropTypes.object,
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
dataSource: PropTypes.iListViewDataSource.isRequired,
    renderRow: PropTypes.func.isRequired,
    initialListSize: PropTypes.number,
    onEndReached: PropTypes.func,
    onEndReachedThreshold: PropTypes.number,
    pageSize: PropTypes.number,
    renderFooter: PropTypes.func,
    renderHeader: PropTypes.func,
    renderSectionHeader: PropTypes.func,
    scrollRenderAheadDistance:PropTypes.number,
    onChangeVisibleRows: PropTypes.func,
    removeClippedSubviews: PropTypes.bool,
 renderSeparator:PropTypes.(String,String,Boolean) => ReactElement
 */


object ListView {


  def apply[T,H ](zoomScale: UndefOr[Int] = undefined,
               scrollRenderAheadDistance: UndefOr[Int] = undefined,
               renderFooter: UndefOr[() => _] = undefined,
               renderSeparator: UndefOr[(String,String,Boolean) => ReactElement] = undefined,
               contentContainerStyle: UndefOr[js.Object] = undefined,
               alwaysBounceVertical: UndefOr[Boolean] = undefined,
               pageSize: UndefOr[Int] = undefined,
               decelerationRate: UndefOr[Int] = undefined,
               minimumZoomScale: UndefOr[Int] = undefined,
               scrollsToTop: UndefOr[Boolean] = undefined,
               renderHeader: UndefOr[() => _] = undefined,
               keyboardDismissMode: UndefOr[String] = undefined,
               style: UndefOr[js.Any] = undefined,
               renderRow: (T,String,String) => _,
               horizontal: UndefOr[Boolean] = undefined,
               centerContent: UndefOr[Boolean] = undefined,
               removeClippedSubviews: UndefOr[Boolean] = undefined,
               onEndReachedThreshold: UndefOr[Int] = undefined,
               onScroll: UndefOr[js.Function] = undefined,
               dataSource: ListViewDataSource[T],
               throttleScrollCallbackMS: UndefOr[Int] = undefined,
               showsHorizontalScrollIndicator: UndefOr[Boolean] = undefined,
               key: UndefOr[String] = undefined,
               scrollEnabled: UndefOr[Boolean] = undefined,
               alwaysBounceHorizontal: UndefOr[Boolean] = undefined,
               maximumZoomScale: UndefOr[Int] = undefined,
               onEndReached: UndefOr[() => _] = undefined,
               automaticallyAdjustContentInsets: UndefOr[Boolean] = undefined,
               initialListSize: UndefOr[Int] = undefined,
               onScrollAnimationEnd: UndefOr[js.Function] = undefined,
               stickyHeaderIndices: UndefOr[js.Array[Int]] = undefined,
               keyboardShouldPersistTaps: UndefOr[Boolean] = undefined,
               onChangeVisibleRows: UndefOr[js.Function] = undefined,
               pagingEnabled: UndefOr[Boolean] = undefined,
               ref: UndefOr[String] = undefined,
               renderSectionHeader: UndefOr[(H,H) => js.Object] = undefined,
               showsVerticalScrollIndicator: UndefOr[Boolean] = undefined) = {
    def toJS = {
      val p = js.Dynamic.literal()
      zoomScale.foreach(v => p.updateDynamic("zoomScale")(v))
      scrollRenderAheadDistance.foreach(v => p.updateDynamic("scrollRenderAheadDistance")(v))
      renderFooter.foreach(v => p.updateDynamic("renderFooter")(v))
      ref.foreach(v => p.updateDynamic("ref")(v))
      contentContainerStyle.foreach(v => p.updateDynamic("contentContainerStyle")(v))
      alwaysBounceVertical.foreach(v => p.updateDynamic("alwaysBounceVertical")(v))
      pageSize.foreach(v => p.updateDynamic("pageSize")(v))
      decelerationRate.foreach(v => p.updateDynamic("decelerationRate")(v))
      minimumZoomScale.foreach(v => p.updateDynamic("minimumZoomScale")(v))
      scrollsToTop.foreach(v => p.updateDynamic("scrollsToTop")(v))
      renderHeader.foreach(v => p.updateDynamic("renderHeader")(v))
      keyboardDismissMode.foreach(v => p.updateDynamic("keyboardDismissMode")(v))
      style.foreach(v => p.updateDynamic("style")(v))
      p.updateDynamic("renderRow")(renderRow)
      horizontal.foreach(v => p.updateDynamic("horizontal")(v))
      centerContent.foreach(v => p.updateDynamic("centerContent")(v))
      removeClippedSubviews.foreach(v => p.updateDynamic("removeClippedSubviews")(v))
      onEndReachedThreshold.foreach(v => p.updateDynamic("onEndReachedThreshold")(v))
      onScroll.foreach(v => p.updateDynamic("onScroll")(v))
      p.updateDynamic("dataSource")(dataSource)
      throttleScrollCallbackMS.foreach(v => p.updateDynamic("throttleScrollCallbackMS")(v))
      showsHorizontalScrollIndicator.foreach(v => p.updateDynamic("showsHorizontalScrollIndicator")(v))
      key.foreach(v => p.updateDynamic("key")(v))
      scrollEnabled.foreach(v => p.updateDynamic("scrollEnabled")(v))
      alwaysBounceHorizontal.foreach(v => p.updateDynamic("alwaysBounceHorizontal")(v))
      maximumZoomScale.foreach(v => p.updateDynamic("maximumZoomScale")(v))
      onEndReached.foreach(v => p.updateDynamic("onEndReached")(v))
      automaticallyAdjustContentInsets.foreach(v => p.updateDynamic("automaticallyAdjustContentInsets")(v))
      initialListSize.foreach(v => p.updateDynamic("initialListSize")(v))
      onScrollAnimationEnd.foreach(v => p.updateDynamic("onScrollAnimationEnd")(v))
      stickyHeaderIndices.foreach(v => p.updateDynamic("stickyHeaderIndices")(v))
      keyboardShouldPersistTaps.foreach(v => p.updateDynamic("keyboardShouldPersistTaps")(v))
      onChangeVisibleRows.foreach(v => p.updateDynamic("onChangeVisibleRows")(v))
      pagingEnabled.foreach(v => p.updateDynamic("pagingEnabled")(v))
      renderSectionHeader.foreach(v => p.updateDynamic("renderSectionHeader")(v))
      renderSeparator.foreach(v => p.updateDynamic("renderSeparator")(v))
      showsVerticalScrollIndicator.foreach(v => p.updateDynamic("showsVerticalScrollIndicator")(v))
      p
    }
    val f = ReactNative.createFactory(ReactNative.ListView)
    f(toJS).asInstanceOf[ReactComponentU_]
  }

}


trait ListViewM extends js.Object {

  def getScrollResponder(): ScrollViewM = js.native

}