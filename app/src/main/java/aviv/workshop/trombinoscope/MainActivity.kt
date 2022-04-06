package aviv.workshop.trombinoscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Composable
fun WorkerItem(worker: Worker) {
    Surface {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                WorkerName(worker.name)
                WorkerArrivalDate(worker.arrivalDate)
                WorkerJobTitle(worker.jobTitle)
                WorkerShowDetailsButton()
            }
            WorkerPicture(worker.pictureRes)
        }
    }
}

@Composable
fun WorkerName(name: String) {
    Text(text = name)
}

@Composable
fun WorkerArrivalDate(arrivalDate: String) {
    Text(text = arrivalDate)
}

@Composable
fun WorkerJobTitle(jobTitle: String) {
    Text(text = jobTitle)
}

@Composable
fun WorkerPicture(@DrawableRes pictureRes: Int) {
    Image(
        painter = painterResource(pictureRes),
        contentDescription = "Worker picture",
        contentScale = ContentScale.Crop
    )

    // To use Coil:
//    AsyncImage(model = pictureUrl, contentDescription = "Worker picture")
}

@Composable
fun WorkerShowDetailsButton() {
    OutlinedButton(
        modifier = Modifier.padding(top = 12.dp),
        onClick = {}
    ) {
        Text(text = "Show details")
    }
}


@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    TrombinoscopeTheme {
        WorkerItem(Worker())
    }
}