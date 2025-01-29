package com.cmj.ejercicios_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.cmj.ejercicios_compose.ui.theme.EjerciciosTemaComposeTheme

class EjercicioFormularioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjerciciosTemaComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjercicioFormulario(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EjercicioFormulario(modifier: Modifier = Modifier) {
    val contexto = LocalContext.current

    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (titulo, nombreInput, correoInput, contrasenaInput, botonInput) = createRefs()

        var nombre by rememberSaveable { mutableStateOf("") }
        var correo by rememberSaveable { mutableStateOf("") }
        var contrasena by rememberSaveable { mutableStateOf("") }

        Text(
            modifier = Modifier
                .padding(vertical = 30.dp)
                .constrainAs(titulo){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = "Formulario de registro",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )

        OutlinedTextField(
            modifier = Modifier
                .constrainAs(nombreInput){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(titulo.bottom)
                    bottom.linkTo(correoInput.top)
                },
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            singleLine = true
        )

        OutlinedTextField(
            modifier = Modifier
                .constrainAs(correoInput){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(nombreInput.bottom)
                    bottom.linkTo(contrasenaInput.top)
                },
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") },
            singleLine = true
        )

        OutlinedTextField(
            modifier = Modifier
                .constrainAs(contrasenaInput){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(correoInput.bottom)
                },
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedButton(
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(botonInput){
                    end.linkTo(contrasenaInput.end)
                    top.linkTo(contrasenaInput.bottom)
                    bottom.linkTo(parent.bottom)
                    verticalBias = 0f
                },
            onClick = { mostrarTostada(contexto, "Datos enviados") }
        ) {
            Text(
                text = "Enviar",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EjercicioFormularioPreview() {
    EjerciciosTemaComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            EjercicioFormulario(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}