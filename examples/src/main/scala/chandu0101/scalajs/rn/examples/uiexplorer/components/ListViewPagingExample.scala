package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.UIExample
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}

object ListViewPagingExample extends UIExample {


  val PAGE_SIZE = 4
  val THUMB_URLS = js.Array("https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-ash3/t39.1997/p128x128/851549_767334479959628_274486868_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851561_767334496626293_1958532586_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-ash3/t39.1997/p128x128/851579_767334503292959_179092627_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851589_767334513292958_1747022277_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851563_767334559959620_1193692107_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851593_767334566626286_1953955109_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851591_767334523292957_797560749_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851567_767334529959623_843148472_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851548_767334489959627_794462220_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851575_767334539959622_441598241_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-ash3/t39.1997/p128x128/851573_767334549959621_534583464_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851583_767334573292952_1519550680_n.png")
  val NUM_SECTIONS = 10
  val NUM_ROWS_PER_SECTION = 10

  def getThumbIdx = {
    Math.floor(Math.random() * THUMB_URLS.length).toInt
  }

  case class ThumbState(thumbIndex: Int = getThumbIdx, dir: String = "row")

  class ThumbBackend(t: BackendScope[_, ThumbState]) {

    def onPressThumb = {
      val config = layoutAnimationConfigs(t.state.thumbIndex % layoutAnimationConfigs.length)
      LayoutAnimation.configureNext(config)
      t.modState(s => s.copy(thumbIndex = getThumbIdx, dir = if (s.dir == "row") "column" else "row"))
    }

  }

  val Thumb = ReactNativeComponentB[Unit]("Thumb")
    .initialState(ThumbState())
    .backend(new ThumbBackend(_))
    .render((P,S,B) => {
      TouchableOpacity(onPress = () => B.onPressThumb )(
       View(style = styles.buttonCOntentsDir(S.dir))(
        Image(style = styles.img , source = ImageSource(uri = THUMB_URLS(S.thumbIndex))),
        Image(style = styles.img , source = ImageSource(uri = THUMB_URLS(S.thumbIndex))),
        Image(style = styles.img , source = ImageSource(uri = THUMB_URLS(S.thumbIndex))),
        if(S.dir == "column") Text()(
         "Oooo, look at this new text!  So awesome it may just be crazy.Let me keep typing here so it wraps at least one line."
        )
        else Text()()
       )
      )
  }).buildU


  def getDataSource = {
    val getSectionData  = (dataBlob : js.Dictionary[String],sectionID : String ) => dataBlob(sectionID)

    val getRowData = (dataBlob : js.Dictionary[String],sectionID : String, rowID : String) => dataBlob(rowID)

    val dataSource = createListViewDataSource[String,String](rowHasChanged = (r1,r2) => r1 != r2,
    getSectionHeaderData = getSectionData,
    getRowData = getRowData,
    sectionHeaderHasChanged = (s1: String,s2 : String) => s1 != s2)

    val dataBlob = js.Dictionary[String]()
    val sectionIDs = js.Array[String]()
    val rowIDs = js.Array[js.Array[String]]()

    (0 to NUM_SECTIONS-1).foreach( i => {
      val sectionName = s"Section $i"
      sectionIDs += sectionName
      dataBlob += sectionName -> sectionName
      val eachRowIDs = js.Array[String]()
      (0 to NUM_ROWS_PER_SECTION - 1).foreach( j => {
        val rowName = s"S$i, T$j"
        eachRowIDs += rowName
        dataBlob += rowName -> rowName
      })
      rowIDs += eachRowIDs
    })
    dataSource.cloneWithRowsAndSections(dataBlob,sectionIDs,rowIDs)
  }

  case class State(datasource : ListViewDataSource[String] = getDataSource , headerPressCount : Int = 0)

  class Backend(t: BackendScope[_, State]) {

    def renderRow(rowData : String, sectionID : String,rowID : String) = {
      Thumb()
    }

    def renderSectionHeader(sectionData : String,sectionID : String) = {
       View(style = styles.section)(
        Text(style = styles.text)(
         sectionData
        )
       )
    }

    def onPressHeader = {
      val config = layoutAnimationConfigs(Math.floor(t.state.headerPressCount / 2).toInt % layoutAnimationConfigs.length)
      LayoutAnimation.configureNext(config)
      t.modState(_.copy(headerPressCount = t.state.headerPressCount))
    }


    def renderHeader = {
      TouchableOpacity(onPress = () => onPressHeader)(
       View(style =styles.header)(
         if(t.state.headerPressCount % 2 == 0) View()(Text(style = styles.text)("1 Like")) else "",
         View()(
           Text(style = styles.text)("Table Header (click me)")
         )
       )
      )
    }

    def renderFooter = {
      View(style = styles.header)(
       Text(style = styles.text , onPress = () => println("Footer"))(
        "Table Footer"
       )
      )
    }
  }
  val component = ReactNativeComponentB[Unit]("ListViewPagingExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P,S,B) => {
     ListView[String,String](
      style = styles.listView,
      dataSource = S.datasource,
      pageSize = PAGE_SIZE,
      renderRow = B.renderRow _,
      renderFooter = B.renderFooter _,
      renderSectionHeader = B.renderSectionHeader _,
      initialListSize = 10,
      scrollRenderAheadDistance = 2000
     )
  }).buildNative

  object styles extends NativeStyleSheet {

    val listView = style(backgroundColor := "#B0C4DE")

    val header = style(height := 40,
      justifyContent.center,
      alignItems.center,
      backgroundColor := "#3B5998",
      flexDirection.row)

    val text = style(color := "white",
      paddingHorizontal := 8)

    val rowText = style(color := "#888888")

    val thumbText = style(fontSize := 20,
      color := "#888888")

    val buttonContents = style(
      flexDirection.row,
      justifyContent.center,
      alignItems.center,
      marginHorizontal := 5,
      marginVertical := 5,
      backgroundColor := "#EAEAEA",
      borderRadius := 3,
      paddingVertical := 10
    )

    def buttonCOntentsDir(dir : String) = styleE(buttonContents)(
      if(dir == "row") flexDirection.row else flexDirection.column
    )

    val img = style(width := 64,
      height := 64,
      marginHorizontal := 10)

    val section = style(flexDirection.column,
      justifyContent.center,
      alignItems.flexStart,
      backgroundColor := "#5890ff",
      padding := 6)

  }

  val LayoutAnimation = ReactNative.LayoutAnimation

  val animations = json(
    layout = json(
      spring = json(
        duration = 750,
        create = json(
          duration = 300,
          `type` = LayoutAnimation.Types.easeInEaseOut,
          property = LayoutAnimation.Properties.opacity
        )
          update = json(
          `type` = LayoutAnimation.Types.spring,
          springDamping = 0.4
        )
      )
        easeInEaseOut = json(
        duration = 300,
        create = json(
          `type` = LayoutAnimation.Types.easeInEaseOut,
          property = LayoutAnimation.Properties.scaleXY
        )
          update = json(
          delay = 100,
          `type` = LayoutAnimation.Types.easeInEaseOut
        )
      )
    )
  )

  val layoutAnimationConfigs = js.Array(animations.layout.spring,
    animations.layout.easeInEaseOut)

  override def title: String = "ListView - paging"

  override def description: String = "Floating headers & layout animations."
}
