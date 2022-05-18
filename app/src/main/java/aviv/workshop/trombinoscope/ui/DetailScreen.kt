package aviv.workshop.trombinoscope.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailRoute(name: String?, jobTitle: String?) {
    DetailScreen(name, jobTitle)
}

@Composable
fun DetailScreen(name: String?, jobTitle: String?) {
    Column {
        Text("Name: $name")
        Text("Job title: $jobTitle")
    }
}