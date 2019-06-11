counter = 0
jobs = Jenkins.instance.getAllItems()
println '>>>>>>>>>> Total jobs = ' + jobs.size()
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
List gitRepos = []
gitScmJobs.each {
  //println it.name.padRight(70,'.') + it.scm.properties['key'].padRight(60)  + '  ' + it.scm.properties['branches'] 
  println it.name.padRight(80,'.') + it.scm.properties['key'].tokenize('/').takeRight(2).toString().padRight(60)  + '  ' + it.scm.properties['branches'] 
  gitRepos << it.scm.properties['key'].tokenize('/').last()
  //println it.name.padRight(70,'.') + ' has GitSCM with ' + it.scm.properties
}

println '-' * 150
println 'Unique git repos:'
println '-' * 150

gitRepos.unique().each { println it }
  
println 'END'
