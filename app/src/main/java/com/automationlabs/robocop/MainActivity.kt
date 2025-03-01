package com.automationlabs.robocop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.automationlabs.robocop.ui.theme.RobocopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RobocopTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF2196F3), // Blue
                                    Color(0xFF9C27B0)  // Purple
                                )
                            )
                        )
                ) { innerPadding ->
                    Greeting(
                        name = "Droid",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var buttonColor by remember { mutableStateOf(Color(0xFF4CAF50)) } // Initial green
    var buttonText by remember { mutableStateOf("Klick mich") } // Initial text

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hallo $name!",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black
        )
        Button(
            onClick = {
                buttonColor = Color.Blue // Change to red on click
                buttonText = "Ich wurde geklickt!" // Change text on click
            },
            modifier = Modifier.testTag("${buttonText}_button").padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor, // Use the state variable
                contentColor = Color.White
            )
        ) {
            Text(text = buttonText) // Use the state variable
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RobocopTheme {
        Greeting("Droid")
    }
}