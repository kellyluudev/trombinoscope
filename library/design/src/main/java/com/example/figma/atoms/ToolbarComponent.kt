package com.example.figma.atoms

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun PrimaryToolBar(title: String) = TopAppBar(
    title = { Text(title) },
    backgroundColor = MaterialTheme.colors.primary
)
