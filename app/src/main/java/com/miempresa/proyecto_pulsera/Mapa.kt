package com.miempresa.proyecto_pulsera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


class Mapa : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen10()
        }
    }
}

@Composable
fun Screen10() {
    val location = LatLng(-16.429135, -71.519663)
    val camLocation = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location, 17f)
    }
    var mapUiSettings by remember { mutableStateOf(MapUiSettings()) }
    var mapProperties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }
    GoogleMap (
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = camLocation
    ) {
        Marker(
            state = MarkerState(position = location),
            title = "Pulsera2",
            snippet = "Ubicacion de la pulsera"
        )

    }
}