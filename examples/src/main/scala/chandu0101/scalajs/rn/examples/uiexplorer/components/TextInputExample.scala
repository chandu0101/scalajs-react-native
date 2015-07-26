package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.rn.{NEvent, ReactNativeComponentB}
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet

object TextInputExample extends UIExample {

  val WithLabel = ReactNativeComponentB[String]("WithLabel")
    .render((P, C) => {
    View(style = styles.labelContainer, key = P)(
      View(style = styles.label, key = "lab")(
        Text(key = "tex")(
          P
        )
      ),
      C
    )
  }).build

  case class State(curText: String = "No Event", prevText: String = "No Event")

  class Backend(t: BackendScope[_, State]) {

    def upDateTex(text: String) = {
      t.modState(s => s.copy(text, s.curText))
    }

    def handleInputEvent(e: NEvent) = {

    }
  }

  val TextEventsExample = ReactNativeComponentB[Unit]("TextEventsExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    View()(
      TextInput(autoCapitalize = AutoCapitalize.NONE,
        placeholder = "Enter text to see events",
        autoCorrect = false,
        onFocus = (e: NEvent) => B.upDateTex("onFocus"),
        onBlur = (e: NEvent) => B.upDateTex("onBlur"),
        onChange = (e: NEvent) => B.upDateTex(s"onChange text ${e.nativeEvent.text}"),
        onEndEditing = (e: NEvent) => B.upDateTex(s"onEndEditing text ${e.nativeEvent.text}"),
        onSubmitEditing = (e: NEvent) => B.upDateTex(s"onSubmitEditing text ${e.nativeEvent.text}"),
        style = styles.default
      )(),
      Text(style = styles.eventLabel)(
        S.curText,
        s"\n prev : ${S.prevText}"
      )
    )
  }).buildU


  val component = ReactNativeComponentB[Unit]("TextInputExamples")
    .render(P => {
    UIExplorerPage(
      UIExplorerBlock("Auto-focus")(
        TextInput(autoFocus = true, style = styles.default)()
      ),
      UIExplorerBlock("Auto-capitalize")(
        View()(
          WithLabel("none", TextInput(autoCapitalize = AutoCapitalize.NONE, key = "none", style = styles.default)()),
          WithLabel("sentences", TextInput(autoCapitalize = AutoCapitalize.SENTENCES, key = "sentences", style = styles.default)()),
          WithLabel("words", TextInput(autoCapitalize = AutoCapitalize.WORDS, key = "words", style = styles.default)()),
          WithLabel("characters", TextInput(autoCapitalize = AutoCapitalize.CHARACTERS, key = "chars", style = styles.default)())
        )
      ),
      UIExplorerBlock("Event handling")(
        TextEventsExample()
      ),
      UIExplorerBlock("Auto-correct")(
        View()(
          WithLabel("true", TextInput(autoCorrect = true, key = "none", style = styles.default)()),
          WithLabel("false", TextInput(autoCorrect = false, key = "none", style = styles.default)())
        )
      ),
      UIExplorerBlock("Clear button mode")(
        View()(
          WithLabel("never", TextInput(clearButtonMode = "never", key = "never", style = styles.default)()),
          WithLabel("while editing", TextInput(clearButtonMode = "while-editing", key = "sentences", style = styles.default)()),
          WithLabel("unless editing", TextInput(clearButtonMode = "unless-editing", key = "unless-editing", style = styles.default)()),
          WithLabel("always", TextInput(clearButtonMode = "always", key = "chars", style = styles.default)())
        )
      )
    )
  }).buildNative


  object styles extends NativeStyleSheet {

    val page = style(paddingBottom := 30)

    val default = style(height := 26,
      borderWidth := 0.5,
      borderColor := "#0f0f0f",
      flex := 1,
      fontSize := 13)

    val multiline = style(borderWidth := 0.5,
      borderColor := "#0f0f0f",
      flex := 1,
      fontSize := 13,
      height := 50)

    val label = style(width := 120,
      justifyContent.flexEnd,
      flexDirection.row,
      marginRight := 10,
      paddingTop := 2)

    val eventLabel = style(margin := 3, fontSize := 12)

    val labelContainer = style(flexDirection.row, marginVertical := 2, flex := 1)

  }

  override def title: String = "TextInput"

  override def description: String = "Single line text inputs"
}
