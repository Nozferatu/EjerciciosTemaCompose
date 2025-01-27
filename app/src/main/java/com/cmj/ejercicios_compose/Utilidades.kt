package com.cmj.ejercicios_compose

import android.content.Context
import android.content.Intent
import android.widget.Toast

fun iniciarActividad(contexto: Context, actividad: Class<*>) {
    contexto.startActivity(
        Intent(contexto, actividad)
    )
}

fun mostrarTostada(contexto: Context, mensaje: String, tiempo: Int = Toast.LENGTH_SHORT){
    Toast.makeText(
        contexto,
        mensaje,
        tiempo
    ).show()
}