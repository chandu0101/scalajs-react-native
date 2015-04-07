package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn._
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 3/31/15.
 *
 * key: PropTypes.string,
style: PropTypes.Dynamic,
      autoCapitalize: PropTypes.string,
    autoCorrect: PropTypes.bool,
    autoFocus: PropTypes.bool,
    editable: PropTypes.bool,
    keyboardType: PropTypes.string,
    multiline: PropTypes.bool,
    onBlur: PropTypes.func,
    onFocus: PropTypes.func,
    onChangeText: PropTypes.func,
    onChange: PropTypes.func,
    onEndEditing: PropTypes.func,
    onSubmitEditing: PropTypes.func,
    placeholder: PropTypes.string,
    placeholderTextColor: PropTypes.string,
    selectionState: PropTypes.DocumentSelectionState,
    value: PropTypes.string,
    bufferDelay: PropTypes.number,
    controlled: PropTypes.bool,
    clearButtonMode: PropTypes.string,

 */

case class TextInput(onBlur : UndefOr[js.Function] = undefined ,
                     placeholderTextColor : UndefOr[String] = undefined,
                     multiline : UndefOr[Boolean]=undefined,
                     style : UndefOr[js.Dynamic] = undefined,
                     keyboardType : UndefOr[String] = undefined,
                     selectionState : UndefOr[DocumentSelectionState] = undefined,
                     onSubmitEditing : UndefOr[js.Function] = undefined ,
                     placeholder : UndefOr[String] = undefined,
                     onChangeText : UndefOr[js.Function] = undefined ,
                     onChange : UndefOr[(String) => Unit] = undefined ,
                     autoFocus : UndefOr[Boolean]=undefined,
                     autoCorrect : UndefOr[Boolean]=undefined,
                     autoCapitalize : UndefOr[String] = undefined,
                     key : UndefOr[String] = undefined,
                     bufferDelay : UndefOr[Int] = undefined,
                     onEndEditing : UndefOr[js.Function] = undefined ,
                     controlled : UndefOr[Boolean]=undefined,
                     onFocus : UndefOr[() => Any] = undefined ,
                     clearButtonMode : UndefOr[String] = undefined,
                     value : UndefOr[String] = undefined,
                     editable : UndefOr[Boolean]=undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    onBlur.foreach(v => p.updateDynamic("onBlur")(v))
    placeholderTextColor.foreach(v => p.updateDynamic("placeholderTextColor")(v))
    multiline.foreach(v => p.updateDynamic("multiline")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    keyboardType.foreach(v => p.updateDynamic("keyboardType")(v))
    selectionState.foreach(v => p.updateDynamic("selectionState")(v))
    onSubmitEditing.foreach(v => p.updateDynamic("onSubmitEditing")(v))
    placeholder.foreach(v => p.updateDynamic("placeholder")(v))
    onChangeText.foreach(v => p.updateDynamic("onChangeText")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    autoFocus.foreach(v => p.updateDynamic("autoFocus")(v))
    autoCorrect.foreach(v => p.updateDynamic("autoCorrect")(v))
    autoCapitalize.foreach(v => p.updateDynamic("autoCapitalize")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    bufferDelay.foreach(v => p.updateDynamic("bufferDelay")(v))
    onEndEditing.foreach(v => p.updateDynamic("onEndEditing")(v))
    controlled.foreach(v => p.updateDynamic("controlled")(v))
    onFocus.foreach(v => p.updateDynamic("onFocus")(v))
    clearButtonMode.foreach(v => p.updateDynamic("clearButtonMode")(v))
    value.foreach(v => p.updateDynamic("value")(v))
    editable.foreach(v => p.updateDynamic("editable")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.TextInput)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

