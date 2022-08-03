package aviv.workshop.trombinoscope

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WorkerScreen(workers: List<Worker>) {
    WorkerItem(workers.first())
}

@Composable
private fun WorkerItem(worker: Worker) {
    Card(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = worker.name)
                Text(worker.arrivalDate)
                Text(worker.jobTitle)
                Button(
                    onClick = {}
                ) {
                    Text(text = "Show details")
                }
            }
            Image(
                painter = painterResource(worker.pictureRes),
                contentDescription = "Worker picture"
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    TrombinoscopeTheme {
        WorkerItem(Worker())
    }
}