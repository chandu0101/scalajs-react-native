# scalajs-react-native

ScalaJS wrapper for [react-native](https://facebook.github.io/react-native/) , as react-native depends on [reactjs](http://facebook.github.io/react/), scalajs-react-native depends on [scalajs-react](https://github.com/japgolly/scalajs-react)


## Documentation : 

scalajs-react-native comes with ReactNativeComponentB (its clone of  ReactComponentB with native dependencies and extra helper method ).

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

to define root component use buildNative method from builder

example : 

```scala

  val ScalaJSReactNative = ReactNativeComponentB[Unit]("ScalaJSReactNative")
      .render((P) => {
        HelloNative()
    }).buildNative

    ReactNative.AppRegistry.registerComponent("ScalaJSReactNative", () => ScalaJSReactNative)
    
```

### Status:
Its still in pre-alpha stage ,play with it, discuss about issues and send PR's if possible :)


### How to use it in projects :

```scala

// clone  project

git clone https://github.com/chandu0101/scalajs-react-native

//pulishLocal

cd scalajs-react-native

sbt publishLocal

// use it in your projects (add to your build.sbt)

val scalajsReactNativeVersion = "0.1.0-SNAPSHOT"

libraryDependencies += "com.chandu0101.scalajs-react-native" %%% "core" % scalajsReactNativeVersion

// thanks to @gzmo for genReactFile task 
val genReactFile = Def.taskKey[File]("Generate the file given to react native")

artifactPath in Compile in genReactFile :=
  baseDirectory.value / "index.ios.js"

genReactFile in Compile := {
  val outFile = (artifactPath in Compile in genReactFile).value

  IO.copyFile((fullOptJS in Compile).value.data, outFile)

  val launcher = (scalaJSLauncher in Compile).value.data.content
  IO.append(outFile, launcher)

  outFile
}


// run genReactFile task 

sbt ~genReactFile

// Happy Coding :) 

```

### How to run examples : 

```scala

 cd examples
 
 // start react-native package
 
 npm run start 
 
 sbt ~genReactFile
 
 Open ScalaJSReactNative.xcodeproj using xcode
 
 Cmd+R - to run project
 
 Cmd+D - to debug project
 
 Cmd+B - to build
 
 Cmd+Shift+K - to cleanup

```
