package com.cmj.ejercicios_compose.composables

import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.cmj.ejercicios_compose.iniciarActividad

@Composable
fun BotonEjercicio(texto: String, contexto: Context, actividad: Class<*>) {
    Button(
        onClick = { iniciarActividad(contexto, actividad) }
    ) {
        Text(
            text = texto,
            fontSize = 18.sp
        )
    }
}