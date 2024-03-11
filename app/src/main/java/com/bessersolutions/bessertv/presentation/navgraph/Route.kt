package com.bessersolutions.bessertv.presentation.navgraph

import androidx.navigation.NamedNavArgument

sealed class Route (
    val route :String,
    val arguments: List<NamedNavArgument> = emptyList()
){
    object LoginScreen : Route("loginScreen")
    object DasdboardScreen:Route("dashboardScreen")
    object ListVideo:Route("listVideo")
    object VideoStream:Route("videoStream")
}