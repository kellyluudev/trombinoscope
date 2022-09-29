package aviv.workshop.trombinoscope.details

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.figma.atoms.H3Text

@Composable
fun DetailsScreen(id: Int, viewModel: DetailsViewModel) {
    val worker = viewModel.getWorkerById(id)
    Column {
        H3Text("Name: ${worker.name}")
        H3Text("Job title: ${worker.jobTitle}")
    }
}