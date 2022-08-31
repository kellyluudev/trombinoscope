package aviv.workshop.trombinoscope.details

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.figma.atoms.H3Text

@Composable
fun DetailsScreen(name: String, jobTitle: String, id: Int, viewModel: DetailsViewModel) {
    Column {
        H3Text("Name: $name")
        H3Text("Job title: $jobTitle")
    }
}