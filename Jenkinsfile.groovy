pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    script {
                            build job: 'Script-01'
							build job: 'Script-02'
                        }
                    }
            }
            stage('Packaging') {
                steps{
                    script {
                        build job: 'Package_Dataset'
                        jiraAssignIssue site:'Rocket Innovation Day', idOrKey: params.Packaging_Id, userName : 'kdayma'
                        packageComment = [body:"Package Dataset TS4866.TEMP.ABJTLOAD TS4866.TEMP.ABJTSAMP"]
                        jiraAddComment site: 'Rocket Innovation Day', idOrKey: params.Packaging_Id, input: packageComment, auditLog: false
                    }
                }
            }
			stage('Jira') {
				steps {
					script {
							successComment = [body:" Successfully scanned"]
							def id = params.JiraID
							if (id.isEmpty()){
							    echo "Id is empty"
							}
							echo "We are successful in JIRA with success comment"
							jiraAddComment site: 'Rocket Innovation Day', idOrKey: params.JiraID, input: successComment, auditLog: false
							echo "Comment published"
					}
				}
			}
			stage('Slack') {
				steps {
					script {
						echo "Integrating Slack Message"
						slackSend color: "good", message: "Message from Jenkins Pipeline got completed..."
						slackSend(channel: params.SlackUserId, message: "Message from Jenkins Pipeline got completed...")
						echo "Slack Message send"
					}
				}
			}
        }
}