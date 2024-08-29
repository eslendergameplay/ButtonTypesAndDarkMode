package com.example.jetpack3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack3.ui.theme.Jetpack3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkMode = remember { mutableStateOf(false) }
            Jetpack3Theme(darkTheme = darkMode.value) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content(darkMode = darkMode)
                }
            }
        }
    }


@Composable
fun Content(darkMode:MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BtnNormal()
        Espacio()
        BtnNormal2()
        Espacio()
        Btntexto()
        Espacio()
        BtnOutline()
        Espacio()
        BtnIcon()
        Espacio()
        BtnSwitch()
        Espacio()
        DarkMode(darkMode = darkMode)
        Espacio()
        Fab()
    }

}
    @Composable
    fun Espacio() {
        Spacer(modifier = Modifier.height(10.dp))
    }

    @Composable
    fun BtnNormal() {
        Button(onClick = {}, enabled = false) {
            Text(text = "BtnNormal", fontSize = 30.sp)
        }
    }

    @Composable
    fun BtnNormal2() {
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
            Text("Mi boton Rojo", fontSize = 30.sp)
        }
    }

    @Composable
    fun Btntexto() {
        TextButton(onClick = {}) {
            Text(text = "Mi Boton Text", fontSize = 30.sp)
        }
    }

    @Composable
    fun BtnOutline() {
        OutlinedButton(onClick = {}, border = BorderStroke(3.dp, Color.Blue)) {
            Text(text = "Mi Boton Outlined", fontSize = 30.sp)
        }
    }

    @Composable
    fun BtnIcon() {
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home",
                tint = Color.Red,
                modifier = Modifier.size(50.dp)
            )
        }
    }

    @Composable
    fun BtnSwitch() {
        var switched by remember { mutableStateOf(false) }
        Switch(
            checked = switched, onCheckedChange = { switched = it }, colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                checkedTrackColor = Color.Green,
                uncheckedThumbColor = Color.Blue,
                uncheckedTrackColor = Color.Magenta
            )
        )
    }

    @Composable
    fun DarkMode(darkMode: MutableState<Boolean>) {
        Button(onClick = { darkMode.value = !darkMode.value }) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "Dark Mode")
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "DarkMode", fontSize = 30.sp)
        }
    }

    @Composable
    fun Fab() {
        FloatingActionButton(
            onClick = {},
            containerColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                modifier = Modifier.size(30.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        val darkMode = remember { mutableStateOf(false) }
        Jetpack3Theme (dynamicColor = false,darkTheme = darkMode.value){
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Content(darkMode = darkMode)
            }
        }
    }

}