package ru.easycode.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
fun Header(image: Int, description: String) {
    Image(
        painter = painterResource(id = image),
        contentDescription = description,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TemperatureText(celsius: Int) {
    val fahrenheit = (celsius.toDouble() * 9 / 5) + 32
    Text(text = "$celsius Celsius is $fahrenheit Fahrenheit")
}

@Composable
fun ConvertButton(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text(text = "Convert")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterTemterature(temperature: String, changed: (String) -> Unit) {
    TextField(
        value = temperature,
        label = { Text(text = "Enter a temperature in Celsius") },
        onValueChange = changed,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MainActivityContent() {
    val celsius = remember { mutableStateOf(0) }
    val newCelcius = remember { mutableStateOf("") }

    Column {
        Header(R.drawable.sunrise, "sunrise image")
        EnterTemterature(temperature = newCelcius.value, changed = { newCelcius.value = it })
        ConvertButton {
            newCelcius.value.toIntOrNull()?.let {
                celsius.value = it
            }
        }
        TemperatureText(celsius.value)
    }
}


@Preview(showBackground =  true)
@Composable
fun PreviewMainActivity() {
    MainActivityContent()
}