Setting Up The Application
============================

##Installing Play

1. Download [http://www.playframework.org/](http://www.playframework.org/)
2. See [www.playframework.org/documentation](www.playframework.org/documentation) --> 'Installing Play' to install play.

##Git Stuff

-  For a proper tutorial on git, see http://progit.org/book/
- Once your git account is set up on your machine, go to your codebase directory and clone the github repository with the following command:

  `$ git clone git@github.com:rajivrnair/PassTheBuck.git`

This should clone repository from the remote server onto your local drive. 

##Sample output:

    nrajiv@blr-nairr-nw:/codebase/workspace$ git clone git@github.com:rajivrnair/PassTheBuck.git
    Cloning into 'PassTheBuck'...
    remote: Counting objects: 95, done.
    remote: Compressing objects: 100% (74/74), done.
    remote: Total 95 (delta 10), reused 92 (delta 7)
    Receiving objects: 100% (95/95), 67.61 KiB | 11 KiB/s, done.
    Resolving deltas: 100% (10/10), done.
    nrajiv@blr-nairr-nw:/codebase/workspace$

- To test that the aplication has been downloaded properly, go to the PassTheBuck directory and type the command `play run`.
Once the application starts, go to `http://localhost:9000` and log-in using your google account. Now
you should see a warning saying that a db script needs to be applied.

Apply it and the aplication should now be loaded up.


##Eclipse

- Ideally, you should install the scala ide for eclipse. See [http://scala-ide.org/docs/tutorials/play20scalaide20/index.html](http://scala-ide.org/docs/tutorials/play20scalaide20/index.html) and [http://scala-ide.org/docs/user/gettingstarted.html#gettingstarted-getting-started](http://scala-ide.org/docs/user/gettingstarted.html#gettingstarted-getting-started) for more details. 

- I've installed the 2.9.x version which is available at [http://scala-ide.org/download/current.html](http://scala-ide.org/download/current.html). Copy the update site url and install it in Eclipse. Look at [http://scala-ide.org/docs/user/advancedsetup.html](http://scala-ide.org/docs/user/advancedsetup.html) and remember to set the JDT setting.

-  By now you should've imported the project into eclipse. You might still see some errors but playing around with the classpath in Eclipse should see you through. What're you waiting for? Start Coding!
