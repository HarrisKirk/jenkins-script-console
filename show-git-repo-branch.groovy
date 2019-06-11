counter = 0
jobs = Jenkins.instance.getItems(AbstractProject.class)
println '>>>>>>>>>> Total jobs = ' + jobs.size()
def gitScmJobs = []

List gitRepos = []
jobs.each {
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
