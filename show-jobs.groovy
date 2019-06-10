def allJobs = Jenkins.instance.getAllItems(AbstractItem.class)
println "** Job count = " + allJobs.size()  
allJobs.each {
  	println(it.fullName)
}

