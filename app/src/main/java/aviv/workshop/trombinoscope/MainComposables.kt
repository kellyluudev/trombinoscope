package aviv.workshop.trombinoscope

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
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
private fun WorkerList(workers: List<Worker>) = LazyColumn(
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    items(workers) {
        WorkerItem(worker = it)
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun WorkerItem(worker: Worker) {
    val state = remember {
        mutableStateOf(ScreenState.DETAIL_HIDDEN)
    }
    Card(
        modifier = Modifier
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
                ArrivalDate(worker, state.value)
                Body1Text(worker.jobTitle)
                DetailsButton(state)
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
}

@Composable
private fun DetailsButton(state: MutableState<ScreenState>) {
    SecondaryButton(
        modifier = Modifier.padding(top = 12.dp),
        text = state.value.buttonText,
        onClick = { oldText ->
            state.value = if (oldText == ScreenState.DETAIL_VISIBILITY.buttonText){
                ScreenState.DETAIL_HIDDEN
            } else {
                ScreenState.DETAIL_VISIBILITY
            }
        }
    )
}

@Composable
private fun ArrivalDate(worker: Worker, state: ScreenState) {
    AnimatedVisibility(visible = state.isDetailVisibility) {
        Body1Text(text = worker.arrivalDate)
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    TrombinoscopeTheme {
        WorkerScreen(listOf(Worker(), Worker()))
    }
}

enum class ScreenState(val buttonText: String, val isDetailVisibility: Boolean) {
    DETAIL_VISIBILITY("Hide details", true),
    DETAIL_HIDDEN("Show details", false),
}