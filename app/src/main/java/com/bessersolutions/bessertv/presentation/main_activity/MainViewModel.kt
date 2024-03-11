package com.bessersolutions.bessertv.presentation.main_activity

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bessersolutions.bessertv.domain.usecases.DataStore.AppUserUseCase
import com.bessersolutions.bessertv.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appUserUseCase: AppUserUseCase
): ViewModel() {
    private val _startDestination = mutableStateOf(Route.LoginScreen.route)
    val startDestination: State<String> = _startDestination

    init {
        appUserUseCase.getUser().onEach { user ->
            if (user?.userInfo != null) {
                _startDestination.value = Route.DasdboardScreen.route
            } else {
                _startDestination.value = Route.LoginScreen.route
            }
        }.launchIn(viewModelScope)
    }

}