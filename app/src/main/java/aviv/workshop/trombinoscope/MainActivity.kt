package aviv.workshop.trombinoscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import aviv.workshop.trombinoscope.list.WorkerListViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = WorkerListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrombinoscopeTheme {
                MainNavigation()
            }
        }
    }
}

@Composable
@Preview(showBackground = false, widthDp = 600)
private fun DefaultPreview() {
    TrombinoscopeTheme {
        MainNavigation()
    }
}