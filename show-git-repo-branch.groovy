class LdxJob {
  boolean isDisabled
  def name
  boolean isGit
  String gitRepo
  String branch
  List downstreamProjects
}
List ldxJobs = []

counter = 0
jobs = Jenkins.instance.getItems(AbstractProject.class)
println '>>>>>>>>>> Total jobs = ' + jobs.size()
def gitScmJobs = []

List gitRepos = []
jobs.each {
  if (it.scm instanceof hudson.scm.NullSCM) {
    ldxJobs << new LdxJob(name: it.name, isGit: false, gitRepo: 'n/a', branch: '', isDisabled: it.disabled, downstreamProjects: it.getDownstreamProjects().collect{it.name})
  } else {
    ldxJobs << new LdxJob(name: it.name, isGit: true, gitRepo: it.scm.properties['key'].tokenize('/').last(), branch: it.scm.properties['branches'], isDisabled: it.disabled, downstreamProjects: it.getDownstreamProjects().collect{it.name})
  }
}

println '-' * 150
println 'All Jobs:'
println '-' * 150
ldxJobs.each{ println it.name.padRight(50,'.') + it.gitRepo.padRight(50,'.') + (it.isDisabled ?: '') + it.downstreamProjects }

println '-' * 150
println 'All non-git Jobs:'
println '-' * 150
ldxJobs.findAll{!it.isGit}.each{ println it.name.padRight(50,'.') + ' disabled ' + (it.isDisabled ?: '') + it.downstreamProjects }

println '-' * 150
println 'Unique git repos:'
println '-' * 150
ldxJobs.collect{ it.gitRepo }.unique().each{ println it }
  
println ''
println 'END'
