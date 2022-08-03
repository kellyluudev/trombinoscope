package com.example.figma.atoms

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun H3Text(text: String) =
    Text(text = text, style = MaterialTheme.typography.h3)

@Composable
fun Body1Text(text: String) =
    Text(text = text, style = MaterialTheme.typography.body1)