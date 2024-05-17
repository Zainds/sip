package com.utsman.osmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.utsman.osmapp.botton_navigation.MainScreen
import com.utsman.osmapp.ui.theme.OsmAndroidComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            OsmAndroidComposeTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
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