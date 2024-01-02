package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFffffff)),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            } 
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color(0xFFffffff))
    ) {

        Upper()
        Spacer(modifier = Modifier.size(width = 200.dp, height = 238.dp))
        Column{
            Lower(
                painter = painterResource(androidx.core.R.drawable.ic_call_answer),
                data = "+91 12453 99999"
            )
            Lower(
                painter = painterResource(android.R.drawable.ic_menu_share),
                data = "@Sanjaydev"
            )
            Lower(
                painter = painterResource(android.R.drawable.ic_dialog_email),
                data = "Sanjaydev@android.com"
            )
        }
    }
}

@Composable
fun Upper() {
    Row{
        Column(
            modifier = Modifier
                .size(width = 400.dp, height = 425.dp)

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color(0xFFffffff))
            ) {
                Image(
                    painter = painterResource(R.drawable.androidlogo),
                    contentDescription = null,
                    contentScale = ContentScale.Inside
                )
                Spacer(modifier = Modifier.size(width = 50.dp, height = 40.dp))
                Text(
                    text = "Sanjay",
                    fontSize = 45.sp
                )
                Text(
                    text = "Android Developer",
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun Lower(painter: Painter,data: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painter = painter,
            contentDescription = data,
            modifier = Modifier
                .size(38.dp)
                .padding(end = 10.dp)
        )
        Text(
            text = data,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}