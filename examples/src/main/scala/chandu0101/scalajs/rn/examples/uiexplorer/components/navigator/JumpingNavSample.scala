package chandu0101.scalajs.rn.examples.uiexplorer.components.navigator

import chandu0101.scalajs.rn._
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import japgolly.scalajs.react.{Ref, BackendScope, ReactElement}

import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce
import scala.scalajs.js.{JSON, Math}
import scalajs.js.Dynamic.{literal => json}

object JumpingNavSample {

  val NavButton = ReactNativeComponentB[(() => Unit, String)]("NavButton")
    .render(P => {
    TouchableHighlight(
      style = styles.button,
      underlayColor = "#B5B5B5",
      onPress = P._1
    )(Text(style = styles.buttonText)(P._2))
  }).build



  def newRandomRoute(index : Int) : js.Dynamic = {
    NavigatorRoute(title = s"#${index}",component = null,getProps = null).toJson
  }

  val ROUTE_STACK = js.Array(
   newRandomRoute(45),
   newRandomRoute(425),
   newRandomRoute(435)
  )

  val INIT_ROUTE_INDEX = 1



  case class JumpingProps(initTabIndex : Int,routeStack : js.Array[js.Dynamic],onTabIndex : Int => Any)

  case class JumpingState(tabIndex : Int)

  class JumpingBackend(t: BackendScope[JumpingProps,JumpingState])  {

    def onTabPress(index : Int):Unit = {
       t.props.onTabIndex(index)
       t.modState(_.copy(tabIndex = index))
    }

  }
    val JumpingNavBar = ReactNativeComponentB[JumpingProps]("JumpingNavBar")
      .initialStateP(p => JumpingState(tabIndex = p.initTabIndex))
      .backend(new JumpingBackend(_))
      .render( (P,S,B) => {
      println(s"rendering jumpingnavbar")
         View(style = styles.tabs)(

          TabBarIOS()(
             TabBarItemIOS(icon = ImageSource(uri = "history"),selected = S.tabIndex == 1,onPress = () => B.onTabPress(1))(
              View()()
             ),
            TabBarItemIOS(icon = ImageSource(uri = "favorites"),selected = S.tabIndex == 2,onPress = () => B.onTabPress(2))(
              View()()
             )
          )

         )
      }).build


  val ROUTE_STACK_CLASS = ROUTE_STACK.map(NavigatorRoute.fromJson(_))

  class Backend(t: BackendScope[NavigatorM, _]) {


    def renderScene(route: NavigatorRoute, navigator: NavigatorM) = {

       var backBtn : ReactElement = null
       var forwardBtn : ReactElement = null
        if(ROUTE_STACK_CLASS.indexOf(route) != 0) {
          backBtn = NavButton((() => navigator.jumpBack(),"JumpBack"))
        }
        if(ROUTE_STACK_CLASS.indexOf(route) != ROUTE_STACK.length - 1) {
          forwardBtn = NavButton((() => navigator.jumpForward(),"JumpForward"))
        }

        ScrollView(style = styles.scene)(
         Text(style = styles.messageText)(route.title),
          backBtn,
          forwardBtn,
          NavButton((() => t.props.pop(),"Exit NavigationBar Example"))
        )
    }

    def configureScene(route : NavigatorRoute) = {

      NavigatorS.SceneConfigs.HorizontalSwipeJump
    }

    def onTabindex(index : Int) = {
      jumpNav(t).get.jumpTo(ROUTE_STACK(index))
    }

  }

  val jumpNav = Ref.toJS[NavigatorM]("jumpnav")

  val component = ReactNativeComponentB[NavigatorM]("JumpingNavSample")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    Navigator(style = styles.container,
     ref = "jumpnav",
    renderScene = B.renderScene _,
    initialRoute =  ROUTE_STACK(INIT_ROUTE_INDEX) ,
    initialRouteStack = ROUTE_STACK,
    configureScene = B.configureScene _,
    navigationBar = JumpingNavBar(JumpingProps(initTabIndex = INIT_ROUTE_INDEX,routeStack = ROUTE_STACK,onTabIndex = B.onTabindex _ ))
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

    val tabs = style(height := 50)

    val navBar = style(backgroundColor := "white")

    val navBarText = style(fontSize := 16,
      marginVertical := 10)

    val navBarTitleText = style(color := "black",
      fontWeight._500,
      marginVertical := 9)

    val navBarLeftButton = style(paddingLeft := 10)

    val navBarRightButton = style(paddingRight := 10)

    val navBarButtonText = style(color := "blue")

    val container = style(flexOne,
    overflow.hidden,
    backgroundColor := "#dddddd")
    val combinedText = styleE(navBarText,navBarButtonText)()

  }

  def apply(navigator: NavigatorM) = component(navigator)

}
