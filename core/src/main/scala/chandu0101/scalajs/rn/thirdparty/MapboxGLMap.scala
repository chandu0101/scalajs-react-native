package chandu0101.scalajs.rn.thirdparty

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNative
import chandu0101.scalajs.rn.components._
import japgolly.scalajs.react.ReactComponentU_

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.{UndefOr, undefined}

/**
 *  follow instructions from https://github.com/bsudekum/react-native-mapbox-gl
 *
 *  key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
      showsUserLocation: PropTypes.bool,
    rotateEnabled: PropTypes.bool,
    accessToken: PropTypes.string.isRequired,
    zoomLevel: PropTypes.number,
    direction: PropTypes.number,
    styleURL: PropTypes.string,
    clipsToBounds: PropTypes.bool,
    debugActive: PropTypes.bool,
    centerCoordinate:PropTypes.CenterCoordinate,
    annotations: PropTypes.MapViewAnnotation,
    onRegionChange: PropTypes.js.Object => _,
    onOpenAnnotation: PropTypes.MapViewAnnotation => _
 */
object MapBoxGLMap {

  def apply(style: UndefOr[js.Any] = undefined,
            onOpenAnnotation: UndefOr[MapViewAnnotation => _] = undefined,
            onRegionChange: UndefOr[js.Object => _] = undefined,
            centerCoordinate: UndefOr[CenterCoordinate] = undefined,
            zoomLevel: UndefOr[Int] = undefined,
            ref: UndefOr[String] = undefined,
            direction: UndefOr[Int] = undefined,
            debugActive: UndefOr[Boolean] = undefined,
            key: UndefOr[String] = undefined,
            styleURL: UndefOr[String] = undefined,
            annotations: UndefOr[js.Array[MapViewAnnotation]] = undefined,
            rotateEnabled: UndefOr[Boolean] = undefined,
            clipsToBounds: UndefOr[Boolean] = undefined,
            showsUserLocation: UndefOr[Boolean] = undefined,
            accessToken: String) = {

    val p = js.Dynamic.literal()
    style.foreach(v => p.updateDynamic("style")(v))
    onOpenAnnotation.foreach(v => p.updateDynamic("onOpenAnnotation")(v))
    onRegionChange.foreach(v => p.updateDynamic("onRegionChange")(v))
    centerCoordinate.foreach(v => p.updateDynamic("centerCoordinate")(if (v != null) v.toJson else null))
    zoomLevel.foreach(v => p.updateDynamic("zoomLevel")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    direction.foreach(v => p.updateDynamic("direction")(v))
    debugActive.foreach(v => p.updateDynamic("debugActive")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    styleURL.foreach(v => p.updateDynamic("styleURL")(v))
    annotations.foreach(v => p.updateDynamic("annotations")(v.map(a => a.toJson)))
    rotateEnabled.foreach(v => p.updateDynamic("rotateEnabled")(v))
    clipsToBounds.foreach(v => p.updateDynamic("clipsToBounds")(v))
    showsUserLocation.foreach(v => p.updateDynamic("showsUserLocation")(v))
    p.updateDynamic("accessToken")(accessToken)
//    val MapBox = js.Dynamic.global.require("react-native-mapbox-gl")
    val f = ReactNative.createFactory(rn.load[js.Object]("react-native-mapbox-gl"))
    f(p).asInstanceOf[ReactComponentU_]

  }

}


case class CenterCoordinate(latitude: Double, longitude: Double) {
  def toJson = {
    val p = json()
    p.updateDynamic("latitude")(latitude)
    p.updateDynamic("longitude")(longitude)
    p
  }
}

object CenterCoordinate {
  def fromJson(obj: js.Dynamic) = CenterCoordinate(latitude = obj.latitude.asInstanceOf[Double], longitude = obj.longitude.asInstanceOf[Double])
}