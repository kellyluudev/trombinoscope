package aviv.workshop.trombinoscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

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
}