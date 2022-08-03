package aviv.workshop.trombinoscope

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import aviv.workshop.trombinoscope.details.DetailsScreen
import aviv.workshop.trombinoscope.list.WorkerScreen

@Composable
fun MainNavigation() {
    val hostController = rememberNavController()
    NavHost(
        navController = hostController,
        startDestination = Screen.WorkerListScreen.route
    ) {
        composable(route = Screen.WorkerListScreen.route) {
            WorkerScreen(
                viewModel = viewModel(),
                navigateToDetails = {
                    hostController.navigate(Screen.DetailScreen.route)
                }
            )
        }

        composable(route = Screen.DetailScreen.route) {
            DetailsScreen(name = "name", jobTitle = "job title")
        }
    }
}

sealed class Screen(val route: String) {
    object WorkerListScreen : Screen("worker_list_screen")
    object DetailScreen : Screen("detail_screen")
}