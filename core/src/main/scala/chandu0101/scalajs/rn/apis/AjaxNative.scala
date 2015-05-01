package chandu0101.scalajs.rn.apis

import org.scalajs.dom
import org.scalajs.dom.XMLHttpRequest

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

// this is rip of scala-js dom ext Ajax API

/**
 * Thrown when `Ajax.get` or `Ajax.post` receives a non-20X response code.
 * Contains the XMLHttpRequest that resulted in that response
 */
case class AjaxException(xhr: XMLHttpRequest) extends Exception {
  def isTimeout = xhr.status == 0 && xhr.readyState == 4
}
object AjaxNative {
  def get(url: String,
          data: String = "",
          timeout: Int = 0,
          headers: Map[String, String] = Map.empty,
          withCredentials: Boolean = false,
          responseType: String = "") = {
    apply("GET", url, data, timeout, headers, withCredentials, responseType)
  }
  def post(url: String,
           data: String = "",
           timeout: Int = 0,
           headers: Map[String, String] = Map.empty,
           withCredentials: Boolean = false,
           responseType: String = "") = {
    apply("POST", url, data, timeout, headers, withCredentials, responseType)
  }
  def put(url: String,
          data: String = "",
          timeout: Int = 0,
          headers: Map[String, String] = Map.empty,
          withCredentials: Boolean = false,
          responseType: String = "") = {
    apply("PUT", url, data, timeout, headers, withCredentials, responseType)
  }
  def delete(url: String,
             data: String = "",
             timeout: Int = 0,
             headers: Map[String, String] = Map.empty,
             withCredentials: Boolean = false,
             responseType: String = "") = {
    apply("DELETE", url, data, timeout, headers, withCredentials, responseType)
  }
  def apply(method: String,
            url: String,
            data: String,
            timeout: Int,
            headers: Map[String, String],
            withCredentials: Boolean,
            responseType: String): Future[dom.XMLHttpRequest] = {
    val req = js.Dynamic.newInstance(js.Dynamic.global.require("XMLHttpRequest"))().asInstanceOf[XMLHttpRequest]
    val promise = Promise[dom.XMLHttpRequest]()

    req.onreadystatechange = {(e: dom.Event) =>
      if (req.readyState.toInt == 4){
        if ((req.status >= 200 && req.status < 300) || req.status == 304)
          promise.success(req)
        else
          promise.failure(AjaxException(req))
      }
    }
    req.open(method, url)
    req.responseType = responseType
    req.timeout = timeout
    req.withCredentials = withCredentials
    headers.foreach(x => req.setRequestHeader(x._1, x._2))
    req.send(data)
    promise.future
  }
}
