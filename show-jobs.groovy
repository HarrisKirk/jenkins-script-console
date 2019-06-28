    import hudson.tasks.Shell

	String prettyPrint(String jobName) {
      StringBuffer sb = new StringBuffer() 
      sb << '' + '\n'
      sb << '=' * jobName.size() + '\n'
      sb << jobName + '\n'
      sb << '=' * jobName.size() + '\n'
      sb.toString()
    }
  

	def jobs = Jenkins.instance.getItems(AbstractProject.class).findAll{ !it.disabled }
    println '>>>>>>>>>> Total enabled jobs = ' + jobs.size()

    List gitRepos = []
    jobs.each {
      if (it instanceof Project) { 
        println prettyPrint(it.name + ': ' + it.getClass().getName() )
        List builders = it.getBuilders() 
        builders.each {
          println "  Class name:" + it.getClass().getName()
          if (it instanceof Shell ) { println it.getContents().replaceAll("(?m)^", "\t\t") }

        } 
      } 
    }
	println ''
