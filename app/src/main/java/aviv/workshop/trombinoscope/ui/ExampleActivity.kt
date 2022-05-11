package aviv.workshop.trombinoscope.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ViewCompositionStrategy
import aviv.workshop.trombinoscope.databinding.ActivityExampleBinding
import aviv.workshop.trombinoscope.ui.theme.TrombinoscopeTheme

class ExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.composeView.apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                TrombinoscopeTheme {
                    DetailScreen(name = "John Doe", jobTitle = "Android Engineer")
                }
            }
        }
    }
}