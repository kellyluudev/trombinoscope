package aviv.workshop.trombinoscope

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
import aviv.workshop.trombinoscope.ui.component.Body1Text
import aviv.workshop.trombinoscope.ui.component.SecondaryButtonComponent
import aviv.workshop.trombinoscope.ui.component.H3Text
import aviv.workshop.trombinoscope.ui.theme.TrombinoscopeTheme

enum class ScreenState(val buttonText: String, val isDetailsVisible: Boolean) {
    SHOW_DETAILS("Show details", true),
    HIDE_DETAILS("Hide details", false)
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
private fun WorkerList(workers: List<Worker>) {
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
private fun WorkerItem(worker: Worker) {
    val screenState = rememberSaveable { mutableStateOf(ScreenState.SHOW_DETAILS) }

    Surface(elevation = 4.dp, shape = RoundedCornerShape(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                H3Text(worker.name)
                Body1Text(worker.jobTitle)
                ArrivalDateText(worker, screenState.value.isDetailsVisible)
                DetailsButton(screenState)
            }
            WorkerPicture(worker.pictureRes)
        }
    }
}

@Composable
private fun ArrivalDateText(
    worker: Worker,
    isVisible: Boolean
) {
    AnimatedVisibility(
        visible = isVisible
    ) {
        Body1Text(worker.arrivalDate)
    }
}

@Composable
private fun DetailsButton(screenState: MutableState<ScreenState>) {
    SecondaryButtonComponent(
        screenState.value.buttonText,
        Modifier.padding(top = 12.dp)
    )
    { oldText ->
        screenState.value = if (oldText == ScreenState.SHOW_DETAILS.buttonText) {
            ScreenState.HIDE_DETAILS
        } else {
            ScreenState.SHOW_DETAILS
        }
    }
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


@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    val repository = WorkerRepository()
    val workers = repository.getWorkers()
    TrombinoscopeTheme {
        WorkerScreen(workers)
    }
}