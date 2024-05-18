package com.utsman.osmapp

import android.annotation.SuppressLint
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.navigation.compose.rememberNavController
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import com.utsman.osmapp.botton_navigation.Auth
import com.utsman.osmapp.botton_navigation.MainScreen
import com.utsman.osmapp.botton_navigation.Registr
import com.utsman.osmapp.retrofit.RetroUserApi
import com.utsman.osmapp.ui.theme.OsmAndroidComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            OsmAndroidComposeTheme {
                val navController = rememberNavController()
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://79.174.80.34:8081")
                    .addConverterFactory(GsonConverterFactory.create()).build()
                val retroUserApi = retrofit.create(RetroUserApi::class.java)
                CoroutineScope(Dispatchers.IO).launch {
                    val point = retroUserApi.getPointById()
                    runOnUiThread {
                        Log.d("retrofit", point.latitude.toString())
                    }
                }

                // A surface container using the 'background' color from the theme
               MainScreen()
                //Auth()
                //Registr(navController)
            }
        }
    }

}
/**
 * Playground
 * */

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OsmAndroidComposeTheme {
        MarkerPage()
    }
}