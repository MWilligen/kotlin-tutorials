package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    composeQuadrants(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun composeQuadrants(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .weight(1F)) {
            composeText(title = stringResource(R.string.title_topl),
                body = stringResource(R.string.body_topl),
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f))
            composeText(title = stringResource(R.string.title_topr),
                body = stringResource(R.string.body_topr),
                bgColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier
            .weight(1F)) {
            composeText(title = stringResource(R.string.title_bottoml),
                body = stringResource(R.string.body_bottoml),
                bgColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f))
            composeText(title = stringResource(R.string.title_bottomr),
                body = stringResource(R.string.body_bottomr),
                bgColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun composeText(title: String,
                        body: String,
                        bgColor: Color,
                        modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(bgColor)
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp),
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun composeQuadrant() {
    ComposeQuadrantTheme {
        composeQuadrants()
    }
}