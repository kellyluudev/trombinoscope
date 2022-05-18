package aviv.workshop.trombinoscope.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import aviv.workshop.trombinoscope.Worker
import aviv.workshop.trombinoscope.WorkerListViewModel


@Composable
fun WorkerRoute(
    viewModel: WorkerListViewModel,
    navigateToDetails: () -> Unit
) {
    WorkerScreen(viewModel, navigateToDetails)
}

@Composable
fun WorkerScreen(
    viewModel: WorkerListViewModel,
    navigateToDetails: () -> Unit
) {

    val workers = viewModel.getWorkers()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Trombinoscope") },
                backgroundColor = MaterialTheme.colors.secondary
            )
        },
        content = { WorkerList(navigateToDetails, workers) }
    )
}

@Composable
fun WorkerList(
    navigateToDetails: () -> Unit,
    workers: List<Worker>
) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(workers) { worker ->
            WorkerItem(navigateToDetails, worker)
        }
    }
}

@Composable
fun WorkerItem(
    navigateToDetails: () -> Unit,
    worker: Worker
) {
    val isDetailsDisplayed = rememberSaveable { mutableStateOf(false) }

    Surface(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.clickable {
            navigateToDetails()
        }
    ) {
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