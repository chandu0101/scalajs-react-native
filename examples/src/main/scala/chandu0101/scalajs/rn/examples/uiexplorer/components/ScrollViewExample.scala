package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js

object ScrollViewExample extends UIExample {

  val THUMBS = js.Array("https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-ash3/t39.1997/p128x128/851549_767334479959628_274486868_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851561_767334496626293_1958532586_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-ash3/t39.1997/p128x128/851579_767334503292959_179092627_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851589_767334513292958_1747022277_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851563_767334559959620_1193692107_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851593_767334566626286_1953955109_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851591_767334523292957_797560749_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851567_767334529959623_843148472_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851548_767334489959627_794462220_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851575_767334539959622_441598241_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-ash3/t39.1997/p128x128/851573_767334549959621_534583464_n.png", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-prn1/t39.1997/p128x128/851583_767334573292952_1519550680_n.png")

  val THUMB = ReactNativeComponentB[String]("THUMB")
    .render(P => {
    View(style = styles.button)(
      Image(style = styles.img, source = ImageSource(uri = P))
    )
  })
    .shouldComponentUpdate((_, _, _) => false)
    .build

  val component = ReactNativeComponentB[Unit]("ScrollViewExample")
    .render(P => {
    UIExplorerPage(
      UIExplorerBlock("ScrollView Vertical")(
        ScrollView(style = styles.scrollView,
          contentInset = EdgeInsets(top = -50.0),
          scrollEventThrottle = 16,
          onScroll = () => println(s"on Scroll!"))(
            THUMBS.++(THUMBS).zipWithIndex.map {
              case (u, i) => THUMB.withKey(i)(u)
            }
          )
      ),
      UIExplorerBlock("ScrollView horizontal")(
        ScrollView(style = styles.horizontalScrollView,
          horizontal = true,
          scrollEventThrottle = 16,
          contentInset = EdgeInsets(top = -50.0),
          onScroll = () => println(s"on Scroll!"))(
            THUMBS.++(THUMBS).zipWithIndex.map {
              case (u, i) => THUMB.withKey(i)(u)
            }
          )
      )
    )
  }).buildNative

  object styles extends NativeStyleSheet {

    val scrollView = style(
      backgroundColor := "#6A85B1",
      height := 300
    )
    val horizontalScrollView = styleE(scrollView)(height := 120)
    val containerPage = style(height := 50,
      width := 50,
      backgroundColor := "#527FE4", padding := 5)

    val text = style(fontSize := 20,
      color := "#888888",
      left := 80,
      top := 20,
      height := 40)

    val button = style(margin := 7,
      padding := 5,
      alignItems.center,
      backgroundColor := "#eaeaea",
      borderRadius := 3)

    val buttonContents = style(flexDirection.row,
      width := 64,
      height := 64)

    val img = style(width := 64, height := 64)


  }

  override def title: String = "ScrollView"

  override def description: String = "Component that enables scrolling through child components"
}
