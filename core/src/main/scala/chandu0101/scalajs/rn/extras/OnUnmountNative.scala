package chandu0101.scalajs.rn.extras

import chandu0101.scalajs.rn.ReactNativeComponentB
import japgolly.scalajs.react.TopNode

/**
 * Its copy of scalajs-react OnUnmount
 * Accrues procedures to be run automatically when its component unmounts.
 *
 * Install in `ReactNativeComponentB` via `.configure(OnUnmount.install)`.
 */
trait OnUnmountNative {
  private var unmountProcs: List[() => Unit] = Nil
  final def runUnmount(): Unit = {
    unmountProcs foreach (_())
    unmountProcs = Nil
  }
  final def onUnmount(f: => Unit): Unit = unmountProcs ::= (() => f)
  final def onUnmountF(f: () => Unit): Unit = unmountProcs ::= f
}

object OnUnmountNative {
  def install[P, S, B <: OnUnmountNative,N <: TopNode] =
    (_: ReactNativeComponentB[P, S, B,TopNode]).componentWillUnmount(_.backend.runUnmount())

  /**
   * Convenience class for the frequent case that a component needs a backend with `OnUnmount` and nothing else.
   */
  final class Backend extends OnUnmountNative
}
