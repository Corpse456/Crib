package DbNames

pipeline {
    agent {
        label 'delphi'
    }
    parameters {
        booleanParam(name: 'UPDATE_DB', defaultValue: false, description: '')
    }
    stages {
        stage('Build') {
            steps {
                script {
                    env._DB_ACCOUNT = env.BRANCH_NAME
                    prepareEnvironments()

                    dir("Jenkins/sw-core") {
                        bat 'build.bat STOP_APPS_SERVERS'
                        bat 'build.bat COPY_EXE_FILES'
                        if (env.UPDATE_DB == "true") {
                            bat 'build.bat UPDATE_DB_ALL'
                        }
                        if (env.DB_DUMP_NEEDED == "true") {
                            bat 'build.bat MAKE_DB_DUMP'
                        }
                        if (env.UNLOCK_DB_USER == "true") {
                            bat 'build.bat UNLOCK_DB_USER'
                        }
                        if (env.COPY_JAVA == "true") {
                            bat 'build.bat COPY_SERVER_JARS'
                            bat 'build.bat COPY_CLIENT_JARS'
                            bat 'build.bat COPY_JAVA'
                        }
                        bat 'build.bat RUN_APPS_SERVERS'
                    }
                }
            }
        }
    }
    post {
        always {
            script {
                currentBuild.result = currentBuild.currentResult
            }
        }
        changed {
            script {
                sendEmail()
            }
        }
        success {
            buildSmokeTestJInventory()
            cleanWs notFailBuild: true
        }
    }
}

void sendEmail() {
    emailext body: '$DEFAULT_CONTENT', to: '$EMAIL_JIS_DEV_TEAM', replyTo: '$DEFAULT_REPLYTO', subject: '$DEFAULT_SUBJECT', recipientProviders: [culprits(), requestor()]
}

private void prepareEnvironments() {
    def data = readJSON file: '\\\\NAS\\\\SEAWARE Apps Server\\SwAccountLocations2.js'
    def schema = data."$_DB_ACCOUNT"
    env._APPS_COMP = schema.Machine.tokenize('.').first()
    if (schema.WSPort != null) {
        env._APPS_PORT = schema.WSPort
    }
    if (schema.Customer != null) {
        env._CUSTOMER = schema.Customer
    }
    if (schema.TNSName != null) {
        env._DB_TNS_NAME = schema.TNSName
    }
    env._DIR_APP = "\\\\${_APPS_COMP}\\SwServers"
    env._ALWAYSUP_ADDRESS = "${_APPS_COMP}:8585"
    env._use_git_branch = schema.GitBranch
    env.COPY_JAVA = schema.CopyJava
    if (schema.BuildRecipient != null) {
        env.BUILD_RECIPIENT = schema.BuildRecipient
    }
    if (schema.RepoCore != null) {
        env._REPO_SW_CORE = "${WORKSPACE}\\..\\" + schema.RepoCore
    }

    if (schema.RunBroker != null) {
        env.RUN_BROKER = schema.RunBroker
    }
    if (schema.NeedTest != null) {
        env.NEED_TEST = schema.NeedTest
    }
    if (schema.AccountDev != null) {
        env._DB_ACCOUNT_DEV = schema.AccountDev
    }
    if (schema.PasswordDev != null) {
        env._DB_ACCOUNT_DEV_PSW = schema.PasswordDev
    }
    if (schema.RepoSwJar != null) {
        env._REPO_SW_JAR = schema.RepoSwJar
    }
    if (schema.UPDATE_DB != null) {
        env.UPDATE_DB = schema.UpdateDb
    }
}

void buildSmokeTestJInventory() {
    if (env.NEED_TEST) {
        build job: 'Smoke_Test_JInventory', parameters: [string(name: 'db_schema', value: env._DB_ACCOUNT), string(name: 'db_user', value: 'VX_TANIAS'), string(name: 'db_password', value: 'nav'), string(name: 'db_url', value: "jdbc:oracle:thin:@$_DB_TNS_NAME"), string(name: 'webServiceEndPoint', value: 'http://$_APPS_COMP:$_APPS_PORT'), string(name: 'node_count', value: '2')]
    }
}
