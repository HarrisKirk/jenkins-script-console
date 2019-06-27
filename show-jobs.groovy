    def jobs = Jenkins.instance.getAllItems(AbstractProject.class)
    println '>>>>>>>>>> Total jobs = ' + jobs.size()

    List gitRepos = []
    jobs.each {
      println it.getClass().getName()
    }

	println ''