package chandu0101.scalajs.rn.examples.uiexplorer.components.navigator

import chandu0101.scalajs.rn._

import scala.scalajs.js.Dynamic.{literal => json}

//import chandu0101.scalajs.rn.ReactNativeComponentB

import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.UIExample
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import japgolly.scalajs.react.BackendScope

object NavigatorExample extends UIExample {


  val NavButton = ReactNativeComponentB[(() => Unit, String)]("NavButton")
    .render(P => {
    TouchableHighlight(
      style = styles.button,
      underlayColor = "#B5B5B5",
      onPress = P._1
    )(Text(style = styles.buttonText)(P._2))
  }).build


  case class NavMenuProps(message: String, navigator: NavigatorM)

  val NavMenu = ReactNativeComponentB[NavMenuProps]("NavMenu")
    .render(P => {
    ScrollView(style = styles.scene)(
      Text(style = styles.messageText)(P.message),
      NavButton((() => P.navigator.push(json(title = "Swipe right to dismiss",
        sceneConfig = NavigatorS.SceneConfigs.FloatFromRight)),
        "Float in from right")),
      NavButton((() => P.navigator.push(json(title = "Swipe down to dismiss",
        sceneConfig = NavigatorS.SceneConfigs.FloatFromBottom)),
        "Float in from Bottom")),
      NavButton((() => P.navigator.pop(), "Pop")),
      NavButton((() => P.navigator.popToTop(), "Pop to Top")),
      NavButton((() => P.navigator.push(json(id = "navbar")),
        "Nav Bar Example")),
      NavButton((() => P.navigator.push(json(id = "jumpnav")),
        "Jumping Nav Bar Example")),
      NavButton((() => P.navigator.push(json(id = "breadcrumbs")),
        "Breadcrumb Nav Bar Example"))
    )
  }).build


  class Backend(t: BackendScope[_, _]) {

    def renderScene(route: NavigatorRoute, nav: NavigatorM) = {
      if (route.id.isDefined) {
        route.id.get match {
          case "navbar" => NavigationBarSample(nav)
          case "jumpnav" => JumpingNavSample(nav)
          case "breadcrumbs" => BreadCrumbNavigationBarSample(nav)
          case _ => NavMenu(NavMenuProps(message = route.title, navigator = nav))
        }
      } else NavMenu(NavMenuProps(message = route.title, navigator = nav))
    }

    def configureScene(route: NavigatorRoute) = {
      if (route.sceneConfig.isDefined) route.sceneConfig.get
      else NavigatorS.SceneConfigs.FloatFromRight
    }
  }


  val component = ReactNativeComponentB[Unit]("NavigatorExample")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    val component = null
    Navigator(ref = "navigator",
      style = styles.container,
      initialRoute = NavigatorRoute(title = "First Scene",  getProps = null,component = component).toJson,
      renderScene = B.renderScene _,
      configureScene = B.configureScene _
    )
  }).buildNative


  object styles extends NativeStyleSheet {


    val messageText = style(fontSize := 17,
      fontWeight._500,
      padding := 15,
      marginTop := 50,
      marginLeft := 15)

    val container = style(flexOne)

    val button = style(backgroundColor := "white",
      padding := 15,
      borderBottomWidth := 1.0 / ReactNative.PixelRatio.get(),
      borderBottomColor := "#CDCDCD"
    )

    val buttonText = style(fontSize := 17,
      fontWeight._500)

    val scene = style(flexOne,
      paddingTop := 20,
      backgroundColor := "#EAEAEA")


  }

  override def title: String = "Navigator"

  override def description: String = "JS-implemented navigation"
}
