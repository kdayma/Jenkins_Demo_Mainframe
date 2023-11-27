pipeline {
        agent any
        stages {
			stage('Build') {
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
			}
			stage('Jira') {
				steps {
					script {
							successComment = [body:" Successfully scanned"]
							
							echo "We are successful in JIRA with success comment"
							jiraAddComment site: 'Rocket Innovation Day', idOrKey: 'RID-5', input: successComment, auditLog: false
							echo "Comment published"
					}
				}
			}
			stage('Slack') {
				steps {
					script {
						echo "Integrating Slack Message"
						slackSend color: "good", message: "Message from Jenkins Pipeline got completed..."
						slackSend(channel: "Keshav Dayma", message: "Message from Jenkins Pipeline got completed...")
						echo "Slack Message send"
					}
				}
			}
        }
}