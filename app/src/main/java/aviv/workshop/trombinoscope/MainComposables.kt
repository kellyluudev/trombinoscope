package aviv.workshop.trombinoscope

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.figma.atoms.Body1Text
import com.example.figma.atoms.H3Text
import com.example.figma.atoms.PrimaryToolBar
import com.example.figma.atoms.SecondaryButton

@Composable
fun WorkerScreen(workers: List<Worker>) {
    Scaffold(
        topBar = { PrimaryToolBar(title = "Trombinoscope") },
        content = { WorkerList(workers) }
    )
}

@Composable
private fun WorkerList(workers: List<Worker>) {
    LazyColumn {
        items(workers) {
            WorkerItem(worker = it)
        }
    }
}

@Composable
private fun WorkerItem(worker: Worker) =
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                H3Text(text = worker.name)
                Body1Text(text = worker.arrivalDate)
                Body1Text(worker.jobTitle)
                SecondaryButton(
                    modifier = Modifier.padding(top = 12.dp),
                    text = "Show details",
                    onClick = {}
                )
            }
            Image(
                painter = painterResource(worker.pictureRes),
                contentDescription = "Worker picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    TrombinoscopeTheme {
        WorkerScreen(listOf(Worker(), Worker()))
    }
}