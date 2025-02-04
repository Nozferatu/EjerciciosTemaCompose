package com.cmj.ejercicios_compose.ejercicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.cmj.ejercicios_compose.ui.theme.EjerciciosTemaComposeTheme

class Ejercicio4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjerciciosTemaComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ejercicio4(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Ejercicio4(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()){
        val (fila1, fila2, rec1, rec2, rec3, fila4, fila5) = createRefs()

        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .constrainAs(fila1){
                    top.linkTo(parent.top)
                    bottom.linkTo(fila2.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    verticalChainWeight = .1f
                }
        ){}

        Row(
            modifier = Modifier
                .background(Color.Cyan)
                .constrainAs(fila2){
                    top.linkTo(fila1.bottom)
                    bottom.linkTo(rec2.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    verticalChainWeight = .25f
                }
        ){}

        Column(
            modifier = Modifier
                .background(Color.Red)
                .constrainAs(rec1){
                    top.linkTo(fila2.bottom)
                    bottom.linkTo(fila4.top)
                    start.linkTo(parent.start)
                    end.linkTo(rec2.start)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    verticalChainWeight = .35f
                }
        ){}

        Column(
            modifier = Modifier
                .background(Color.Yellow)
                .constrainAs(rec2){
                    top.linkTo(fila2.bottom)
                    bottom.linkTo(fila4.top)
                    start.linkTo(rec1.end)
                    end.linkTo(rec3.start)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    verticalChainWeight = .35f
                }
        ){}

        Column(
            modifier = Modifier
                .background(Color.Red)
                .constrainAs(rec3){
                    top.linkTo(fila2.bottom)
                    bottom.linkTo(fila4.top)
                    start.linkTo(rec2.end)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    verticalChainWeight = .35f
                }
        ){}

        Row(
            modifier = Modifier
                .background(Color.Cyan)
                .constrainAs(fila4){
                    top.linkTo(rec2.bottom)
                    bottom.linkTo(fila5.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    verticalChainWeight = .25f
                }
        ){}

        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .constrainAs(fila5){
                    top.linkTo(fila4.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    verticalChainWeight = .1f
                }
        ){}
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Ejercicio4Preview(){
    Ejercicio4()
}
