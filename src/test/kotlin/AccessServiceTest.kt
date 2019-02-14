import org.eclipse.egit.github.core.client.GitHubClient
import org.junit.Test

class ParserTest {

    @Test
    fun testPrintMembersOfAllTeams() {
        val login = "testacc99"
        val password = "gfhjdjp432"
        val organization = "testacc99organization"

        val accessService = AccessService(GitHubClient())
        accessService.signIn(login, password)
        accessService.printMembersOfAllTeams(organization)
    }
}