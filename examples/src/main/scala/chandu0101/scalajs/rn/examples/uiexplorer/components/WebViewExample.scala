package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.rn.{NEvent, ReactNativeComponentB}
import japgolly.scalajs.react.{BackendScope, Ref}
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet

object WebViewExample extends UIExample {

  val HEADER = "#3b5998"
  val BGWASH = "rgba(255,255,255,0.8)"
  val DISABLED_WASH = "rgba(255,255,255,0.25)"
  val TEXT_INPUT_REF = "urlInput"
  val WEBVIEW_REF = "webview"
  val DEFAULT_URL = "https://m.facebook.com"

  case class State(url: String = DEFAULT_URL, status: String = " No PageLoaded", backButtonEnabled: Boolean = false, forwardButtonEnabled: Boolean = true, loading: Boolean = true)

  class Backend(t: BackendScope[_, State]) {

    var inputText = ""

    def handleTextInputChange(event: NEvent) = {
      inputText = event.nativeEvent.text.toString
    }

    def goBack = if (webRefAccess(t).isDefined) webRefAccess(t).get.goBack()

    def goForward = if (webRefAccess(t).isDefined) webRefAccess(t).get.goForward()

    def reload = if (webRefAccess(t).isDefined) webRefAccess(t).get.reload()

    def onNavigationStateChange(navState: NavigationState) = {
      t.modState(_.copy(url = navState.url, loading = navState.loading, backButtonEnabled = navState.canGoBack, forwardButtonEnabled = navState.canGoForward, status = navState.title))
    }

    def pressGoButton = {
      val url = inputText.toLowerCase
      if (url == t.state.url) reload
      else t.modState(_.copy(url = url))
      if (inputRefAccess(t).isDefined) inputRefAccess(t).get.blur()
    }

    def onSubmitEditing(event: NEvent) = pressGoButton

  }

  lazy val webRefAccess = Ref.toJS[WebViewM](WEBVIEW_REF)

  lazy val inputRefAccess = Ref.toJS[TextInputM](TEXT_INPUT_REF)


  val component = ReactNativeComponentB[Unit]("WebViewExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P,S,B) => {
    B.inputText = S.url
    UIExplorerPage(
     UIExplorerBlock(title = "WebView")(
       View(style = styles.container)(
         View(style = styles.addressBarRow)(
           TouchableHighlight(onPress = B.goBack _)(
             View(style = if(S.backButtonEnabled) styles.navButton else styles.disabledButton)(
               Text()("<")
             )
           ),
           TouchableHighlight(onPress = B.goForward _)(
             View(style = if(S.forwardButtonEnabled) styles.navButton else styles.disabledButton)(
               Text()(">")
             )
           ),
           TextInput(ref = TEXT_INPUT_REF,autoCapitalize = "none",value = S.url,onSubmitEditing = B.onSubmitEditing _,
             onChange = B.handleTextInputChange _,
             clearButtonMode = "while-editing",
             style = styles.addressBarTextInput)(),
           TouchableOpacity(onPress = B.pressGoButton _)(
             View(style = styles.goButton)(
               Text()("Go!")
             )
           )
         ),
         WebView(ref = WEBVIEW_REF,
           automaticallyAdjustContentInsets = false,
           style = styles.webView,
           url = S.url,
           onNavigationStateChange = B.onNavigationStateChange _,
           startInLoadingState = true
         ),
         View(style = styles.statusBar)(
           Text(style = styles.statusBarText)(S.status)
         )
       )
     )
    )

  }).buildNative

  object styles extends NativeStyleSheet {

    val container = style(flex := 1,
      backgroundColor := HEADER)

    val addressBarRow = style(flexDirection.row,
      padding := 8)

    val webView = style(
      backgroundColor := BGWASH,
      height := 350
    )

    val addressBarTextInput = style(
      backgroundColor := BGWASH,
      borderColor := "transparent",
      borderRadius := 3,
      borderWidth := 1,
      height := 24,
      paddingLeft := 10,
      paddingTop := 3,
      flex := 1,
      fontSize := 14
    )

    def buttonCommon(bg: String) = style(
      padding := 3,
      alignItems.center,
      justifyContent.center,
      backgroundColor := bg,
      borderColor := "transparent",
      borderRadius := 3
    )

    val navButton = styleE(buttonCommon(BGWASH))(
      width := 20,
      marginRight := 3)

    val disabledButton = styleE(buttonCommon(DISABLED_WASH))(
      width := 20,
      marginRight := 3)

    val goButton = styleE(buttonCommon(BGWASH))(
      height := 24,
      marginLeft := 8,
      alignSelf.stretch
    )

    val statusBar = style(
      flexDirection.row,
      alignItems.center,
      paddingLeft := 5,
      height := 22
    )

    val statusBarText = style(
      color := "white",
      fontSize := 13
    )

    val spinner = style(
      width := 20,
      marginRight := 6
    )

  }

  override def title: String = "WebView"

  override def description: String = "Base component to display web content"
}
