package com.thinkcode.instadev.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.intellij.lang.annotations.Pattern

class LoginViewModel: ViewModel() {

    private val _uiState= MutableStateFlow(LoginUiState())

    val uiState:StateFlow<LoginUiState> = _uiState


    fun onEmailChange(email: String){
        _uiState.update {
            it.copy(email=email)

        }
        verifyLogin()

    }
    fun onPasswordChange(password: String){
        _uiState.update {
            it.copy(password=password)

        }
        verifyLogin()
        //cesarcommittest
    }

    private fun verifyLogin() {
        val enabledLogin: Boolean=isEmailValid(_uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update {
            it.copy(isLoginEnabled = enabledLogin)
        }
    }

    private fun isEmailValid(email: String): Boolean= Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isPasswordValid(password: String): Boolean=password.length>=6

}



data class LoginUiState(

    val email:String="",
    val password:String="",
    val isLoading: Boolean=false,
    val isLoginEnabled: Boolean=false

)