package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.apis.{AsyncStorage, AsyncStorageException}
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.async.Async._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js

object AsyncStorageExample extends UIExample {

  val STORAGE_KEY = "@AsyncStorageExample:key"
  val COLORS = js.Array("red", "orange", "yellow", "green", "blue")

  case class State(selectedValue: String = COLORS.head, messages: js.Array[String] = js.Array())

  class Backend(t: BackendScope[_, State]) {

    def appendMessage(message: String) = {
      t.modState(s => s.copy(messages = s.messages.+:(message)))
    }

    val saveError: PartialFunction[Throwable, _] = {
      case (ex: Throwable) => {
        appendMessage(s"AsyncStorage Error ${ex.asInstanceOf[AsyncStorageException].err.message.toString}")
      }
    }

    def onValueChange(selectedValue: String) : Unit = {
      t.modState(_.copy(selectedValue = selectedValue))
      async {
        val result = await(AsyncStorage.setItem(STORAGE_KEY, selectedValue))
        appendMessage(s"Saved selection to disk ${selectedValue}")
      }.recover(saveError)
    }

    def removeStorage : Unit = async{
      val result = await(AsyncStorage.removeItem(STORAGE_KEY))
      appendMessage(s"Selection Removed from Disk")
    }.recover(saveError)
  }

  val component = ReactNativeComponentB[Unit]("AsyncStorageExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    UIExplorerPage(
     UIExplorerBlock("Basics - getItem, setItem, removeItem")(
       View()(
         PickerIOS(selectedValue = S.selectedValue,onValueChange = B.onValueChange _)(
           COLORS.map(v => PickerItemIOS(key = v , value = v,label = v))
         ),
         Text()("Selected : ",
           Text(style = styles.getColorStyle(S.selectedValue))(S.selectedValue)
         ),
         Text()(" "),
         Text(onPress = B.removeStorage _)("Press here to remove from storage"),
         Text()(" "),
         Text()("Messages : "),
         S.messages.map(m => Text()(m))
       )
     )
    )
  }).componentDidMount(scope => {
     async {
       val result = await(AsyncStorage.getItem(STORAGE_KEY))
       if (result != null) {
         scope.modState(_.copy(selectedValue = result))
         scope.backend.appendMessage(s"Recovered selection from disk : ${result}")
       } else {
         scope.backend.appendMessage(s"Initialized with no selection on disk")
       }
     }.recover(scope.backend.saveError)
  })
  .buildNative

  object styles extends NativeStyleSheet {

   def getColorStyle(c : String) = style(color := c)
  }

  override def title: String = "AsyncStorage"

  override def description: String = "Asynchronous local disk storage."
}
