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
                val detailsRoute = Screen.WORKER_DETAIL.name + "/${worker.id}"
                hostController.navigate(detailsRoute)
            }
        )
    }

private fun NavGraphBuilder.addWorkerDetails() {
    val id = "workerId"
    val detailsRoute = Screen.WORKER_DETAIL.name + "/{$id}"
    composable(route = detailsRoute,
        arguments = listOf(
            navArgument(id) {
                type = NavType.IntType
                defaultValue = 0
                nullable = false
            }
        )) {
        DetailsScreen(
            workerId = it.arguments?.getInt(id) ?: 0,
            viewModel = viewModel()
        )
    }
}

private enum class Screen {
    WORKER_LIST,
    WORKER_DETAIL
}