name := "simflePlay"
 
version := "1.0" 
      
lazy val `simfleplay` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , evolutions, ehcache , ws , specs2 % Test , guice )
libraryDependencies +="com.h2database" % "h2" % "1.4.192"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      