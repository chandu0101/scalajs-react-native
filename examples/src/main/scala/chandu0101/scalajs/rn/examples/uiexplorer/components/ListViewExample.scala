package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExplorerPage, UIExample}
import japgolly.scalajs.react.BackendScope
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet
import scala.collection.mutable.Map
import scala.scalajs.js


object ListViewExample extends UIExample {

  val THUMB_URLS = js.Array("https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-ash3/t39.1997/p128x128/851549_767334479959628_274486868_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851561_767334496626293_1958532586_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-ash3/t39.1997/p128x128/851579_767334503292959_179092627_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851589_767334513292958_1747022277_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851563_767334559959620_1193692107_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851593_767334566626286_1953955109_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851591_767334523292957_797560749_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851567_767334529959623_843148472_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851548_767334489959627_794462220_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851575_767334539959622_441598241_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-ash3/t39.1997/p128x128/851573_767334549959621_534583464_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851583_767334573292952_1519550680_n.png")
  val LOREM_IPSUM = "Lorem ipsum dolor sit amet, ius ad pertinax oportere accommodare, an vix civibus corrumpit referrentur. Te nam case ludus inciderint, te mea facilisi adipiscing. Sea id integre luptatum. In tota sale consequuntur nec. Erat ocurreret mei ei. Eu paulo sapientem vulputate est, vel an accusam intellegam interesset. Nam eu stet pericula reprimique, ea vim illud modus, putant invidunt reprehendunt ne qui.";

  case class State(datasource : ListViewDataSource[String] = createListViewDataSource[String,js.Object](rowHasChanged = (r1,r2) => r1 != r2))

  class Backend(t: BackendScope[_, State]) {

    val pressedData = scala.collection.mutable.Map[String,Boolean]().withDefaultValue(false)

    def genRows(pressedData : Map[String,Boolean]) = {
      val dataBlob = js.Array[String]()
      (1 to 100).toList.zipWithIndex.foreach {
        case (i,index) =>  {
          val pressedText = if(pressedData.getOrElse(index.toString,false)) "pressed" else ""
          dataBlob += s"Row $i $pressedText"
        }
      }
      dataBlob
    }


    def pressRow(rowID : String) = {
      pressedData.updated(rowID,pressedData(rowID))
      t.modState(s => s.copy(s.datasource.cloneWithRows(genRows(pressedData))))
    }

    def hashCode2(str : String) = {
      var hash = 15
      str.reverse.foreach( c => {
        hash = ((hash << 5) - hash) + c.toInt
      })
      hash
    }

    def renderRow(rowData : String, sectionID : String,rowID : String) = {
      val rowHash = Math.abs(hashCode2(rowData))
      val imageSource = ImageSource(uri = THUMB_URLS(rowHash % THUMB_URLS.length))
      TouchableHighlight(onPress = () => pressRow(rowID))(
       View()(
        View(style = styles.row)(
         Image(style = styles.thumb , source = imageSource),
         Text(style = styles.text)(
          s"$rowData - ${LOREM_IPSUM.substring(0,rowHash % 301 + 10)}"
         ),
         View(style = styles.separator)()
        )
       )
      )
    }

    val propsDynamic = t.propsDynamic
  }
  val component = ReactNativeComponentB[Unit]("ListViewExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P,S,B) => {
      View()(
       ListView(dataSource = S.datasource,renderRow = B.renderRow _)
      )
    })
    .componentWillMount(scope => scope.modState(s => s.copy(s.datasource.cloneWithRows(scope.backend.genRows(Map())))))
    .buildNative

  object styles extends NativeStyleSheet {

    val row = style(
     flexDirection.row,
     justifyContent.center,
     padding := 10,
     backgroundColor := "#F6F6F6"
    )

    val separator = style(
     height := 1,
    backgroundColor := "#F6F6F6"
    )

    val thumb = style(width := 64, height := 64)

    val text = style(flex := 1)

  }

  override def title: String = "ListView - simple"

  override def description: String = "Performant, scrollable list of data."

}
