package chandu0101.scalajs.rn

import chandu0101.scalajs.rn.apis._
import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.Object

trait ReactNative extends js.Object {


  //components
  val Text: js.Object = js.native
  val View: js.Object = js.native
  val TextInput: js.Object = js.native
  val TouchableWithoutFeedback: js.Object = js.native
  val TouchableHighlight: js.Object = js.native
  val TouchableOpacity: js.Object = js.native
  val ActivityIndicatorIOS: js.Object = js.native
  val DatePickerIOS: js.Object = js.native
  val Image: js.Object = js.native
  val ScrollView: js.Object = js.native
  val ListView: js.Object = js.native
  val MapView: js.Object = js.native
  val Navigator: js.Object = js.native
  val NavigatorIOS: js.Object = js.native
  val PickerIOS: js.Object = js.native
  val SliderIOS: js.Object = js.native
  val SwitchIOS: js.Object = js.native
  val TabBarItemIOS: js.Object = js.native
  val WebView: js.Object = js.native
  val TabBarIOS: js.Object = js.native

  // apis

  val AlertIOS: AlertIOS = js.native
  val AppRegistry: AppRegistry = js.native
  val StyleSheet: StyleSheet = js.native
  val Animation: Animation = js.native
  val AppStateIOS: AppStateIOS = js.native
  val AsyncStorage: AsyncStorageJS = js.native
  val CameraRoll: CameraRoll = js.native
  val InteractionManager: InteractionManager = js.native
  val LinkingIOS: LinkingIOS = js.native
  val NetInfo: NetInfo = js.native
  val LayoutAnimation: js.Dynamic = js.native
  val PixelRatio: PixelRatio = js.native
  val PushNotificationIOS: PushNotificationIOS = js.native
  val PanResponder: PanResponder = js.native
  val StatusBarIOS: js.Dynamic = js.native
  val VibrationIOS: VibrationIOS = js.native

  def createClass[P, S, B, N <: TopNode](spec: ReactComponentSpec[P, S, B, N]): ReactComponentType[P, S, B, N] = js.native

  def createClass(spec: js.Object): js.Dynamic = js.native

  def createFactory[P, S, B, N <: TopNode](t: ReactComponentType[P, S, B, N]): ReactComponentCU[P, S, B, N] = js.native

  def createFactory(c: js.Object): js.Dynamic = js.native

  def createElement[P, S, B, N <: TopNode](t: ReactComponentType[P, S, B, N]): ReactComponentCU[P, S, B, N] = js.native

  def createElement(tag: String, props: Object, children: ReactNode*): ReactDOMElement = js.native

  def createElement(tag: js.Object, props: Object, children: ReactNode*): ReactDOMElement = js.native


  val addons: js.Dynamic = js.native

  def findNodeHandle(ref : js.Any):js.Object = js.native
}


