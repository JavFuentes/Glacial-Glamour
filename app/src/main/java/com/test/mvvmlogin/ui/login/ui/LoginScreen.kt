package com.test.mvvmlogin.ui.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.test.mvvmlogin.R

@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Centra el contenido de la función Login dentro de la pantalla
        Login(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Login(modifier: Modifier) {
    Column(modifier = modifier) {
        // Utiliza un Box para llenar el ancho disponible y centrar horizontalmente la imagen
        Box(modifier = Modifier.fillMaxWidth()) {
            // Centra la imagen dentro del Box
            HeaderImage(Modifier.align(Alignment.Center))
        }
        // Espacio entre la imagen y el campo de texto
        Spacer(modifier = Modifier.padding(16.dp))
        //Campo de texto para el Email
        EmailField()
        // Espacio entre los campos de texto "Email" y "Password"
        Spacer(modifier = Modifier.padding(8.dp))
        //Campo de texto para el Password
        PasswordField()
    }
}

// Función Composable para el campo de correo electrónico
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(){
    TextField(
        value = "", // Valor inicial del campo de texto
        onValueChange = {}, // Callback para manejar el cambio de valor
        modifier = Modifier
            .fillMaxWidth() // Ajusta el ancho al máximo disponible
            .padding(start = 20.dp, end = 20.dp), // Aplica padding en los lados
        placeholder = { Text(text = "Email") }, // Texto de marcador de posición
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), // Configura el teclado para la entrada de correo electrónico
        singleLine = true, // Permite una sola línea de texto
        maxLines = 1, // Establece el número máximo de líneas en 1
        colors = TextFieldDefaults.textFieldColors( // Personaliza los colores
            textColor = Color(0xFF000000),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

// Función Composable para el campo de contraseña
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(){
    TextField(
        value = "", // Valor inicial del campo de texto
        onValueChange = { }, // Callback para manejar el cambio de valor
        placeholder = { Text(text = "Password")}, // Texto de marcador de posición
        modifier = Modifier
            .fillMaxWidth() // Ajusta el ancho al máximo disponible
            .padding(start = 20.dp, end = 20.dp), // Aplica padding en los lados
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // Configura el teclado para la entrada de contraseña
        singleLine = true, // Permite una sola línea de texto
        maxLines = 1, // Establece el número máximo de líneas en 1
        colors = TextFieldDefaults.textFieldColors( // Personaliza los colores
            textColor = Color(0xFF000000),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

// Función Composable para la imagen del encabezado
@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.glacialglamour_logo), // Carga la imagen desde los recursos
        contentDescription = "app logo", // Descripción del contenido para accesibilidad
        modifier = modifier // Modificador para personalizar la apariencia y el diseño
    )
}

