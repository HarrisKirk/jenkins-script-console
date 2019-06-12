class LdxJob {
  def name
  boolean isGit
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
  if (it.scm instanceof hudson.scm.NullSCM) {
    ldxJobs << new LdxJob(name: it.name, isGit: false, gitRepo: 'n/a', branch: '')
  } else {
    ldxJobs << new LdxJob(name: it.name, isGit: true, gitRepo: it.scm.properties['key'].tokenize('/').last(), branch: it.scm.properties['branches'])
  }
}

println '-' * 150
println 'All Jobs:'
println '-' * 150
ldxJobs.each{ println it.name.padRight(50,'.') + it.gitRepo }

println '-' * 150
println 'All non-git Jobs:'
println '-' * 150
ldxJobs.findAll{!it.isGit}.each{ println it.name.padRight(50,'.') + it.gitRepo }

println '-' * 150
println 'Unique git repos:'
println '-' * 150
ldxJobs.collect{ it.gitRepo }.unique().each{ println it }
  
println ''
println 'END'
