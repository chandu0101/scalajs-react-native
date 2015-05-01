package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactElement, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 *
 *
 *
key: PropTypes.string,
    configureScene: PropTypes.func,
    renderScene: PropTypes.func.isRequired,
    initialRoute: PropTypes.object,
    initialRouteStack: PropTypes.arrayOf(PropTypes.object),
    onWillFocus: PropTypes.func,
    onDidFocus: PropTypes.func,
    onItemRef: PropTypes.func,
    navigationBar: PropTypes.node,
    navigator: PropTypes.object,
    sceneStyle: View.propTypes.style,
    shouldJumpOnBackstackPop: PropTypes.bool,
 */


case class Navigator(navigator: UndefOr[js.Object] = undefined,
                     onItemRef: UndefOr[js.Function] = undefined,
                     onDidFocus: UndefOr[js.Function] = undefined,
                     navigationBar: UndefOr[ReactElement] = undefined,
                     key: UndefOr[String] = undefined,
                     renderScene: js.Function,
                     initialRouteStack: UndefOr[js.Array[js.Object]] = undefined,
                     configureScene: UndefOr[js.Function] = undefined,
                     shouldJumpOnBackstackPop: UndefOr[Boolean] = undefined,
                     initialRoute: UndefOr[js.Object] = undefined,
                     onWillFocus: UndefOr[js.Function] = undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    navigator.foreach(v => p.updateDynamic("navigator")(v))
    onItemRef.foreach(v => p.updateDynamic("onItemRef")(v))
    onDidFocus.foreach(v => p.updateDynamic("onDidFocus")(v))
    navigationBar.foreach(v => p.updateDynamic("navigationBar")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    p.updateDynamic("renderScene")(renderScene)
    initialRouteStack.foreach(v => p.updateDynamic("initialRouteStack")(v))
    configureScene.foreach(v => p.updateDynamic("configureScene")(v))
    shouldJumpOnBackstackPop.foreach(v => p.updateDynamic("shouldJumpOnBackstackPop")(v))
    initialRoute.foreach(v => p.updateDynamic("initialRoute")(v))
    onWillFocus.foreach(v => p.updateDynamic("onWillFocus")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.Navigator)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
     