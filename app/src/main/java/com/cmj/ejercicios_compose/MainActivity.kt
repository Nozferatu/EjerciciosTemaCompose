package com.cmj.ejercicios_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmj.ejercicios_compose.composables.BotonEjercicio
import com.cmj.ejercicios_compose.ejercicios.*
import com.cmj.ejercicios_compose.ui.theme.EjerciciosTemaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjerciciosTemaComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Inicio(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Inicio(modifier: Modifier = Modifier) {
    val contexto = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Ejercicios Tema Compose",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.weight(.1f))

        BotonEjercicio("Ejercicio 1", contexto, Ejercicio1Activity::class.java)

        BotonEjercicio("Ejercicio 2", contexto, Ejercicio2Activity::class.java)

        BotonEjercicio("Ejercicio 3", contexto, Ejercicio3Activity::class.java)

        BotonEjercicio("Ejercicio 4", contexto, Ejercicio4Activity::class.java)

        Spacer(modifier = Modifier.weight(1f))
    }
}
