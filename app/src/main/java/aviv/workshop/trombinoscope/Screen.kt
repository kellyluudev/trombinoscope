package aviv.workshop.trombinoscope

sealed class Screen(val route: String) {
    object WorkerListScreen : Screen("worker_list_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}