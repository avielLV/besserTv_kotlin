package com.bessersolutions.bessertv.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.bessersolutions.bessertv.presentation.dashboard.DashboardScreen
import com.bessersolutions.bessertv.presentation.list_video.ListVideoScreen
import com.bessersolutions.bessertv.presentation.login.LoginScreen
import com.bessersolutions.bessertv.presentation.video_stream.VideoStreamScreen

@Composable
fun NavGraph(
    startDestination:String
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Route.LoginScreen.route){
            LoginScreen()
        }
        composable(route = Route.DasdboardScreen.route){
            DashboardScreen()
        }
        composable(route = Route.ListVideo.route){
            ListVideoScreen()
        }
        composable(route = Route.VideoStream.route){
            VideoStreamScreen()
        }
    }

}