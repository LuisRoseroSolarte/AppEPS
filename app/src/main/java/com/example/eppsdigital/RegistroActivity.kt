package com.example.eppsdigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eppsdigital.ui.theme.EPPSdigitalTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class RegistroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Recibe los datos pasados desde formulario a través del Intent
        val nombres = intent.getStringExtra("nombres") ?: "Nombres no disponibles"
        val apellidos = intent.getStringExtra("apellidos") ?: "Apellidos no disponibles"
        val direccion = intent.getStringExtra("direccion") ?: "Dirección no disponible"
        val edad = intent.getStringExtra("edad") ?: "Edad no disponible"
        val telefono = intent.getStringExtra("telefono") ?: "Teléfono no disponible"
        val correo = intent.getStringExtra("correo") ?: "Correo no disponible"

        setContent {
            EPPSdigitalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistroScreen(
                        nombres = nombres,
                        apellidos = apellidos,
                        direccion = direccion,
                        edad = edad,
                        telefono = telefono,
                        correo = correo,
                        modifier = Modifier.padding(innerPadding),
                        onBackButtonClick = { finish() }  // Cierra la actividad al presionar el botón
                    )
                }
            }
        }
    }
}

@Composable
fun RegistroScreen(
    nombres: String,
    apellidos: String,
    direccion: String,
    edad: String,
    telefono: String,
    correo: String,
    modifier: Modifier = Modifier,
    onBackButtonClick: () -> Unit  // Callback para manejar el clic del botón
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de Bienvenido
        Text(
            text = "Bienvenido",
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Text(text = "Nombres: $nombres", fontSize = 22.sp)
        Text(text = "Apellidos: $apellidos", fontSize = 22.sp)
        Text(text = "Dirección: $direccion", fontSize = 22.sp)
        Text(text = "Edad: $edad", fontSize = 22.sp)
        Text(text = "Teléfono: $telefono", fontSize = 22.sp)
        Text(text = "Correo: $correo", fontSize = 22.sp)

        Spacer(modifier = Modifier.padding(16.dp))  // Espacio entre los textos y el botón

        // Botón para regresar a la ventana anterior (formulario)
        Button(onClick = onBackButtonClick,
            modifier = Modifier.size(200.dp, 50.dp))  // Tamaño del botón (ancho, alto)
         {
            Text(text = "Regresar", fontSize = 23.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroScreenPreview() {
    EPPSdigitalTheme {
        RegistroScreen(
            nombres = "Luis",
            apellidos = "Rosero",
            direccion = "Calle Falsa 123",
            edad = "30",
            telefono = "123456789",
            correo = "luis@example.com",
            onBackButtonClick = {}
        )
    }
}