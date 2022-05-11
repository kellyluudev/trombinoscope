package aviv.workshop.trombinoscope

sealed class Screen(val route: String) {
    object WorkerListScreen : Screen("worker_list_screen")
    object DetailScreen : Screen("detail_screen")
}