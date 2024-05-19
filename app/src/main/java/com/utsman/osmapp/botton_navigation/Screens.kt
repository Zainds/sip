package com.utsman.osmapp.botton_navigation


import android.graphics.drawable.Drawable
import android.health.connect.datatypes.units.Length
import android.icu.text.ListFormatter.Width
import android.media.Image
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.NumberPicker
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
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
import androidx.compose.material3.DisplayMode.Companion.Picker
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Picker
import androidx.wear.compose.material.PickerState
import androidx.wear.compose.material.rememberPickerState
import com.google.android.gms.common.api.ApiException
import com.utsman.osmapp.MarkerPage
import com.utsman.osmapp.R
import com.utsman.osmapp.User
import com.utsman.osmapp.buildRetroApi
import com.utsman.osmapp.retrofit.LoginRequest
import com.utsman.osmapp.retrofit.retrofitErrorHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import kotlin.math.log

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
                    text = User.name.toString(),
                    fontSize = 30.sp
                )
                Text(
                    text = User.email.toString(),
                    fontSize = 20.sp
                )
                //Spacer(modifier = Mo)
                Text(
                    text = User.age.toString(),
                    fontSize = 30.sp
                )
                if (User.sex == true){
                    Text(
                        text = "Male",
                        fontSize = 30.sp
                    )
                }else{
                    Text(
                        text = "Female",
                        fontSize = 30.sp
                    )
                }

            }
        }
        Column {
            Text(text = "О себе:", fontSize = 30.sp)
            Text(text = User.bio.toString(), fontSize = 30.sp)
        }

    }

}

@Composable
@Preview
fun Auth(
navController: NavController

) {
    var authSucces = false
    val retroUserApi = buildRetroApi()
    var jwt: String
    val context = LocalContext.current
    var login by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Почта")
        TextField(value = login, onValueChange ={
            login = it
        })
        Text(text = "Пароль")
        TextField(value = password, onValueChange ={
            password = it
        })
        Button(
            onClick = {

                CoroutineScope(Dispatchers.IO).launch {

                    try {
                        val jwt = retroUserApi.loginByNamePas(
                            LoginRequest(login, password)

                        )
                        Log.d("RETR", jwt)
                        User.JWTtoken = jwt
                        User.email = login
                        authSucces = true
                        navController.navigate("screen_1")
                    }catch (e: Exception){
                        e.message?.let { Log.d("RETR", it) }
                    }


                }
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        if(authSucces)navController.navigate("screen_1") // This method will be executed once the timer is over
                    },
                    300 // value in milliseconds
                )
                if(authSucces)navController.navigate("screen_1")

                      },
            modifier = Modifier.width(120.dp)) {
        Text(text = "Войти")

    }
        ClickableText(
            text = AnnotatedString("Создать аккаунт"),
            onClick = {
                navController.navigate("registration")
            })
}
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Registr(navController: NavController){
    val options = listOf("Мужской", "Женский")
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    val possibleValues = listOf("Male", "Female")
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    var sex: Boolean = true
    var login by rememberSaveable { mutableStateOf("") }
    var bio by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(value = login,
            onValueChange = {
                login = it
            },
            label = { Text("Имя") },

            )
        TextField(value = email,
            onValueChange = {
                            email = it
            },
            label = { Text("Почта") },

            )
        TextField(value = age,
            onValueChange = {
                age = it
            },
            label = { Text("Возраст") },

            )
        TextField(value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Пароль")
                    },
            )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                readOnly = true,
                value = selectedOptionText,
                onValueChange = { },
                label = { Text("Пол") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                options.forEach { selectedOption ->
                    androidx.compose.material.DropdownMenuItem(
                        onClick = {
                            selectedOptionText = selectedOption
                            expanded = false
                            if (selectedOptionText == "Male"){
                                sex = true
                            }else sex = false
                        }) {
                        Text(text = selectedOption)
                    }
                }

            }

        }
        TextField(value = bio, onValueChange = {
            bio = it
        },
            label = {
                Text("БИО")
            },
        )
        Button(
            onClick = {
                val retroUserApi = buildRetroApi()
                if (login != "" && age != "" && email != "" && bio != "" && password != ""){
                    User.sex = sex
                    User.name = login
                    User.age = age
                    User.email = email
                    User.bio = bio
                    // switch screen to main
                    navController.navigate("screen_2")
                }else{
                    Toast.makeText(context, "Заполните все поля", Toast.LENGTH_LONG).show()
                }



            },
            modifier = Modifier.width(200.dp),
        ) {
            Text(text = "Зарегистрироваться")
        }
        
    }


}
