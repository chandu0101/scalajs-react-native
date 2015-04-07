package chandu0101.scalajs.rn.apis

import scala.scalajs.js

/**
 * Created by chandrasekharkode on 4/2/15.
 */
trait AsyncStorage extends js.Object{

  def getItem(key : String,callback : js.Function2[js.Dynamic,js.Dynamic,Unit] = ???):Unit = js.native
  def setItem(key : String,value : String,callback : js.Function1[js.Dynamic,Unit] = ???):Unit = js.native
  def mergeItem(key : String,value : String,callback : js.Function1[js.Dynamic,Unit] = ???):Unit = js.native
  def removeItem(key : String,callback : js.Function1[js.Dynamic,Unit] = ???):Unit = js.native
  def clear(callback : js.Function1[js.Dynamic,Unit] = ???):Unit = js.native
  def getAllKeys(callback : js.Function1[js.Dynamic,Unit] = ???):Unit = js.native
  def multiGet(keys : js.Array[String], callback : js.Function2[js.UndefOr[js.Array[js.Dynamic]],js.UndefOr[js.Array[js.Array[String]]],Unit] ):Unit = js.native
  def multiSet(keyValuePairs : js.Array[js.Array[String]], callback : js.Function1[js.UndefOr[js.Array[js.Dynamic]],Unit]= ??? ):Unit = js.native
  def multiMerge(keyValuePairs : js.Array[js.Array[String]], callback : js.Function1[js.UndefOr[js.Array[js.Dynamic]],Unit]= ??? ):Unit = js.native

}
