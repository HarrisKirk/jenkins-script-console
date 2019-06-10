counter = 0
jobs = Jenkins.instance.getAllItems()
def gitScmJobs = []


for (job in jobs) {
  try {
	  if (job.scm instanceof hudson.plugins.git.GitSCM ){
            gitScmJobs << job
      }
  } catch (Exception e) {
    //   
    
  }

}

  println "*** Job Count = " + gitScmJobs.size()
  gitScmJobs.each {
    println it.name.padRight(70,'.') + ' has GitSCM'
  }

println ''