package aviv.workshop.trombinoscope

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.example.figma.atoms.SecondaryButton

@Composable
internal fun WorkerScreen(workers: List<Worker>) {
    WorkerItem(
        modifier = Modifier.padding(32.dp),
        worker = workers.first()
    )
}

@Composable
private fun WorkerItem(modifier: Modifier = Modifier, worker: Worker) {
    Card(
        modifier = modifier,
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
                Body1Text(text = worker.jobTitle)
                Body1Text(text = worker.arrivalDate)
                SecondaryButton(
                    modifier = Modifier.padding(top = 12.dp),
                    onClick = {},
                    text = "Show details"
                )
            }
            Image(
                painter = painterResource(id = worker.pictureRes),
                contentDescription = "worker picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
@Preview(showBackground = false, widthDp = 600)
private fun DefaultPreview() {
    TrombinoscopeTheme {
        WorkerItem(
            modifier = Modifier.padding(32.dp),
            Worker()
        )
    }
}