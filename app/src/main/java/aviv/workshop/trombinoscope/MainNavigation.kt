package aviv.workshop.trombinoscope

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import aviv.workshop.trombinoscope.details.DetailsScreen
import aviv.workshop.trombinoscope.list.WorkerListScreen

@Composable
fun MainNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.WORKER_LIST.route(),
        builder = {
            composable(route = Screen.WORKER_LIST.route()) {
                WorkerListScreen(
                    viewModel = viewModel(),
                    navigateToDetails = {
                        val route1 = Screen.WORKER_DETAILS.route() + "/{$it.}"
                        navController.navigate(route1)
                    }
                )
            }

            composable(route = Screen.WORKER_DETAILS.route()) {
                DetailsScreen(name = "name", jobTitle = "jobTitle")
            }
        }
    )
}

enum class Screen {
    WORKER_LIST,
    WORKER_DETAILS;

    fun route(): String = name
}