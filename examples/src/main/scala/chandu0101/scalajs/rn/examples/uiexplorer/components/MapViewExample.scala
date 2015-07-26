package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.rn.{NEvent, ReactNativeComponentB}
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js
import scala.util.Try


object MapViewExample extends UIExample {

  case class StateInput(region: MapViewRegion = MapViewRegion(0.0, 0.0, 0.0, 0.0))

  class BackendInput(t: BackendScope[InputProps, StateInput]) {

    var region = MapViewRegion(0.0, 0.0, 0.0, 0.0)

    def getDouble(str: String) = {
      val doubleOption = Try(str.toDouble).toOption
      doubleOption.getOrElse(0.0)
    }

    def onChangeLatitude(e: NEvent) = {
      region = region.copy(latitude = getDouble(e.nativeEvent.text.toString))
    }

    def onChangeLongitude(e: NEvent) = {
      region = region.copy(longitude = getDouble(e.nativeEvent.text.toString))
    }

    def onChangeLatitudeDelta(e: NEvent) = {
      region = region.copy(latitudeDelta = getDouble(e.nativeEvent.text.toString))
    }

    def onChangeLongitudeDelta(e: NEvent) = {
      region = region.copy(longitudeDelta = getDouble(e.nativeEvent.text.toString))
    }

    def change : Unit = {
      t.modState(_.copy(region = region))
      t.props.onChange(t.state.region)
    }
  }

  val MapRegionInput = ReactNativeComponentB[InputProps]("MapRegionInput")
    .initialState(StateInput())
    .backend(new BackendInput(_))
    .render((P, S, B) => {
    View()(
      View(style = styles.row)(
        Text()("Latitude"),
        TextInput(value = S.region.latitude.toString,
          style = styles.textInput,
          onChange = B.onChangeLatitude _,
          selectTextOnFocus = true)()),
      View(style = styles.row)(
        Text()("Longitude"),
        TextInput(value = S.region.longitude.toString,
          style = styles.textInput,
          onChange = B.onChangeLongitude _,
          selectTextOnFocus = true)()),
      View(style = styles.row)(
        Text()("Latitude delta"),
        TextInput(value = S.region.latitudeDelta.toString,
          style = styles.textInput,
          onChange = B.onChangeLatitudeDelta _,
          selectTextOnFocus = true)()),
      View(style = styles.row)(
        Text()("Longitude delta"),
        TextInput(value = S.region.longitudeDelta.toString,
          style = styles.textInput,
          onChange = B.onChangeLongitudeDelta _,
          selectTextOnFocus = true)()
      ),
      View(style = styles.changeButton)(
        Text(onPress = B.change _)("Change")
      )
    )
  })
    .componentWillReceiveProps((scope, nextProps) => {
    val region = if (nextProps.region != null) nextProps.region
    else MapViewRegion(0.0, 0.0, 0.0, 0.0)
    scope.modState(_.copy(region = region))
  })
    .build

  case class InputProps(region: MapViewRegion, onChange: (MapViewRegion) => _)

  case class StateMap(mapRegion: MapViewRegion = MapViewRegion(0.0, 0.0, 0.0, 0.0), mapRegionInput: MapViewRegion = MapViewRegion(0.0, 0.0, 0.0, 0.0), annotations: Seq[MapViewAnnotation] = Seq(), isFirstLoad: Boolean = true)

  class BackendMap(t: BackendScope[_, StateMap]) {

    def getAnnotations(region: MapViewRegion) = {
      Seq(MapViewAnnotation(latitude = region.latitude, longitude = region.longitude, title = "You Are Here"))
    }

    def onRegionChange(region: MapViewRegion) = {
      t.modState(_.copy(mapRegionInput = region))
    }

    def onRegionChangeComplete(region: MapViewRegion) = {
      if (t.state.isFirstLoad) t.modState(_.copy(
        mapRegionInput = region,
        annotations = getAnnotations(region),
        isFirstLoad = false
      ))
    }

    def onRegionInputChanged(region: MapViewRegion) = {
      t.modState(_.copy(mapRegion = region, mapRegionInput = region, annotations = getAnnotations(region)))
    }

  }

  val MapExample = ReactNativeComponentB[Unit]("MapExample")
    .initialState(StateMap())
    .backend(new BackendMap(_))
    .render((P, S, B) => {
    View()(
      MapView(style = styles.map,
        onRegionChange = B.onRegionChange _,
        onRegionChangeComplete = B.onRegionChangeComplete _,
        region = S.mapRegion,
        annotations = S.annotations
      ),
      MapRegionInput(InputProps(onChange = B.onRegionInputChanged _, region = S.mapRegionInput))
    )
  }).buildU

  val component = ReactNativeComponentB[Unit]("MapViewExample")
    .render(P => {
    UIExplorerPage(
      UIExplorerBlock("Map")(
        MapExample()
      ),
      UIExplorerBlock("Map shows user location")(
        MapView(style = styles.map, showsUserLocation = true)
      )
    )
  }).buildNative

  object styles extends NativeStyleSheet {

    val map = style(height := 150,
      margin := 10,
      borderWidth := 1,
      borderColor := "#000000")

    val row = style(flexDirection.row,
      justifyContent.spaceBetween)

    val textInput = style(width := 150,
      height := 20,
      borderWidth := 0.5,
      borderColor := "#aaaaaa",
      fontSize := 13,
      padding := 4)

    val changeButton = style(
      alignSelf.center,
      marginTop := 5,
      padding := 3,
      borderWidth := 0.5,
      borderColor := "#777777"
    )

  }

  override def title: String = "MapView"

  override def description: String = "Base component to display maps"
}
