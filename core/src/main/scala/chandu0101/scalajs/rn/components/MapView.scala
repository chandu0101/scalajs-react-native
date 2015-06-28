package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.ReactComponentU_

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
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
    onRegionChange: PropTypes.(MapViewRegion) => _,
 annotations:PropTypes.js.Array[MapViewAnnotation]
    onRegionChangeComplete: PropTypes.(js.Dynamic) => _,
 */


object MapView {


  def apply(maxDelta: UndefOr[Int] = undefined,
            pitchEnabled: UndefOr[Boolean] = undefined,
            style: UndefOr[js.Any] = undefined,
            legalLabelInsets: UndefOr[EdgeInsets] = undefined,
            onRegionChange: UndefOr[(js.Dynamic) => _] = undefined,
            annotations: UndefOr[js.Array[MapViewAnnotation]] = undefined,
            minDelta: UndefOr[Int] = undefined,
            key: UndefOr[String] = undefined,
            scrollEnabled: UndefOr[Boolean] = undefined,
            rotateEnabled: UndefOr[Boolean] = undefined,
            onRegionChangeComplete: UndefOr[(js.Dynamic) => _] = undefined,
            region: UndefOr[MapViewRegion] = undefined,
            zoomEnabled: UndefOr[Boolean] = undefined,
            showsUserLocation: UndefOr[Boolean] = undefined) = {

    val p = js.Dynamic.literal()
    maxDelta.foreach(v => p.updateDynamic("maxDelta")(v))
    pitchEnabled.foreach(v => p.updateDynamic("pitchEnabled")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    legalLabelInsets.foreach(v => p.updateDynamic("legalLabelInsets")(if (v != null) v.toJson else null))
    annotations.foreach(v => p.updateDynamic("annotations")(v.map(a => a.toJson)))
    onRegionChange.foreach(v => p.updateDynamic("onRegionChange")(v))
    minDelta.foreach(v => p.updateDynamic("minDelta")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    scrollEnabled.foreach(v => p.updateDynamic("scrollEnabled")(v))
    rotateEnabled.foreach(v => p.updateDynamic("rotateEnabled")(v))
    onRegionChangeComplete.foreach(v => p.updateDynamic("onRegionChangeComplete")(v))
    region.foreach(v => p.updateDynamic("region")(if (v != null) if (v != null) v.toJson else null else null))
    zoomEnabled.foreach(v => p.updateDynamic("zoomEnabled")(v))
    showsUserLocation.foreach(v => p.updateDynamic("showsUserLocation")(v))

    val f = ReactNative.createFactory(ReactNative.MapView)

    f(p).asInstanceOf[ReactComponentU_]
  }
}


case class MapViewRegion(latitude: Double, longitude: Double, latitudeDelta: Double, longitudeDelta: Double) {
  def toJson = json("latitude" -> latitude, "longitudeDelta" -> longitudeDelta, "latitudeDelta" -> latitudeDelta, "longitude" -> longitude)
}

object MapViewRegion {
  def fromJson(obj: js.Dynamic) = MapViewRegion(latitude = obj.latitude.asInstanceOf[Double],
    longitudeDelta = obj.longitudeDelta.asInstanceOf[Double],
    latitudeDelta = obj.latitudeDelta.asInstanceOf[Double],
    longitude = obj.longitude.asInstanceOf[Double])
}

case class MapViewAnnotation(latitude: Double, longitude: Double, title: UndefOr[String] = undefined, subTitle: UndefOr[String] = undefined) {
  def toJson = {
    val p = json()
    subTitle.foreach(v => p.updateDynamic("subtitle")(v))
    p.updateDynamic("latitude")(latitude)
    title.foreach(v => p.updateDynamic("title")(v))
    p.updateDynamic("longitude")(longitude)
    p
  }
}

object MapViewAnnotation {
  def fromJson(obj: js.Dynamic) = MapViewAnnotation(subTitle = if (js.isUndefined(obj.subtitle)) js.undefined else obj.subtitle.asInstanceOf[String],
    latitude = obj.latitude.asInstanceOf[Double],
    title = if (js.isUndefined(obj.title)) js.undefined else obj.title.asInstanceOf[String],
    longitude = obj.longitude.asInstanceOf[Double])
}