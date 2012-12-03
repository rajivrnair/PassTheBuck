import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

	val appName = "PassTheBuck"
	val appVersion = "1.0-SNAPSHOT"

	val appDependencies = Seq(
		// Add your project dependencies here,
		"com.feth" %% "play-authenticate" % "0.2.2-SNAPSHOT"
	)

	val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
		// Add your own project settings here      
		resolvers += Resolver.url("play-easymail (release)", url("http://joscha.github.com/play-easymail/repo/releases/"))(Resolver.ivyStylePatterns),
		resolvers += Resolver.url("play-easymail (snapshot)", url("http://joscha.github.com/play-easymail/repo/snapshots/"))(Resolver.ivyStylePatterns),

		resolvers += Resolver.url("play-authenticate (release)", url("http://joscha.github.com/play-authenticate/repo/releases/"))(Resolver.ivyStylePatterns),
		resolvers += Resolver.url("play-authenticate (snapshot)", url("http://joscha.github.com/play-authenticate/repo/snapshots/"))(Resolver.ivyStylePatterns)
	)
}
