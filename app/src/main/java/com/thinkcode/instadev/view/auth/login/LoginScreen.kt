package com.thinkcode.instadev.view.auth.login

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thinkcode.instadev.R
import org.w3c.dom.Text


@Composable
fun LoginScreen(loginViewModel: LoginViewModel= viewModel()) {//Lo inicializan para poder hacer testing
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) { padding ->
        Column(
            Modifier
            .background (Color.White)
            .padding(padding)
            .padding(horizontal = 24.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // <-- hace la columna desplazable
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text("Español (España)", color = Color.Gray, modifier = Modifier.padding(22.dp))
        Spacer(Modifier.weight(1f))
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.xq_logo),
            contentDescription = "InstaDev logo header"
        )
        Spacer(Modifier.weight(1f))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30),
            label = { Text("Usuario, correo electrónico o móvil") },
            value = uiState.email,
            onValueChange = { loginViewModel.onEmailChange(it)})
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30),
            label = { Text("Contraseña") },
            value = uiState.password,
            onValueChange = {loginViewModel.onPasswordChange(it) })
        Spacer(Modifier.height(12.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White),
            enabled = uiState.isLoginEnabled,
            onClick = {}) {
            Text(
                "Iniciar Sesión",
                modifier = Modifier.padding(4.dp)
            )
        }
        TextButton(onClick = {}) { Text("Haz olvidado la contraseña?") }
        Spacer(Modifier.weight(1f))
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}) { Text("Crear cuenta nueva.") }
        Icon(
            modifier = Modifier
                .height(50.dp)
                .padding(vertical = 5.dp),
            painter = painterResource(R.drawable.meta_logo),
            contentDescription = "meta logo",
            tint = Color.Gray
        )
    }
    }
}