package com.bessersolutions.bessertv.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.bessersolutions.bessertv.domain.model.ServerInfo
import com.bessersolutions.bessertv.domain.model.UserInfo
import com.bessersolutions.bessertv.domain.model.UserModel
import com.bessersolutions.bessertv.presentation.navgraph.NavGraph
import com.bessersolutions.bessertv.ui.theme.BesserTvTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BesserTvTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}
val userResponse = UserModel(
    userInfo = UserInfo(
        username = "john_doe",
        password = "secretpassword",
        message = "User authenticated successfully",
        auth = 1,
        status = "active",
        expDate = "2024-12-31",
        isTrial = "false",
        activeCons = "2",
        createdAt = "2022-01-01",
        maxConnections = "5",
        allowedOutputFormats = listOf("mp4", "avi", "mkv")
    ),
    serverInfo = ServerInfo(
        url = "example.com",
        port = "8080",
        httpsPort = "8443",
        serverProtocol = "http",
        rtmpPort = "1935",
        timezone = "UTC",
        timestampNow = 1646980800,
        timeNow = "2022-03-10 08:00:00"
    )
)