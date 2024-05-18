package com.utsman.osmapp

import android.os.Bundle
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
import com.utsman.osmapp.ui.theme.OsmAndroidComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            OsmAndroidComposeTheme {
                val navController = rememberNavController()
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