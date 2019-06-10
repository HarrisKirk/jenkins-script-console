println(Jenkins.instance.pluginManager.plugins)

counter = 0
jobs = Jenkins.instance.getAllItems()
println "*** Job Count = " + jobs.size()
for (job in jobs) {
  if (job.scm instanceof hudson.plugins.git.GitSCM ){
    println job.name.padRight(70,'.') + ' has GitSCM'
  } else if (job.scm instanceof hudson.scm.NullSCM) {
    println job.name.padRight(70, '.') + ' null scm ' 
  } else {
 	println job.name.padRight(70, '.') + ' other scm '
  }
}