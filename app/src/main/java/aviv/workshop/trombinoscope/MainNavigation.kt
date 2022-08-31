package aviv.workshop.trombinoscope

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
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
        addWorkerList(hostController)
        addWorkerDetails()
    }
}

private fun NavGraphBuilder.addWorkerList(hostController: NavHostController) =
    composable(route = Screen.WORKER_LIST.name) {
        WorkerListScreen(
            viewModel = viewModel(),
            onItemClicked = { worker ->
                val workerListRoute = Screen.WORKER_DETAIL.name + "/${worker.id}"
                hostController.navigate(workerListRoute)
            }
        )
    }

private fun NavGraphBuilder.addWorkerDetails() =
    composable(route = Screen.WORKER_DETAIL.name, arguments = listOf(
        navArgument("workerId") {
            type = NavType.ReferenceType
            defaultValue = "Unknown"
            nullable = false
        }
    )) {
        DetailsScreen(name = "name", jobTitle = "job title")
    }

private enum class Screen {
    WORKER_LIST,
    WORKER_DETAIL
}