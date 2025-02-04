package com.cmj.ejercicios_compose.ejercicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.cmj.ejercicios_compose.R
import com.cmj.ejercicios_compose.ui.theme.EjerciciosTemaComposeTheme

class Ejercicio5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjerciciosTemaComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ejercicio5(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Ejercicio5(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()){
        val (
            fila1, imagen1,
            caja1,
            caja2, caja3,
            caja4,
            boton1, boton2, boton3
        ) = createRefs()

        Row(modifier = Modifier
            .background(Color.Gray)
            .constrainAs(fila1){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(imagen1.start)
                bottom.linkTo(caja1.top)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                horizontalChainWeight = 1f
                verticalChainWeight = .3f
            }
        ){}

        Image(modifier = Modifier
            .constrainAs(imagen1){
                top.linkTo(parent.top)
                start.linkTo(fila1.end)
                end.linkTo(parent.end)
                bottom.linkTo(caja1.top)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                horizontalChainWeight = .2f
                verticalChainWeight = .3f
            },
            painter = painterResource(R.drawable.cool_meme_bro),
            contentDescription = "Imagen 1"
        )

        Column(modifier = Modifier
            .background(Color.Yellow)
            .constrainAs(caja1){
                top.linkTo(fila1.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(caja2.top)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                verticalChainWeight = 1f
            },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .background(Color.White)
                    .border(3.dp, Color.Black)
                    .width(300.dp)
                    .height(90.dp),
            ){}

            Box(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .background(Color.White)
                    .border(3.dp, Color.Black)
                    .width(300.dp)
                    .height(90.dp),
            ){}
        }

        Box(modifier = Modifier
            .background(Color.White)
            .constrainAs(caja2){
                top.linkTo(caja1.bottom)
                start.linkTo(parent.start)
                end.linkTo(caja3.start)
                bottom.linkTo(caja4.top)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                verticalChainWeight = 1f
            }
        ){
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
                textAlign = TextAlign.Center,
                text = "Mucho texto Mucho texto Mucho texto Mucho texto Mucho texto Mucho texto Mucho texto Mucho texto Mucho texto")
        }

        Box(modifier = Modifier
            .background(Color.LightGray)
            .constrainAs(caja3){
                top.linkTo(caja1.bottom)
                start.linkTo(caja2.end)
                end.linkTo(parent.end)
                bottom.linkTo(caja4.top)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                verticalChainWeight = 1f
            }
        ){
            Image(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                painter = painterResource(R.drawable.cool_meme_bro),
                contentDescription = "Imagen 1"
            )
        }

        Row(modifier = Modifier
            .background(Color.Red)
            .constrainAs(caja4){
                top.linkTo(caja2.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(boton2.top)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                verticalChainWeight = .6f
            }
        ){

        }

        OutlinedButton(modifier = Modifier
            .constrainAs(boton1){
                top.linkTo(caja4.bottom)
                start.linkTo(parent.start)
                end.linkTo(boton2.start)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                verticalChainWeight = .2f
            },
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            shape = RectangleShape
        ) { Text("Botón") }

        OutlinedButton(modifier = Modifier
            .constrainAs(boton2){
                top.linkTo(caja4.bottom)
                start.linkTo(boton1.end)
                end.linkTo(boton3.start)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                verticalChainWeight = .2f
            },
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            shape = RectangleShape
        ) { Text("Botón") }

        OutlinedButton(modifier = Modifier
            .constrainAs(boton3){
                top.linkTo(caja4.bottom)
                start.linkTo(boton2.end)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                verticalChainWeight = .2f
            },
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            shape = RectangleShape
        ) { Text("Botón") }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Ejercicio5Preview() {
    EjerciciosTemaComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Ejercicio5(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}