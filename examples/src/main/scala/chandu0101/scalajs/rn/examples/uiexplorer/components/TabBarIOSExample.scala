package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.UIExample
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}


object TabBarIOSExample extends UIExample{

  val BLUE_TAB = "blueTab"
  val RED_TAB = "redTab"
  val GREEN_TAB = "greenTab"

  case class State(selectedTab: String = BLUE_TAB, notifCount: Int = 0, presses: Int = 0)

  class Backend(t: BackendScope[_, State]) {

    def renderContent(color : String,pageText : String) = {
       View(style = js.Array(styles.tabContent,json(backgroundColor = color)))(
          Text(style = styles.tabText)(pageText),
          Text(style = styles.tabText)(s"${t.state.presses} re-renders of this tab")
       )
    }

    def getImage(imageUri : String) = ImageSource(uri = imageUri)
    def selectTab(name : String) = name match {
      case BLUE_TAB => t.modState(_.copy(selectedTab = name))
      case RED_TAB => t.modState(s => s.copy(selectedTab = name,notifCount = s.notifCount + 1))
      case GREEN_TAB => t.modState(s => s.copy(selectedTab = name,presses = s.presses + 1))
    }
  }

 override val component = ReactNativeComponentB[Unit]("TabBarExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P,S,B) => {
    val badgeValue = if(S.notifCount >0) S.notifCount.toString else null
     TabBarIOS()(
       TabBarItemIOS(key = BLUE_TAB, icon = B.getImage("favorites"),selected = (S.selectedTab == BLUE_TAB),onPress = () => B.selectTab(BLUE_TAB))(
         B.renderContent("#414A8C","Scala-JS Blue Tab")
       ),
       TabBarItemIOS(key = RED_TAB, badge = badgeValue, icon = B.getImage("history"),selected = (S.selectedTab == RED_TAB),onPress = () => B.selectTab(RED_TAB))(
         B.renderContent("#783E33","Scala-JS Red Tab")
       ),
       TabBarItemIOS(key = GREEN_TAB, icon = B.getImage("favorites"),selected = (S.selectedTab == GREEN_TAB),onPress = () => B.selectTab(GREEN_TAB))(
         B.renderContent("#21551C","Scala-JS Green Tab")
       )
     )
  }).buildNative

  object styles extends NativeStyleSheet {

    val tabContent = style(flex := 1,alignItems.center)

    val tabText = style(color := "white" , margin := 50)

  }


  override def title: String = "TabBarIOS"


  override def description: String = "Tab-based navigation."
}
