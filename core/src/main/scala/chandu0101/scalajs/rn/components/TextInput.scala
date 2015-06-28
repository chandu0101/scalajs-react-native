package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn._
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 3/31/15.
 *
 *  key: PropTypes.string,
    ref: PropTypes.string,
    style: PropTypes.js.Any,
    autoCapitalize: PropTypes.string,
    autoCorrect: PropTypes.bool,
    autoFocus: PropTypes.bool,
    editable: PropTypes.bool,
    keyboardType: PropTypes.string,
    multiline: PropTypes.bool,
    onBlur: PropTypes.(NEvent) => _,
    onFocus: PropTypes.(NEvent) => _,
    onChangeText: PropTypes.(String) => _,
    onChange: PropTypes.(NEvent) => _,
    onEndEditing: PropTypes.func,
    onSubmitEditing: PropTypes.(NEvent) => _,
    placeholder: PropTypes.string,
    placeholderTextColor: PropTypes.string,
    selectionState: PropTypes.DocumentSelectionState,
    value: PropTypes.string,
    bufferDelay: PropTypes.number,
    controlled: PropTypes.bool,
    clearButtonMode: PropTypes.string,
    clearTextOnFocus: PropTypes.bool,
    selectTextOnFocus: PropTypes.bool,
    testID: PropTypes.string,

 */


case class TextInput(onBlur : UndefOr[(NEvent) => _] = undefined,
                     placeholderTextColor : UndefOr[String] = undefined,
                     multiline : UndefOr[Boolean]=undefined,
                     style : UndefOr[js.Any] = undefined,
                     onChange : UndefOr[(NEvent) => _] = undefined,
                     keyboardType : UndefOr[String] = undefined,
                     selectionState : UndefOr[DocumentSelectionState] = undefined,
                     clearTextOnFocus : UndefOr[Boolean]=undefined,
                     ref : UndefOr[String] = undefined,
                     onSubmitEditing : UndefOr[(NEvent) => _] = undefined,
                     placeholder : UndefOr[String] = undefined,
                     onChangeText : UndefOr[(String) => _] = undefined,
                     autoFocus : UndefOr[Boolean]=undefined,
                     autoCorrect : UndefOr[Boolean]=undefined,
                     autoCapitalize : UndefOr[AutoCapitalize] = undefined,
                     key : UndefOr[String] = undefined,
                     bufferDelay : UndefOr[Int] = undefined,
                     onEndEditing : UndefOr[(NEvent) => _] = undefined ,
                     testID : UndefOr[String] = undefined,
                     controlled : UndefOr[Boolean]=undefined,
                     onFocus : UndefOr[(NEvent) => _] = undefined,
                     clearButtonMode : UndefOr[String] = undefined,
                     value : UndefOr[String] = undefined,
                     selectTextOnFocus : UndefOr[Boolean]=undefined,
                     editable : UndefOr[Boolean]=undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    onBlur.foreach(v => p.updateDynamic("onBlur")(v))
    placeholderTextColor.foreach(v => p.updateDynamic("placeholderTextColor")(v))
    multiline.foreach(v => p.updateDynamic("multiline")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    keyboardType.foreach(v => p.updateDynamic("keyboardType")(v))
    selectionState.foreach(v => p.updateDynamic("selectionState")(v))
    clearTextOnFocus.foreach(v => p.updateDynamic("clearTextOnFocus")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    onSubmitEditing.foreach(v => p.updateDynamic("onSubmitEditing")(v))
    placeholder.foreach(v => p.updateDynamic("placeholder")(v))
    onChangeText.foreach(v => p.updateDynamic("onChangeText")(v))
    autoFocus.foreach(v => p.updateDynamic("autoFocus")(v))
    autoCorrect.foreach(v => p.updateDynamic("autoCorrect")(v))
    autoCapitalize.foreach(v => p.updateDynamic("autoCapitalize")(v.name))
    key.foreach(v => p.updateDynamic("key")(v))
    bufferDelay.foreach(v => p.updateDynamic("bufferDelay")(v))
    onEndEditing.foreach(v => p.updateDynamic("onEndEditing")(v))
    testID.foreach(v => p.updateDynamic("testID")(v))
    controlled.foreach(v => p.updateDynamic("controlled")(v))
    onFocus.foreach(v => p.updateDynamic("onFocus")(v))
    clearButtonMode.foreach(v => p.updateDynamic("clearButtonMode")(v))
    value.foreach(v => p.updateDynamic("value")(v))
    selectTextOnFocus.foreach(v => p.updateDynamic("selectTextOnFocus")(v))
    editable.foreach(v => p.updateDynamic("editable")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.TextInput)
     if(children.isEmpty)  f(toJS).asInstanceOf[ReactComponentU_]
     else f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

/**
 *  mounted TextInput component methods
 */
trait TextInputM extends js.Object {

  def blur() : Unit = js.native

}


case  class AutoCapitalize private (name : String) extends AnyVal

object AutoCapitalize {

  val NONE = new AutoCapitalize("none")

  val SENTENCES = new AutoCapitalize("sentences")

  val WORDS = new AutoCapitalize("words")

  val CHARACTERS = new AutoCapitalize("characters")

  def newType(name : String) = new AutoCapitalize(name)

}