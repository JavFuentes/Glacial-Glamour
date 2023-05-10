package com.test.mvvmlogin.ui.login.ui

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// Define la clase LoginViewModel que hereda de la clase ViewModel
class LoginViewModel : ViewModel() {

    // Crea una variable privada MutableStateFlow para almacenar el correo electrónico ingresado
    // MutableStateFlow permite la modificación del valor almacenado
    private val _email = MutableStateFlow<String>("")

    // Crea una propiedad pública de solo lectura de tipo StateFlow
    // Los observadores externos solo podrán observar cambios en el valor, pero no modificarlo
    val email: StateFlow<String> = _email

    // Crea una variable privada MutableStateFlow para almacenar la contraseña ingresada
    private val _password = MutableStateFlow<String>("")

    // Crea una propiedad pública de solo lectura de tipo StateFlow para la contraseña
    val password: StateFlow<String> = _password

    // Crea una variable privada MutableStateFlow para almacenar el estado del botón de inicio de sesión
    private val _loginEnable = MutableStateFlow<Boolean>(false)

    // Crea una propiedad pública de solo lectura de tipo StateFlow para el estado del botón de inicio de sesión
    val loginEnable: StateFlow<Boolean> = _loginEnable

    // Función para actualizar el correo electrónico, la contraseña y el estado del botón de inicio de sesión
    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    // Función para validar si el correo electrónico ingresado es válido
    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    // Función para validar si la contraseña ingresada es válida (más de 6 caracteres)
    private fun isValidPassword(password: String): Boolean = password.length > 6

    // Función para manejar la acción de inicio de sesión
    fun onLoginSelected() {
        // Implementar la lógica de inicio de sesión
        TODO("Not yet implemented")
    }
}