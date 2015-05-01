package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js


object CameraRollView {

  val component = ReactNativeComponentB[Props]("CameraRollView")
    .render(P => {
    View()()
  }).build


  object styles extends NativeStyleSheet {
    val row = style(flexDirection.row,
      flex := 1)

    val url = style(fontSize := 9,
      marginBottom := 14)

    val image = style(margin := 4)

    val info = style(flex := 1)

    val container = style(flex := 1)

  }

  case class Props(groupTypes :String =  "SavedPhotos" ,batchSize : Int = 5,imagesPerRow : Int = 1,renderImage : Function1[Any,_] = null )

  def apply(props : Props ,key : js.Any = {},ref : js.UndefOr[String] = "") = component.set(key,ref)(props)


}
