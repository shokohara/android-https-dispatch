import android.Keys._

android.Plugin.androidBuild

name := "android-https-dispatch"

scalaVersion := "2.11.2"

resolvers ++= Seq(
  "Sonatype Repository" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "com.android.support" % "support-v4" % "20.0.0",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.1"
)

apkbuildExcludes in Android ++= Seq(
  "META-INF/LICENSE",
  "META-INF/LICENSE.txt",
  "META-INF/NOTICE",
  "META-INF/NOTICE.txt",
  "META-INF/rootdoc.txt",
  "META-INF/MANIFEST.MF",
  "overview.html"
)

unmanagedClasspath in Compile := (unmanagedClasspath in Compile).value.filterNot(_.data.getName == "android-support-v4.jar")

run <<= run in Android

incOptions := incOptions.value.withNameHashing(true)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation"
)

dexMaxHeap in Android := "8192m"

logLevel in Global := Level.Debug
