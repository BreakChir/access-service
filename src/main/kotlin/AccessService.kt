import org.eclipse.egit.github.core.client.GitHubClient
import org.eclipse.egit.github.core.service.GitHubService
import org.eclipse.egit.github.core.service.TeamService

class AccessService(
    client: GitHubClient
) : GitHubService(client) {

    fun signIn(login: String, password: String) {
        client.setCredentials(login, password)
    }

    fun printMembersOfAllTeams(organization: String) {
        val teamService = TeamService(client)
        val teams = teamService.getTeams(organization)
        teams.forEach { team ->
            println("Team: ${team.name}")
            val users = teamService.getMembers(team.id)
            users.forEach { user ->
                println("   ${user.login}")
            }
        }
    }
}