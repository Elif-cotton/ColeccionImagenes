package com.example.coleccionimagenes8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var isImagesVisible by remember { mutableStateOf(false) }
    var buttonText by remember { mutableStateOf("Mostrar imágenes") }

    // Lista de recursos de imágenes
    val imageList = listOf(
        R.drawable.imagen1,
        R.drawable.imagen2,
        R.drawable.imagen3,
        R.drawable.imagen4,
        R.drawable.imagen5
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeText()
        NameText()
        ShowHideImagesButton(
            onButtonClick = {
                isImagesVisible = !isImagesVisible
                buttonText = if (isImagesVisible) "Ocultar imágenes" else "Mostrar imágenes"
            },
            buttonText = buttonText
        )

        // Mostrar la lista de imágenes si isImagesVisible es true
        if (isImagesVisible) {
            ImageCollection(imageList)
        }
    }
}

@Composable
fun WelcomeText() {
    Text(
        text = "¡Bienvenidos!",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun NameText() {
    Text(
        text = "Judith Vergara",
        fontSize = 30.sp,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun ShowHideImagesButton(
    onButtonClick: () -> Unit,
    buttonText: String
) {
    Button(
        onClick = onButtonClick,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(
            text = buttonText,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ImageCollection(imageList: List<Int>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(imageList) { imageRes ->
            DisplayImage(imageRes)
        }
    }
}

@Composable
fun DisplayImage(imageRes: Int) {
    AsyncImage(
        model = imageRes,
        contentDescription = "Imagen de china",
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}