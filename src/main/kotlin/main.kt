import org.eclipse.egit.github.core.client.GitHubClient

fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Three arguments expected: <login> <password> <organization's name>")
        return
    }

    val login = args[0]
    val password = args[1]
    val organization = args[2]

    val accessService = AccessService(GitHubClient())
    accessService.signIn(login, password)
    accessService.printMembersOfAllTeams(organization)
}