package aviv.workshop.trombinoscope

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
 fun WorkerScreen(workers: List<Worker>) {
    WorkerItem(worker = workers.first())
}

@Composable
private fun WorkerItem(worker: Worker) {
    Row {
        Column {
            Text(text = worker.name)
            Text(text = worker.jobTitle)
            Text(text = worker.arrivalDate)
            Button(onClick = {}) {
                Text(text = "Show details")
            }
    }
        Image(
            painter = painterResource(id = worker.pictureRes),
            contentDescription = "worker picture"
        )
    }
}

@Composable
@Preview(showBackground = true, widthDp = 320)
private fun DefaultPreview() {
    TrombinoscopeTheme {
        WorkerItem(Worker())
    }
}