package aviv.workshop.trombinoscope

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.WORKER_LIST.route(),
        builder = {
            addWorkerListScreen(navController)
            addWorkerDetails()
        }
    )
}

private fun NavGraphBuilder.addWorkerListScreen(navController: NavHostController) =
    composable(route = Screen.WORKER_LIST.route()) {
        WorkerListScreen(
            viewModel = viewModel(),
            navigateToDetails = {
                val route1 = Screen.WORKER_DETAILS.route() + "/${it.id}" // 'WORKER_DETAILS/1'
                navController.navigate(route1)
            }
        )
    }



private fun NavGraphBuilder.addWorkerDetails() {
    val workerId = "workerId"
    composable(route = Screen.WORKER_DETAILS.route() + "/{$workerId}", // 'WORKER_DETAILS/{workerId}'
        arguments = listOf(
            navArgument(workerId) {
                type = NavType.IntType
                defaultValue = 0
                nullable = false
            }
        )) {
        DetailsScreen(
            id = it.arguments?.getInt(workerId) ?: 0,
            viewModel = viewModel()
        )
    }
}

enum class Screen {
    WORKER_LIST,
    WORKER_DETAILS;

    fun route(): String = name
}

@Composable
@Preview(showBackground = true, widthDp = 600)
private fun DefaultPreview() {
    TrombinoscopeTheme {
        MainNavigation()
    }
}