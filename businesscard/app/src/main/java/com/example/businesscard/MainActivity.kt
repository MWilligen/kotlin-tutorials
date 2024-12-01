package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier) { innerPadding ->
                    Surface(
                        Modifier
                            .padding(innerPadding)
                            .fillMaxSize()) {
                        mainDetails(
                            headshot = painterResource(R.drawable.marcel_head),
                            name = stringResource(R.string.name),
                            position = stringResource(R.string.position),
                            email = stringResource(R.string.email),
                            location = stringResource(R.string.location),
                            phone = stringResource(R.string.phone_number),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun mainDetails(
    name: String,
    position: String,
    email: String,
    location: String,
    phone: String,
    headshot: Painter,
    modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = headshot,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.5f)
        )
        Text(
            text = name,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Text(
            text = position,
            modifier = modifier
        )
    }
    Spacer(modifier = Modifier.padding(bottom = 200.dp))
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(modifier = Modifier
            .padding(5.dp)) {
            contactDetails(
                text = email,
                icon = Icons.Filled.Email
            )
        }
        Row(modifier = Modifier
            .padding(5.dp)) {
            contactDetails(
                text = phone,
                icon = Icons.Filled.Phone
            )
        }
        Row(modifier = Modifier
            .padding(5.dp)
        ) {
            contactDetails(
                text = location,
                icon = Icons.Filled.LocationOn
            )
        }
    }
}

@Composable
private fun contactDetails(text: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Icon(
        imageVector = icon,
        contentDescription = null,
    )
    Text(
        text = text,
        modifier = modifier
            .padding(start = 5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        mainDetails(
            headshot = painterResource(R.drawable.android_logo),
            name = stringResource(R.string.name),
            position = stringResource(R.string.position),
            email = stringResource(R.string.email),
            location = stringResource(R.string.location),
            phone = stringResource(R.string.phone_number),
        )
    }
}