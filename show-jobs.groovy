    import hudson.tasks.Shell

    def jobs = Jenkins.instance.getItems(AbstractProject.class)
    println '>>>>>>>>>> Total jobs = ' + jobs.size()

    List gitRepos = []
    jobs.each {
      if (it instanceof Project) { 
        List builders = it.getBuilders() 
        builders.each {
          if (it instanceof Shell ) { println it.getContents() }
        } 
      }
    }
	println ''
