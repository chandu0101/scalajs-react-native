package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.components._
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav


object CameraRollView {

  type CImage = js.Dynamic


  def renderImage(asset : CImage) = {
    Image(source = ImageSource.fromJson(asset.node.image) ,style = styles.image)
  }

  def rowHasChanged(r1 : js.Array[CImage] ,r2 : js.Array[CImage]) = {
    r1.length != r2.length || r1.zipWithIndex.forall { case (image,index) => r2(index) == image}
  }

  case class State(assets : js.Array[CImage] = js.Array(),groupType : String ,lastCursor : String = null,noMore : Boolean = false,loadingMore : Boolean = false, dataSource: ListViewDataSource[js.Array[CImage]] = createListViewDataSource(rowHasChanged = rowHasChanged))

  class Backend(t: BackendScope[Props, State]) {

    /**
     * This should be called when the image renderer is changed to tell the
     * component to re-render its assets.
     */
    def rendererChanged = {
      val ds : ListViewDataSource[js.Array[CImage]] = createListViewDataSource(rowHasChanged = rowHasChanged)
      val rows = t.state.assets.grouped(t.props.imagesPerRow).toJSArray
      t.modState(_.copy(dataSource = ds.cloneWithRows(rows)))
    }

    def appendAssets(data : js.Dynamic) = {
      var assets = data.edges.asInstanceOf[js.Array[CImage]]
      var noMore : Boolean = false
      if(js.isUndefined(data.page_info.has_next_page) || !data.page_info.has_next_page.asInstanceOf[Boolean]) noMore = true
      if(assets.length > 0) {
        assets ++= t.state.assets
        t.modState(s => s.copy(
         noMore = noMore,
         loadingMore = false,
         lastCursor = data.page_info.end_cursor.toString,
         assets = assets,
         dataSource = s.dataSource.cloneWithRows(assets.grouped(t.props.batchSize).toJSArray)
        ))
      } else {
        t.modState(_.copy(loadingMore = false,noMore = noMore ))
      }

    }
  }

  val component = ReactNativeComponentB[Props]("CameraRollView")
    .render(P => {
    View()()
  }).build


  object styles extends NativeStyleSheet {
    val row = style(flexDirection.row,
      flex := 1)

    val url = style(fontSize := 9,
      marginBottom := 14)

    val image = style(margin := 4,
    width := 150,
    height := 150)

    val info = style(flex := 1)

    val container = style(flex := 1)

  }

  case class Props(groupType :String =  "SavedPhotos" ,batchSize : Int = 5,imagesPerRow : Int = 1,renderImage : CImage => _ = renderImage)

  def apply(props : Props ,key : js.Any = {},ref : js.UndefOr[String] = "") = component.set(key,ref)(props)


}
