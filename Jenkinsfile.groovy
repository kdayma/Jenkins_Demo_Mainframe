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
							successComment = " Successfully scanned"
							echo "We are successful in JIRA with success comment"
							jiraAddComment idOrKey: 'RID-5', input: successComment, auditLog: false
							echo "Commnet published"
					}
				}
			}
        }
}