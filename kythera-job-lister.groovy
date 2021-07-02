counter = 0
jobs = Jenkins.instance.getItems()
println "*** Job Count = " + jobs.size()
for (job in jobs) {
  println job.name.padRight(55,'.') + job.class.name
}

return ''
