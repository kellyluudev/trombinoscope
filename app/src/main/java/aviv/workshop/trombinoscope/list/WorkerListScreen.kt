package aviv.workshop.trombinoscope.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.figma.atoms.Body1Text
import com.example.figma.atoms.H3Text
import com.example.figma.atoms.SecondaryButton

@Composable
internal fun WorkerListScreen(viewModel: WorkerListViewModel, navigateToDetails: (worker: Worker) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Workshop") },
            backgroundColor = MaterialTheme.colors.primary
        )}
    ) {
        WorkerList(viewModel.getWorkers(), navigateToDetails)
    }
}

@Composable
private fun WorkerList(workers: List<Worker>, onItemClick: (worker: Worker) -> Unit) =
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(workers) {
            WorkerItem(
                modifier = Modifier.padding(horizontal = 16.dp),
                worker = it,
                onItemClick = onItemClick
            )
        }
    }

@Composable
private fun WorkerItem(
    modifier: Modifier = Modifier,
    worker: Worker,
    onItemClick: (worker: Worker) -> Unit
) {
    var state by rememberSaveable { mutableStateOf(ScreenState.DETAILS_HIDDEN) }
    val onButtonClick = {
        state = if (state == ScreenState.DETAILS_VISIBLE) {
            ScreenState.DETAILS_HIDDEN
        } else {
            ScreenState.DETAILS_VISIBLE
        }
    }

    Card(
        modifier = modifier.fillMaxWidth()
            .clickable { onItemClick(worker) },
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
                ArrivalDate(worker, state.isDetailVisible)
                DetailsButton(state.buttonText, onButtonClick)
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
private fun DetailsButton(buttonText: String, onClick: () -> Unit) {
    SecondaryButton(
        modifier = Modifier.padding(top = 12.dp),
        onClick = { onClick() },
        text = buttonText
    )
}
@Composable
private fun ArrivalDate(worker: Worker, isVisible: Boolean) {
    AnimatedVisibility(visible = isVisible) {
        Body1Text(text = worker.arrivalDate)
    }
}

enum class ScreenState(val buttonText : String, val isDetailVisible : Boolean){
    DETAILS_VISIBLE("Hide details", true),
    DETAILS_HIDDEN("Show details", false),
}