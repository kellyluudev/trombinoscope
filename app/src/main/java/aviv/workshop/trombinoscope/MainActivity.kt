package aviv.workshop.trombinoscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import aviv.workshop.trombinoscope.ui.theme.TrombinoscopeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrombinoscopeTheme {

            }
        }
    }
}