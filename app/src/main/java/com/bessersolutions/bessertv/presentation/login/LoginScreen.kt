package com.bessersolutions.bessertv.presentation.login

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.Icon
import androidx.tv.material3.Text
import com.bessersolutions.bessertv.presentation.main_activity.MainViewModel

@Composable
fun LoginScreen(
) {

    Log.d("Screen","LoginScreen")

    Scaffold (
        content = {innerPadding->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                
            ){
                Text(text = "LoginSreen")
                Button(onClick = {

                    Log.d("Login","Prueba")
                }) {
                    Text(text = "Logear")
                }
            }

        }
    )

}