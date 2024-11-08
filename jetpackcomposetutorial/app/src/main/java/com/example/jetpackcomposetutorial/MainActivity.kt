package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    TutorialImage(
                        title = stringResource(R.string.title),
                        summary = stringResource(R.string.summary_text),
                        body = stringResource(R.string.body_text),
                        headerImage = painterResource(R.drawable.composebackground),
                    )
                }
            }
        }
    }
}

@Composable
fun TutorialScreen(title: String, summary: String, body: String, modifier: Modifier = Modifier) {
    Column(modifier
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = summary,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp,
                         end = 16.dp)

        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)

        )
    }
}

@Composable
fun TutorialImage(title: String, summary: String, body: String, headerImage: Painter, modifier: Modifier = Modifier) {
    Column(modifier){
        Image(
            painter = headerImage,
            contentDescription = null,
        )
        TutorialScreen(
            title = stringResource(R.string.title),
            summary = stringResource(R.string.summary_text),
            body = stringResource(R.string.body_text),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JetpackTutorial() {
    JetpackComposeTutorialTheme {
        TutorialImage(
            title = stringResource(R.string.title),
            summary = stringResource(R.string.summary_text),
            body = stringResource(R.string.body_text),
            headerImage = painterResource(R.drawable.composebackground),
        )
    }
}