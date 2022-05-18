package aviv.workshop.trombinoscope

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import aviv.workshop.trombinoscope.ui.DetailScreen
import aviv.workshop.trombinoscope.ui.WorkerRoute

const val NAME_KEY = "name"
const val JOB_TITLE_KEY = "job_title"

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WorkerListScreen.route
    ) {
        composable(route = Screen.WorkerListScreen.route) {
            WorkerRoute(
                viewModel = viewModel(),
                navigateToDetails = {
                    navController.navigate(Screen.DetailScreen.route)
                }
            )
        }

        composable(
            route = Screen.DetailScreen.route + "/{$NAME_KEY}/{$JOB_TITLE_KEY}",
            arguments = listOf(
                navArgument(NAME_KEY) {
                    type = NavType.StringType
                    defaultValue = "Unknown"
                    nullable = true
                },
                navArgument(JOB_TITLE_KEY) {
                    type = NavType.StringType
                    defaultValue = "Unknown"
                    nullable = true
                }
            )
        ) { entry ->
            DetailScreen(
                name = entry.arguments?.getString(NAME_KEY),
                jobTitle = entry.arguments?.getString(JOB_TITLE_KEY)
            )
        }
    }
}