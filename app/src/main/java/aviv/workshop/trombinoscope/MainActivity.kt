package aviv.workshop.trombinoscope

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.figma.theme.TrombinoscopeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            TrombinoscopeTheme {
                WorkerScreen()
            }
        }
    }

    @Composable
    private fun WorkerScreen() {
        TODO("Not yet implemented")
    }
}