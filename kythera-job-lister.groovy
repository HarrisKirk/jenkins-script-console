//println(Jenkins.instance.pluginManager.plugins)

counter = 0
jobs = Jenkins.instance.getAllItems()
println "*** Job Count = " + jobs.size()
for (job in jobs) {
  println ">>" + job.properties
}

return ''
