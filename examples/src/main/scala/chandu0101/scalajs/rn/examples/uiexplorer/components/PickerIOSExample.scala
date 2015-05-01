package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import japgolly.scalajs.react.BackendScope
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}


object PickerIOSExample extends UIExample {

  case class CarMake(name: String, models: js.Array[String])

  case class State(carMake: String = "cadillac", modelIndex: Int = 3)

  class Backend(t: BackendScope[_, State]) {
    def handleCarMakeChange(carMake: String) = {
      t.modState(_.copy(carMake = carMake,modelIndex = 0))
    }

    def handleCarModelChange(modelIndex: Int) = {
      t.modState(_.copy(modelIndex = modelIndex))
    }
  }

  val component = ReactNativeComponentB[Unit]("PickerIOSExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    val make = CAR_MAKES_AND_MODELS.selectDynamic(S.carMake)
    val selectionString = s"${make.name.toString} ${make.models.asInstanceOf[js.Array[String]]((S.modelIndex))}"
    UIExplorerPage(
      UIExplorerBlock("PickerIOS")(
        View()(
          Text()("Please choose a make for your car :"),
          PickerIOS(selectedValue = S.carMake,
            onValueChange = B.handleCarMakeChange _)(
              js.Object.keys(CAR_MAKES_AND_MODELS.asInstanceOf[js.Object]).map(key => {
                PickerItemIOS(key = key, value = key, label = CAR_MAKES_AND_MODELS.selectDynamic(key).name.toString)
              })
            ),
          Text()(s"Please choose a model of ${make.name.toString} :"),
          PickerIOS(key = S.carMake, selectedValue = S.modelIndex,
            onValueChange = B.handleCarModelChange _)(
              CAR_MAKES_AND_MODELS.selectDynamic(S.carMake).models.asInstanceOf[js.Array[String]].zipWithIndex
                .map {
                case (modelName, index) => PickerItemIOS(
                  key = s"${S.carMake}_${index.toString}",
                  value = index,
                  label = modelName
                )
              }
            ),
          Text()(s"You selected : ${selectionString}")
        )
      )
    )
  }).buildNative

  object styles extends NativeStyleSheet {


  }

  override def title: String = "PickerIOS"

  override def description: String = "Render lists of selectable options with UIPickerView."

  val CAR_MAKES_AND_MODELS = json(
    amc = json(
      name = "AMC",
      models = js.Array("AMX", "Concord", "Eagle", "Gremlin", "Matador", "Pacer")
    ),
    alfa = json(
      name = "Alfa-Romeo",
      models = js.Array("159", "4C", "Alfasud", "Brera", "GTV6", "Giulia", "MiTo", "Spider")
    ),
    aston = json(
      name = "Aston Martin",
      models = js.Array("DB5", "DB9", "DBS", "Rapide", "Vanquish", "Vantage")
    ),
    audi = json(
      name = "Audi",
      models = js.Array("90", "4000", "5000", "A3", "A4", "A5", "A6", "A7", "A8", "Q5", "Q7")
    ),
    austin = json(
      name = "Austin",
      models = js.Array("America", "Maestro", "Maxi", "Mini", "Montego", "Princess")
    ),
    borgward = json(
      name = "Borgward",
      models = js.Array("Hansa", "Isabella", "P100")
    ),
    buick = json(
      name = "Buick",
      models = js.Array("Electra", "LaCrosse", "LeSabre", "Park Avenue", "Regal",
        "Roadmaster", "Skylark")
    ),
    cadillac = json(
      name = "Cadillac",
      models = js.Array("Catera", "Cimarron", "Eldorado", "Fleetwood", "Sedan de Ville")
    ),
    chevrolet = json(
      name = "Chevrolet",
      models = js.Array("Astro", "Aveo", "Bel Air", "Captiva", "Cavalier", "Chevelle",
        "Corvair", "Corvette", "Cruze", "Nova", "SS", "Vega", "Volt")
    )
  )
}
