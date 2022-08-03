package aviv.workshop.trombinoscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrombinoscopeTheme {
                WorkerScreen(viewModel.getWorkers())
            }
        }
    }

    @Composable
    private fun WorkerScreen(workers: List<Worker>) {
        WorkerItem(workers.first())
    }

     @Composable
    private fun WorkerItem(worker: Worker) {
        Column {
            Text(text = worker.name)
            Text(worker.arrivalDate)
            Text(worker.jobTitle)
            Button(
                onClick = {}
            ) {
                Text(text = "Show details")
            }
            Image(
                painter = painterResource(worker.pictureRes),
                contentDescription = "Worker picture"
            )
        }
    }
}