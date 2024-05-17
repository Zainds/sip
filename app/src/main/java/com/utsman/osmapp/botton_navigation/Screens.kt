package com.utsman.osmapp.botton_navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.utsman.osmapp.MarkerPage

@Composable
fun Screen1() {
    MarkerPage()
}

@Composable
fun Screen2() {
    Text(
        text = "Profile",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(),
        textAlign = TextAlign.Center)
}