    def jobs = Jenkins.instance.getItems(AbstractProject.class)
    println '>>>>>>>>>> Total jobs = ' + jobs.size()

    List gitRepos = []
    jobs.each {
      if (it instanceof Project) { println it.getBuilders() }
    }
	println ''
