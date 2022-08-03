package com.example.figma.atoms

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SecondaryButton(
    text: String,
    modifier: Modifier,
    onClick: (text: String) -> Unit
) = Button(
    modifier = modifier,
    colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary),
    onClick = { onClick(text) }
) { Text(text = text) }