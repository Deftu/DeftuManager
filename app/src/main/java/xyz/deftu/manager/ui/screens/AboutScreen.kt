package xyz.deftu.manager.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AboutScreen() {
    Box(Modifier.fillMaxWidth().wid) {
        Text(text = "About", style = MaterialTheme.typography.h1, color = MaterialTheme.colors.primary)
    }
}
