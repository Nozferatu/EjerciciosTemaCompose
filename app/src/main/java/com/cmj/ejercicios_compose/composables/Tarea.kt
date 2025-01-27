package com.cmj.ejercicios_compose.composables

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cmj.ejercicios_compose.mostrarTostada

@Composable
fun Tarea(nombre: String, contexto: Context){
    Box(
        modifier = Modifier
            .width(200.dp)
            .padding(10.dp)
            .background(Color.DarkGray)
            .clickable {
                mostrarTostada(contexto, "Tarea completada")
            }
    ) {
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            text = nombre,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}