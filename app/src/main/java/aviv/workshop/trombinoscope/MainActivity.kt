package aviv.workshop.trombinoscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import aviv.workshop.trombinoscope.ui.theme.TrombinoscopeTheme

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val workers = viewModel.getWorkers()

        setContent {
            TrombinoscopeTheme {
                WorkerScreen(workers)
            }
        }
    }
}

@Composable
fun WorkerScreen(workers: List<Worker>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Trombinoscope") },
                backgroundColor = MaterialTheme.colors.secondary
            )
        },
        content = { WorkerList(workers) }
    )
}

@Composable
fun WorkerList(workers: List<Worker>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(workers) { worker ->
            WorkerItem(worker)
        }
    }
}

@Composable
fun WorkerItem(worker: Worker) {
    val isDetailsDisplayed = rememberSaveable { mutableStateOf(false) }

    Surface(elevation = 4.dp, shape = RoundedCornerShape(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                WorkerName(worker.name)
                WorkerJobTitle(worker.jobTitle)

                AnimatedVisibility(
                    visible = isDetailsDisplayed.value
                ) {
                    WorkerArrivalDate(worker.arrivalDate)
                }

                WorkerShowDetailsButton(isDetailsDisplayed)
            }
            WorkerPicture(worker.pictureRes)
        }
    }
}

@Composable
fun WorkerName(name: String) {
    Text(text = name, style = MaterialTheme.typography.h3)
}

@Composable
fun WorkerArrivalDate(arrivalDate: String) {
    Text(text = arrivalDate, style = MaterialTheme.typography.body1)
}

@Composable
fun WorkerJobTitle(jobTitle: String) {
    Text(text = jobTitle, style = MaterialTheme.typography.body1)
}

@Composable
fun WorkerPicture(@DrawableRes pictureRes: Int) {
    Image(
        painter = painterResource(pictureRes),
        contentDescription = "Worker picture",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(8.dp))
    )

    // To use Coil:
//    AsyncImage(model = pictureUrl, contentDescription = "Worker picture")
}

@Composable
fun WorkerShowDetailsButton(isDetailsDisplayed: MutableState<Boolean>) {
    Button(
        modifier = Modifier.padding(top = 12.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary),
        onClick = {
            isDetailsDisplayed.value = !isDetailsDisplayed.value
        }
    ) {
        val label = if (isDetailsDisplayed.value) {
            "Hide details"
        } else {
            "Show details"
        }
        Text(text = label)
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    val repository = WorkerRepository()
    val workers = repository.getWorkers()
    TrombinoscopeTheme {
        WorkerScreen(workers)
    }
}