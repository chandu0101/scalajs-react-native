package chandu0101.scalajs.rn.components

import scala.scalajs.js.Dynamic.{literal => json}

/**
 * Created by chandrasekharkode on 4/1/15.
 */
case class MapViewRegion(latitude : Double,longitude : Double,latitudeDelta : Double,longitudeDelta : Double) {
  def toJson = json( "latitude" -> latitude , "longitudeDelta" -> longitudeDelta , "latitudeDelta" -> latitudeDelta , "longitude" -> longitude )
}
