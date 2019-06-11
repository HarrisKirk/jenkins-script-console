class LdxJob {
  def name
  String gitRepo
  String branch
}
List ldxJobs = []

counter = 0
jobs = Jenkins.instance.getItems(AbstractProject.class)
println '>>>>>>>>>> Total jobs = ' + jobs.size()
def gitScmJobs = []

List gitRepos = []
jobs.each {
  ldxJobs << new LdxJob(name: it.name, gitRepo: it.scm.properties['key'].tokenize('/').last(), branch: it.scm.properties['branches'])
}

println '-' * 150
println 'Jobs:'
println '-' * 150
ldxJobs.each{ println it.name.padRight(50,'.') + it.gitRepo }

println '-' * 150
println 'Unique git repos:'
println '-' * 150
ldxJobs.collect{ it.gitRepo }.unique().each{ println it }
  
println 'END'
