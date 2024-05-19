package com.utsman.osmapp.botton_navigation


import android.annotation.SuppressLint
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ){
        NavGraph(navHostController = navController)
    }
}