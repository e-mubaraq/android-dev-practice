package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantMain()
                }
            }
        }
    }
}

@Composable
private fun QuadrantBody(
    topic: String,
    body: String,
    bgColor: Color,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = topic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun QuadrantMain(modifier: Modifier = Modifier) {
    Column (Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)) {
            QuadrantBody(
                stringResource(R.string.text_composable),
                stringResource(R.string.text_body),
                Color(0xFFEADDFF),
                Modifier.weight(1f)
                )
            QuadrantBody(
                stringResource(R.string.image_composable),
                stringResource(R.string.image_body),
                Color(0xFFD0BCFF),
                Modifier.weight(1f)
            )
        }
        Row (modifier.weight(1f)) {
            QuadrantBody(
                stringResource(R.string.row_composable),
                stringResource(R.string.row_body),
                Color(0xFFB69DF8),
                Modifier.weight(1f)
            )
            QuadrantBody(
                stringResource(R.string.col_composable),
                stringResource(R.string.col_body),
                Color(0xFFF6EDFF),
                Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        QuadrantMain()
    }
}