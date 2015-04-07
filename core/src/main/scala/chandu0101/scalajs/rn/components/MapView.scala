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
 *
key: PropTypes.string,
style: PropTypes.object,
  showsUserLocation: PropTypes.bool,
    zoomEnabled: PropTypes.bool,
    rotateEnabled: PropTypes.bool,
    pitchEnabled: PropTypes.bool,
    scrollEnabled: PropTypes.bool,
    region:PropTypes.MapViewRegion,
    maxDelta: PropTypes.number,
    minDelta: PropTypes.number,
    legalLabelInsets: PropTypes.EdgeInsets,
    onRegionChange: PropTypes.func,
    onRegionChangeComplete: PropTypes.func,    
 */



case class MapView(maxDelta : UndefOr[Int] = undefined,
                   pitchEnabled : UndefOr[Boolean]=undefined,
                   style : UndefOr[js.Object] = undefined,
                   legalLabelInsets : UndefOr[EdgeInsets] = undefined,
                   onRegionChange : UndefOr[js.Function] = undefined ,
                   minDelta : UndefOr[Int] = undefined,
                   key : UndefOr[String] = undefined,
                   scrollEnabled : UndefOr[Boolean]=undefined,
                   rotateEnabled : UndefOr[Boolean]=undefined,
                   onRegionChangeComplete : UndefOr[js.Function] = undefined ,
                   region : UndefOr[MapViewRegion] = undefined,
                   zoomEnabled : UndefOr[Boolean]=undefined,
                   showsUserLocation : UndefOr[Boolean]=undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    maxDelta.foreach(v => p.updateDynamic("maxDelta")(v))
    pitchEnabled.foreach(v => p.updateDynamic("pitchEnabled")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    legalLabelInsets.foreach(v => p.updateDynamic("legalLabelInsets")(v.toJson))
    onRegionChange.foreach(v => p.updateDynamic("onRegionChange")(v))
    minDelta.foreach(v => p.updateDynamic("minDelta")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    scrollEnabled.foreach(v => p.updateDynamic("scrollEnabled")(v))
    rotateEnabled.foreach(v => p.updateDynamic("rotateEnabled")(v))
    onRegionChangeComplete.foreach(v => p.updateDynamic("onRegionChangeComplete")(v))
    region.foreach(v => p.updateDynamic("region")(v.toJson))
    zoomEnabled.foreach(v => p.updateDynamic("zoomEnabled")(v))
    showsUserLocation.foreach(v => p.updateDynamic("showsUserLocation")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.MapView)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


