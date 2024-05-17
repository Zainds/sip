package com.utsman.osmapp.botton_navigation

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utsman.osmapp.MarkerPage
import com.utsman.osmapp.R

@Composable
fun Screen1() {
    MarkerPage()
}

@Preview
@Composable
fun Screen2() {
    Column{
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.account),
                contentDescription = "",
                modifier = Modifier.size(190.dp)
            )
            Column {
                Text(
                    text = "Name",
                    fontSize = 30.sp
                )
                //Spacer(modifier = Mo)
                Text(
                    text = "Age",
                    fontSize = 30.sp
                )
                Text(
                    text = "Sex",
                    fontSize = 30.sp
                )
            }
        }
        Column {
            Text(text = "О себе:", fontSize = 30.sp)
            Text(text = "-----------------", fontSize = 30.sp)
        }

    }




}