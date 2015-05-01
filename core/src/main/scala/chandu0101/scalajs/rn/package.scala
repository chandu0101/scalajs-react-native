
package chandu0101.scalajs


import chandu0101.scalajs.rn.components.ListViewDataSource

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g, literal => json}


package object rn {
  @inline def load[T](lib: String): T = g.require(lib).asInstanceOf[T]

  lazy val ReactNative = load[ReactNative]("react-native")


  type NEvent = js.Dynamic

  def createListViewDataSource[T,H](rowHasChanged: (T, T) => Boolean,sectionHeaderHasChanged: js.UndefOr[(H,H) => Boolean] = js.undefined): ListViewDataSource[T] = {
    val ListDataSource = ReactNative.ListView.asInstanceOf[js.Dynamic].DataSource
    val j = json(rowHasChanged = rowHasChanged)
    sectionHeaderHasChanged.foreach(v => j.updateDynamic("sectionHeaderHasChanged")(v))
    js.Dynamic.newInstance(ListDataSource)(j).asInstanceOf[ListViewDataSource[T]]
  }


}