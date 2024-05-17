package com.utsman.osmapp.botton_navigation

import com.utsman.osmandcompose.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object Screen1: BottomItem("Карта", com.utsman.osmapp.R.drawable.gps_dot, "screen_1")
    object Screen2: BottomItem("Карта", com.utsman.osmapp.R.drawable.account, "screen_2")
}