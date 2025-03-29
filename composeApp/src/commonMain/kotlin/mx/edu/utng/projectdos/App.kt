package mx.edu.utng.projectdos

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import compose.composeapp.generated.resources.Res
import compose.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(screen = MainScreen()){
            navigator ->
            SlideTransition(navigator)
        }
    }
}

class MainScreen:Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                navigator?.push(secondScreen())
            }) {
                Text("Navegación Básica")
            }
        }
    }
}

class secondScreen:Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize().background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Segunda Pantalla", fontSize = 26.sp, color = Color.Black)
            Spacer(Modifier.height(16.dp))
            Button(onClick = { navigator?.pop() }){ Text("Volver") }
        }
    }

}