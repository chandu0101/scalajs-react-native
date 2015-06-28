package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.rn.extras.OnUnmount
import chandu0101.scalajs.rn.mixins.TimerMixin
import japgolly.scalajs.react.BackendScope
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet

object ActivityIndicatorIOSExample extends UIExample {

  case class State(animating: Boolean = true)

  class Backend(t: BackendScope[_, State]) extends TimerMixin {

    def setToggleTimeout: Unit = timerMixin.setTimeout(() => {
      t.modState(s => s.copy(animating = !s.animating))
      setToggleTimeout
    }, 1200)
  }

  val ToggleAnimatingActivityIndicator = ReactNativeComponentB[Unit]("ToggleAnimatingActivityIndicator")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    ActivityIndicatorIOS(animating = S.animating,
      style = styles.animating,
      size = "large")
  })
    .componentDidMount(scope => scope.backend.setToggleTimeout)
    .configure(OnUnmount.install)
    .buildU

  val component = ReactNativeComponentB[Unit]("ActivityIndicatorIOSExample")
    .render(P => {
    UIExplorerPage(
      UIExplorerBlock("Default white")(
        ActivityIndicatorIOS(style = styles.default, color = "white")
      ),
      UIExplorerBlock("Gray")(
        ActivityIndicatorIOS(style = styles.default)
      ),
      UIExplorerBlock("Large")(
        ActivityIndicatorIOS(style = styles.default,
          color = "white",
          size = "large")
      ),
      UIExplorerBlock("Large custom colors")(
        View(style = styles.horizontal)(
          ActivityIndicatorIOS(
            key = "3",
            color = "#00aa00",
            size = "large")
        )
      ),
      UIExplorerBlock("Start/Stop")(
        ToggleAnimatingActivityIndicator()
      )
    )
  })

    .buildNative

  object styles extends NativeStyleSheet {

    val centering = style(
      alignItems.center,
      justifyContent.center
    )

    val gray = style(backgroundColor := "#cccccc")

    val horizontal = style(flexDirection.row, justifyContent.center)

    val default = styleE(centering, gray)(height := 40)

    val animating = styleE(centering)(height := 80)
  }

  override def title: String = "ActivityIndicatorIOS"

  override def description: String = "Animated loading indicators."
}
