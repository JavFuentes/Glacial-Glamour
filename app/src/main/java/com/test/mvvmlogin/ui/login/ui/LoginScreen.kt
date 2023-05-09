package com.test.mvvmlogin.ui.login.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.mvvmlogin.R
import kotlinx.coroutines.launch

@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFF0EEEF))
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
        //Espacio
        Spacer(modifier = Modifier.padding(16.dp))
        //Campo de texto para el Email
        EmailField()
        // Espacio
        Spacer(modifier = Modifier.padding(4.dp))
        //Campo de texto para el Password
        PasswordField()
        //Espacio
        Spacer(modifier = Modifier.padding(4.dp))
        //Posibilidad de recuperar la password
        ForgotPassword(Modifier.align(Alignment.End))
        //Espacio
        Spacer(modifier = Modifier.padding(8.dp))
        //Boton de Login
        LoginButton()
    }
}

@Composable
fun LoginButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()  // Ajusta el ancho al máximo disponible
            .height(50.dp)
            .padding(start = 20.dp, end = 20.dp), // Aplica padding en los lados
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Black,
            disabledContainerColor = Color(0xFFF0EEEF),
            disabledContentColor = Color(0xFFF0EEEF)
        ),
        shape = RoundedCornerShape(4.dp) // Establece un borde menos redondeado
    ) {
        Text(text = "Iniciar sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    // Obtén el contexto de la aplicación
    val context = LocalContext.current

    // Recuerda el alcance de la corrutina
    val coroutineScope = rememberCoroutineScope()

    Text(
        text = "forgot password?",
        modifier = modifier
            .clickable {
                // Lanza una corrutina para mostrar el Toast
                coroutineScope.launch {
                    //La funcionalidad correcta será implementada en el futuro
                    Toast
                        .makeText(context, "Shit happens", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            .padding(end = 20.dp), // Aplica padding al final
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFB9600)
    )
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

