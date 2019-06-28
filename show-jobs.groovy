    import hudson.tasks.Shell

	def jobs = Jenkins.instance.getItems(AbstractProject.class).findAll{ !it.disabled }
    println '>>>>>>>>>> Total jobs = ' + jobs.size()

    List gitRepos = []
    jobs.each {
      if (it instanceof Project) { 
        println '>>>>>>>>>>>> Processing ' + it.name 
        println ''
        List builders = it.getBuilders() 
        builders.each {
          println "Shell command:"
          if (it instanceof Shell ) { println it.getContents().replaceAll("(?m)^", "\t") }
        } 
      } else {
         println '>>>>>>>>>>>> Ignoring ' + it.name 
      }
    }
	println ''
