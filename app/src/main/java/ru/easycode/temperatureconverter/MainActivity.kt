package ru.easycode.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.easycode.temperatureconverter.ui.theme.TemperatureConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Hello("friend")
                Hello("everyone")
            }
        }
    }
}

@Composable
fun Hello(name: String) {
    Text( "Hello $name! Welcome to Jetpack Compose.")
}
@Preview(showBackground =  true)
@Composable
fun PreviewMainActivity() {
    Column {
        Hello(name = "friend")
        Hello(name = "everyone")
    }
}