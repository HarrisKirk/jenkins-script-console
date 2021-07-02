println '-' *80

counter = 0
jobs = Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject)
println "*** Job Count = " + jobs.size()
job = jobs[0]
for (gen in job.getItems()) {
  println gen
}



return ''
