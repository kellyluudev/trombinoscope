package aviv.workshop.trombinoscope

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import aviv.workshop.trombinoscope.details.DetailsScreen
import aviv.workshop.trombinoscope.list.WorkerListScreen

@Composable
fun MainNavigation() {
    val hostController = rememberNavController()
    NavHost(
        navController = hostController,
        startDestination = Screen.WORKER_LIST.name
    ) {
        composable(route = Screen.WORKER_LIST.name) {
            WorkerListScreen(
                viewModel = viewModel(),
                onItemClicked = { worker -> hostController.navigate(Screen.WORKER_DETAIL.name) }
            )
        }

        composable(route = Screen.WORKER_DETAIL.name, arguments = listOf(
            navArgument("worker") {
                type = NavType.ReferenceType
                defaultValue = "Unknown"
                nullable = false
            }
        )) {
            DetailsScreen(name = "name", jobTitle = "job title")
        }
    }
}

private enum class Screen {
    WORKER_LIST,
    WORKER_DETAIL
}