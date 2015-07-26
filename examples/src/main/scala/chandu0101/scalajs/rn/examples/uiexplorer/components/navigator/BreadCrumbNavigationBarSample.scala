package chandu0101.scalajs.rn.examples.uiexplorer.components.navigator

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import japgolly.scalajs.react.{BackendScope, ReactElement}

import scala.scalajs.js
import scala.scalajs.js.Math

object BreadCrumbNavigationBarSample {

  val NavButton = ReactNativeComponentB[(() => Unit, String)]("NavButton")
    .render(P => {
    TouchableHighlight(
      style = styles.button,
      underlayColor = "#B5B5B5",
      onPress = P._1
    )(Text(style = styles.buttonText)(P._2))
  }).build


  class Backend(t: BackendScope[NavigatorM, _]) {

    def newRandomRoute() : js.Dynamic = {
      NavigatorRoute(title = s"#${Math.ceil(Math.random() * 1000)}",component = null,getProps = null).toJson
    }

    def renderScene(route: NavigatorRoute, navigator: NavigatorM) = {
      ScrollView(style = styles.scene)(
        NavButton((() => navigator.push(newRandomRoute()), "Push")),
        NavButton((() => t.props.pop(), "Close breadcrumb Example"))
      )
    }

    def rightContentForRoute(route: NavigatorRoute, navigator: NavigatorM): ReactElement = {
      null
    }

    def titleContentForRoute(route: NavigatorRoute, navigator: NavigatorM): ReactElement = {
      TouchableOpacity(onPress = () => navigator.push(newRandomRoute()))(
        View()(
          Text(style = styles.titleText)(route.title)
        )
      )
    }

    def iconForRoute(route: js.Dynamic, navigator: NavigatorM): ReactElement = {
      TouchableOpacity(onPress = () => navigator.popToRoute(route))(
        View(style = styles.crumbIconPlaceholder)(
        )
      )
    }

    def separatorForRoute(route: NavigatorRoute, navigator: NavigatorM): ReactElement = {
      TouchableOpacity(onPress = () => navigator.pop())(
        View(style = styles.crumbSeparatorPlaceholder)(
        )
      )
    }

  }


  val component = ReactNativeComponentB[NavigatorM]("BreadCrumbNavigationBarSample")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    Navigator(style = styles.container,
      renderScene = B.renderScene _,
      initialRoute = NavigatorRoute.fromJson(B.newRandomRoute()).toJson,
      navigationBar = NavigatorBreadcrumbNavigationBar( style = styles.breadCrumbBar,
        routeMapper = BreadcrumbNavigationBarRouteMapper(iconForRoute = B.iconForRoute _,
          titleContentForRoute = B.titleContentForRoute _,
          rightContentForRoute = B.rightContentForRoute _,
          separatorForRoute = B.separatorForRoute _))
    )

  })
    .build

  object styles extends NativeStyleSheet {


    val titleText = style(fontSize := 18,
      color := "#666666",
      fontWeight.bold,
      textAlign.center,
      lineHeight := 32)


    val button = style(backgroundColor := "white",
      padding := 15,
      borderBottomWidth := 1.0 / ReactNative.PixelRatio.get(),
      borderBottomColor := "#CDCDCD"
    )

    val buttonText = style(fontSize := 17,
      fontWeight._500)

    val scene = style(flexOne,
      paddingTop := 90)

    val container = style(flexOne,
      overflow.hidden,
      backgroundColor := "#dddddd")

    val crumbIconPlaceholder = style(flexOne,
      backgroundColor := "#666666")


    val crumbSeparatorPlaceholder = style(
      flexOne,
      backgroundColor := "#aaaaaa"
    )
    val breadCrumbBar = style(marginTop := 70)

  }

  def apply(navigator: NavigatorM) = component(navigator)

}
