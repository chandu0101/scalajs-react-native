#scalajs-react-native

[![Join the chat at https://gitter.im/chandu0101/scalajs-react-native](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/chandu0101/scalajs-react-native?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
ScalaJS wrapper for [react-native](https://facebook.github.io/react-native/) .This project depends on [scalajs-react](https://github.com/japgolly/scalajs-react) , so you must be familiar with scalajs-react in order to use this library.

![movies](examples/images/movies.gif) 


#Index 

- [Setup](#setup)
- [Styles](#styles)
- [Examples](#examples)
- [Project Template](#template)

#Setup

add this to your sbt build file

```scala

libraryDependencies += "com.github.chandu0101.scalajs-react-native" %%% "core" % "0.0.1"

```

imports 

```scala
import chandu0101.scalajs.rn._ // to import core builderReactNativeComponentB etc 
import chandu0101.scalajs.rn.components._ // for all native components
import chandu0101.scalajs.rn.apis._ // for native API calls


```

scalajs-react-native comes with ReactNativeComponentB (its clone of scalajs-react ReactComponentB with native dependencies and extra helper methods ).

#### Defining Components :

to define components just follow ReactComponentB guide lines

example : 

```scala
 val HelloNative = ReactNativeComponentB[Unit]("HelloNative")
    .render(P => {
    View(style = styles.container)(
       Text(style = styles.text)("Welcome to Scala-JS ReactNative"),
       Text(style = styles.text)("To get started, edit HelloNative.scala ")
    )
  }).buildU

```

#### Defining Root Component : 

to define root component use buildNative method from builder .

example : 

```scala

  val ScalaJSReactNative = ReactNativeComponentB[Unit]("ScalaJSReactNative")
      .render((P) => {
        HelloNative()
    }).buildNative //If your component is going to be render by other third party component then use buildNative

    ReactNative.AppRegistry.registerComponent("ScalaJSReactNative", () => ScalaJSReactNative)
    
```


#Styles

React Native doesn't implement CSS but instead relies on JavaScript to let you style your application. You can define styles in dynamic/typesafe way 

##### Dynamic Way :
 
 Use js.Dynamic.literal to define js styles
 
Example : 

```scala
 import scala.scalajs.js.Dynamic.{literal => json}
  val styles = ReactNative.StyleSheet.create(
    json(
      container = json(flex = 1,
        backgroundColor = "#F5FCFF"),
      textCenter = json(textAlign = "center",marginTop = 10)
    )
  )
  
  //access styles 
   View(style = styles.container)(..)
```  

###### TypeSafe Way :  

 In order to define styles in type safe manner you need styles module
 
 ```scala
 libraryDependencies += "com.github.chandu0101.scalajs-react-native" %%% "styles" % "0.0.1"
 
 ```
 
 extend ``trait NativeStyleSheet`` to define style sheets . NativeStyleSheet comes with two methods ``style`` (which takes attr value pairs)and ``styleE`` (this is used to extend already defined styles).
 
 Example : 
 
```scala 
  object styles extends NativeStyleSheet {
    val centering = style(
      alignItems.center,
      justifyContent.center
    )
    val gray = style(backgroundColor := "#cccccc")
    val horizontal = style(flexDirection.row, justifyContent.center)
    val default = styleE(centering, gray)(height := 40)
  }
  
 ```
  
#Examples

Number of examples can be found in [examples](https://github.com/chandu0101/scalajs-react-native/tree/master/examples) module

#### How to run examples :

```scala
 cd examples
 // start react-native package
 npm install
 npm run start 
 
// open new terminal tab/window
 sbt ~genReactFile
 
 Open ScalaJSReactNative.xcodeproj using xcode
 
 Cmd+R - to run project
 
 Cmd+D - to debug project
 
 Cmd+B - to build
 
 Cmd+Shift+K - to cleanup

```

#Template

A basic scalajs-react-native skeleton app can be found here

https://github.com/chandu0101/scalajs-react-native-template


