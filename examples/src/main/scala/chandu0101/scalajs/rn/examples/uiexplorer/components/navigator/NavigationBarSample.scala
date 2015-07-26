package chandu0101.scalajs.rn.examples.uiexplorer.components.navigator

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import japgolly.scalajs.react.{ReactElement, BackendScope}

import scala.scalajs.js
import scala.scalajs.js.Math

object NavigationBarSample {

  val NavButton = ReactNativeComponentB[(() => Unit, String)]("NavButton")
    .render(P => {
    TouchableHighlight(
      style = styles.button,
      underlayColor = "#B5B5B5",
      onPress = P._1
    )(Text(style = styles.buttonText)(P._2))
  }).build


  class Backend(t: BackendScope[NavigatorM, _]) {

    def newRandomRoute() :js.Dynamic = {
      NavigatorRoute(title = s"#${Math.ceil(Math.random()*1000)}",component = null,getProps = null).toJson
    }

    def onPress(nav : NavigatorM) = {
      () =>  nav.immediatelyResetRouteStack(js.Array(
        newRandomRoute(),
        newRandomRoute(),
        newRandomRoute()
      ))
    }

    def renderScene(route: NavigatorRoute, navigator: NavigatorM) = {
        ScrollView(style = styles.scene)(
         Text(style = styles.messageText)(route.title),
          NavButton((onPress(navigator),"Reset w/3 scenes")),
          NavButton((() => t.props.pop(),"Exit NavigationBar Example"))
        )
    }

    def onLeftButton(route : NavigatorRoute,navigator : NavigatorM,index : Int,navState : NavigationBarNavState):ReactElement = {
      if(index > 0) {
        val previousRoute = navState.routeStack(index - 1)
         TouchableOpacity(onPress = () => navigator.pop())(
          View(style = styles.navBarLeftButton)(
            Text(style = styles.combinedText)(previousRoute.title)
          )
         )
      } else null

    }
    def onRightButtonButton(route : NavigatorRoute,navigator : NavigatorM,index : Int,navState : NavigationBarNavState):ReactElement = {
         TouchableOpacity(onPress = () => navigator.push(newRandomRoute()))(
          View(style = styles.navBarRightButton)(
            Text(style = styles.combinedText)("Next")
          )
         )
    }

    def onTitle(route : NavigatorRoute,navigator : NavigatorM,index : Int,navState : NavigationBarNavState):ReactElement = {
     Text(style = styles.navBarTitleText)(
       s"${ route.title}[${index}]"
     )
    }


  }


  val component = ReactNativeComponentB[NavigatorM]("NavigationBarSample")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    Navigator(style = styles.container,
    renderScene = B.renderScene _,
    initialRoute =  NavigatorRoute.fromJson(B.newRandomRoute()).toJson ,
    navigationBar = NavigatorNavigationBar(style = styles.navBar,
    routeMapper = NavigationBarRouteMapper(Title = B.onTitle _,
    LeftButton = B.onLeftButton _,
    RightButton = B.onRightButtonButton _))
    )

  })
    .build

  object styles extends NativeStyleSheet {


    val messageText = style(fontSize := 17,
      fontWeight._500,
      padding := 15,
      marginTop := 50,
      marginLeft := 15)


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

    val navBar = style(backgroundColor := "white",
     height := 64,
     paddingBottom := 5,
     borderBottomWidth := 1.0 / ReactNative.PixelRatio.get(),
    borderBottomColor := "rgba(0, 0, 0, 0.5)",
    marginTop := 80)

    val navBarText = style(fontSize := 16,
      marginVertical := 10)

    val navBarTitleText = style(color := "black",
      fontWeight._500,
      marginVertical := 9)

    val navBarLeftButton = style(paddingLeft := 10)

    val navBarRightButton = style(paddingRight := 10)

    val navBarButtonText = style(color := "#5890ff")

    val container = style(flexOne)

    val combinedText = styleE(navBarText,navBarButtonText)()


  }

  def apply(navigator: NavigatorM) = component(navigator)

}
