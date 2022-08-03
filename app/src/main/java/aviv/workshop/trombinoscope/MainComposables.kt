package aviv.workshop.trombinoscope

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WorkerScreen(workers: List<Worker>) {
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

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    TrombinoscopeTheme {
        WorkerItem(Worker())
    }
}