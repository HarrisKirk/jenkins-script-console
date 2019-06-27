    def jobs = Jenkins.instance.getItems(AbstractProject.class)
    println '>>>>>>>>>> Total jobs = ' + jobs.size()

    List gitRepos = []
    jobs.each {
      println it.name
    }

