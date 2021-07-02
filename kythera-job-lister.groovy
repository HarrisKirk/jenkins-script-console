counter = 0
jobs = Jenkins.instance.getItems()
println "*** Job Count = " + jobs.size()
for (job in jobs) {
  if (job.class.name == 'org.jenkinsci.plugins.workflow.job.WorkflowJob') {
	  println job.name.padRight(45,'.') + job.class.name.padRight(75,'.') + ' ' + job.getTypicalSCM()
  } else {
	  println job.name.padRight(45,'.') + job.class.name.padRight(75,'.') 
  }
}
return ''
