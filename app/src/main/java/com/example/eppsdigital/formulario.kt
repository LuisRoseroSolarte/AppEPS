package com.example.eppsdigital

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eppsdigital.ui.theme.EPPSdigitalTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class formulario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EPPSdigitalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InscriptionForm(
                        name = "Formulario de inscripción",
                        modifier = Modifier.padding(innerPadding),
                        onRegisterButtonClick = { nombres, apellidos, direccion, edad, telefono, correo, genero ->
                            // Navegar a RegistroActivity pasando los datos
                            val intent = Intent(this@formulario, RegistroActivity::class.java).apply {
                                putExtra("nombres", nombres)
                                putExtra("apellidos", apellidos)
                                putExtra("direccion", direccion)
                                putExtra("edad", edad)
                                putExtra("telefono", telefono)
                                putExtra("correo", correo)
                                putExtra("genero", genero)
                            }
                            startActivity(intent)
                        },
                        onBackButtonClick = {  // Acción al hacer clic en el botón para regresar
                            val intent = Intent(this@formulario, MainActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun InscriptionForm(
    name: String,
    modifier: Modifier = Modifier,
    onRegisterButtonClick: (String, String, String, String, String, String, String) -> Unit,
    onBackButtonClick: () -> Unit  // Función para regresar a MainActivity
) {
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("Hombre") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = name, fontSize = 24.sp)

        TextField(
            value = nombres,
            onValueChange = { nombres = it },
            label = { Text("Nombres") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        TextField(
            value = apellidos,
            onValueChange = { apellidos = it },
            label = { Text("Apellidos") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        TextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Dirección") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        TextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        TextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        TextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        Text(text = "Seleccione su género", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            RadioButton(
                selected = genero == "Hombre",
                onClick = { genero = "Hombre" }
            )
            Text(text = "Hombre", modifier = Modifier.padding(end = 16.dp))

            RadioButton(
                selected = genero == "Mujer",
                onClick = { genero = "Mujer" }
            )
            Text(text = "Mujer")
        }

        // Botón para registrar los datos
        Button(
            onClick = { onRegisterButtonClick(nombres, apellidos, direccion, edad, telefono, correo, genero) },
            modifier = Modifier.size(200.dp, 50.dp)
        ) {
            Text(text = "Registrar", fontSize = 23.sp)
        }

        // Botón para regresar a MainActivity
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onBackButtonClick,
            modifier = Modifier.size(200.dp, 50.dp)
        ) {
            Text(text = "HOME", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InscriptionFormPreview() {
    EPPSdigitalTheme {
        InscriptionForm("Formulario de inscripción", onRegisterButtonClick = { _, _, _, _, _, _, _ -> }, onBackButtonClick = {})
    }
}