package com.utsman.osmapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utsman.osmandcompose.Marker
import com.utsman.osmandcompose.MarkerLabeled
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.model.LabelProperties
import com.utsman.osmandcompose.rememberCameraState
import com.utsman.osmandcompose.rememberMarkerState
import com.utsman.osmapp.retrofit.PointRequest
import org.osmdroid.util.GeoPoint

@Composable
fun MarkerPage() {
    val context = LocalContext.current


    val cameraState = rememberCameraState {
        geoPoint = Coordinates.barnaul
        zoom = 15.0
    }

    val operaMarkerState = rememberMarkerState(
        geoPoint = Coordinates.opera,
        rotation = 90f
    )

    
    val charlieMarkerState = rememberMarkerState(
        geoPoint = Coordinates.charlie,
        rotation = 90f
    )
    val izumrudMarkerState = rememberMarkerState(
        geoPoint = Coordinates.izumrud,
        rotation = 90f
    )

    val depokIcon: Drawable? by remember {
        mutableStateOf(context.getDrawable(R.drawable.gps_dot_red))
    }


    val operaLabelProperties = remember {
        mutableStateOf(
            LabelProperties(
                labelColor = Color.RED,
                labelTextSize = 40f,
                labelAlign = Paint.Align.CENTER,
                labelTextOffset = 30f
            )
        )
    }

    OpenStreetMap(
        modifier = Modifier.fillMaxSize(),
        cameraState = cameraState,

    ) {
        MarkerLabeled(
            state = operaMarkerState,
            icon = depokIcon,
            title = "Опера",
            snippet = "Клубешник",
            label = "Опера",
            labelProperties = operaLabelProperties.value

        ) {
            Column(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.Gray,
                        shape = RoundedCornerShape(7.dp)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = it.title)
                Text(text = it.snippet, fontSize = 17.sp)
            }
        }


        MarkerLabeled (
            state = charlieMarkerState,
            icon = depokIcon,
            title = "Чарли",
            snippet = "Сосисочная вечеринка",
            label = "Чарли",
            labelProperties = operaLabelProperties.value
        ){
            Column(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.Gray,
                        shape = RoundedCornerShape(7.dp)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = it.title)
                Text(text = it.snippet, fontSize = 17.sp)
            }
        }
        MarkerLabeled (
            state = izumrudMarkerState,
            icon = depokIcon,
            title = "Изумрудный",
            snippet = "Шашлычок",
            label = "Изумрудный",
            labelProperties = operaLabelProperties.value
        ){
            Column(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.Gray,
                        shape = RoundedCornerShape(7.dp)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = it.title)
                Text(text = it.snippet, fontSize = 17.sp)
            }
        }

    }
}