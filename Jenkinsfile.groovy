pipeline {
        agent any
        stages {
            stage('Script-01') {
                steps {
                    script {
                            build job: 'Script-01'
                        }
                    }
               }   
            stage('Script-02') {
                steps {
                    script {
                            build job: 'Script-02'
                        }
                    }
               }
			stage('Jira') {
				steps {
					script {
							comment_issues ()
					}
				}
			}
        }
}

void comment_issues () {
    def issue_pattern = "RID-\\d+"
    currentBuild.changeSets.each {changeSet ->
        changeSet.each { commit ->
            String msg = commit.getMsg ()
            msg.findAll (issue_pattern).each {
                id -> jiraAddComment idOrKey: id, comment: 'Hi there!'
            }
        }
    }
}