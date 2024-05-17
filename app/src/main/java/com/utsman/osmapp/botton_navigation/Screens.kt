package com.utsman.osmapp.botton_navigation

import android.graphics.drawable.Drawable
import android.health.connect.datatypes.units.Length
import android.icu.text.ListFormatter.Width
import android.media.Image
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.common.api.ApiException
import com.utsman.osmapp.MarkerPage
import com.utsman.osmapp.R

@Composable
fun Screen1() {
    MarkerPage()
}


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
@Preview
@Composable
fun Auth() {
    val context = LocalContext.current
    var login by rememberSaveable { mutableStateOf("Text") }
    var password by rememberSaveable { mutableStateOf("Text") }
    Column {
        Text("Логин")
        TextField(value = login, onValueChange ={
            login = it
        })
        Text(text = "Пароль")
        TextField(value = password, onValueChange ={
            password = it
        })
        Button(onClick = {
                         if(login == "zainds" && password == "zov"){
                             Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show()
                         }
        }, modifier = Modifier.width(300.dp)) {

        }
    }
}