package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardMain()
                }
            }
        }
    }
}

@Composable
private fun TopInfo(name: String, jobTitle: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier
                .height(100.dp)
                .width(100.dp)
        )
        Text(
            text = name,
            fontSize = 30.sp,
        )
        Text(
            text = jobTitle,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun ContactInfo(
    phoneNum: String,
    smHandle: String,
    email: String,
    modifier: Modifier = Modifier) {
    Column {
        Row {
            Icon(Icons.Filled.Call, contentDescription = null, tint = Color(0xFF3ddc84))
            Text(
                text = phoneNum,
                modifier = modifier.padding(start = 16.dp),
            )
        }
        Row {
            Icon(Icons.Filled.Share, contentDescription = null, tint = Color(0xFF3ddc84))
            Text(
                text = smHandle,
                modifier = modifier.padding(start = 16.dp),
            )
        }
        Row {
            Icon(Icons.Filled.Email, contentDescription = null, tint = Color(0xFF3ddc84))
            Text(
                text = email,
                modifier = modifier.padding(start = 16.dp),
            )
        }
    }
}

@Composable
fun CardMain () {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(Color.LightGray)
    ) {
        TopInfo(stringResource(R.string.full_name), stringResource(R.string.job_title))
        ContactInfo(phoneNum = stringResource(R.string.phoneNum), smHandle = stringResource(R.string.smHandle), email = stringResource(R.string.email_address))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        CardMain()
    }
}