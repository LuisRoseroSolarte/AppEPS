package com.example.eppsdigital

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eppsdigital.ui.theme.EPPSdigitalTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EPPSdigitalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "EPSdigital",
                        modifier = Modifier.padding(innerPadding),
                        onButtonClick = {
                            // Lanzar la nueva actividad
                            val intent = Intent(this, formulario::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onButtonClick: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
    ) {


        Text(
            text = "Bienvenido a la  EPSdigital!",
            fontSize = 24.sp, // Ajusta el tamaño del texto
            modifier = modifier
        )
        // Mostrar la imagen
        // Centrar la imagen usando Box
       // Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.eps), // Cambia el nombre de la imagen
                contentDescription = "Descripción de la imagen", // Descripción para accesibilidad
                modifier = Modifier.size(248.dp) // Ajusta el tamaño de la imagen según lo necesites
            )
//}

        Spacer(modifier = Modifier.height(16.dp))

        // Aquí agregamos el botón
       // Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(
                onClick = onButtonClick,
                modifier = Modifier.size(200.dp, 50.dp) // Cambia el tamaño del botón
            ) {
                Text(text = "Ingresar",fontSize = 23.sp)
          //  }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EPPSdigitalTheme {
        Greeting(name = "Android", onButtonClick = {})
    }
}