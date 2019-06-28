    import hudson.tasks.Shell

	String prettyPrint(String jobName) {
      StringBuffer sb = new StringBuffer() 
      sb << '=' * jobName.size()
      sb << jobName
      sb << '=' * jobName.size()
      sb.toString()
    }
  

	def jobs = Jenkins.instance.getItems(AbstractProject.class).findAll{ !it.disabled }
    println '>>>>>>>>>> Total jobs = ' + jobs.size()

    List gitRepos = []
    jobs.each {
      if (it instanceof Project) { 
        println prettyPrint(it.name)
        List builders = it.getBuilders() 
        builders.each {
          println "Shell command:"
          if (it instanceof Shell ) { println it.getContents().replaceAll("(?m)^", "\t") }
        } 
      } 
    }
	println ''
