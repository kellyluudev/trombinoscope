package aviv.workshop.trombinoscope

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.figma.theme.TrombinoscopeTheme

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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
        TODO("Not yet implemented")
    }
}