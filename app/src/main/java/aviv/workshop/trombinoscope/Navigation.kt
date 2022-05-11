package aviv.workshop.trombinoscope

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import aviv.workshop.trombinoscope.ui.DetailScreen
import aviv.workshop.trombinoscope.ui.WorkerScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WorkerListScreen.route
    ) {
        composable(route = Screen.WorkerListScreen.route) {
            WorkerScreen(navController = navController, viewModel())
        }

        composable(
            route = Screen.DetailScreen.route
        ) {
            DetailScreen(name = "name", jobTitle = "job title")
        }
    }
}