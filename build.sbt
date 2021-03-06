name := "simflePlay"
 
version := "1.0" 
      
lazy val `simfleplay` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

//jdbc library delete, jdbc ,evloutions delete
libraryDependencies ++= Seq(ehcache , ws , specs2 % Test , guice )
libraryDependencies +="com.h2database" % "h2" % "1.4.192"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.3"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3"
//libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.2" % Test



unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      