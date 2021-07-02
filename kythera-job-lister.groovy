counter = 0
jobs = Jenkins.instance.getItems()
println "*** Job Count = " + jobs.size()
for (job in jobs) {
  println ">>" + job.name
}

return ''
