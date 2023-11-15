package com.redeyesncode.composewomenandroid.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redeyesncode.composewomenandroid.R
import com.redeyesncode.composewomenandroid.ui.theme.ComposewomenandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposewomenandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    TopAppBarAndroid()

                }
            }
        }
    }
}



@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(){
    val activity = LocalContext.current as Activity

    var modifier = Modifier
    var userNameValue by remember {
        mutableStateOf("")
    }
    modifier.apply {
        padding(10.dp)
        background(Color.Blue)
        
    }
    var colMod = Modifier


    val popinsFamily = FontFamily(
        Font(R.font.popins_medium, FontWeight.Medium),
        Font(R.font.popins_regular, FontWeight.Normal),
        Font(R.font.popins_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.popins_light, FontWeight.Medium)
    )

    Column(modifier = colMod, verticalArrangement = Arrangement.Center) {


        TextField(value = userNameValue, label = { Text(text = "Mobile Number")},modifier = Modifier.fillMaxWidth(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done), onValueChange = {
            userNameValue = it
        },textStyle = TextStyle(fontSize = 15.sp, color = Color.Black, fontFamily = popinsFamily, fontWeight = FontWeight.Medium))
        Spacer(modifier = Modifier.padding(0.dp,12.dp))

        Spacer(modifier = Modifier.padding(0.dp,12.dp))
        ElevatedButton(modifier= Modifier.fillMaxWidth(1f),onClick = {

            val intentOtpVerficationActivity = Intent(activity, OtpVerficationActivity::class.java)
            intentOtpVerficationActivity.putExtra("NUMBER","+91 626261319133")
            activity.startActivity(intentOtpVerficationActivity)

                         Log.i("COMPOSE","$userNameValue,_compose_login_button")

        },    colors = ButtonDefaults.buttonColors(containerColor = Color(83,15,64))) {


            Text(text = "Continue", fontSize = 25.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = Color.White)

        }
    }



}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarAndroid(){
    val popinsFamily = FontFamily(
        Font(R.font.popins_medium, FontWeight.Medium),
        Font(R.font.popins_regular, FontWeight.Normal),
        Font(R.font.popins_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.popins_light, FontWeight.Medium)
    )
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Women Safety App")
                }
            )
        },
    ) {
        Log.i("COMPOSE","$it,_compose_toolbar")
        Log.i("COMPOSE","$it,_compose_toolbar")

        Column(modifier = Modifier.padding(it)) {
            Column (modifier = Modifier.padding(25.dp)){
                Spacer(modifier = Modifier.padding(12.dp,12.dp))
                Text("Sign up / Login", fontFamily = popinsFamily, fontWeight = FontWeight.Medium, fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(12.dp,12.dp))
                Text("Enter your Mobile Number", fontFamily = popinsFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp)

                Column(
                    modifier = Modifier
                        .fillMaxSize(1f),
                ) {
                    LoginForm()
                    HorizontalLayoutWithLinesAndText()
                    GoogleSignInButton()
                    termsAndConditions()

                }
            }

        }

    }



}


@Composable
fun termsAndConditions(){
    val popinsFamily = FontFamily(
        Font(R.font.popins_medium, FontWeight.Medium),
        Font(R.font.popins_regular, FontWeight.Normal),
        Font(R.font.popins_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.popins_light, FontWeight.Medium)
    )
    Column(modifier = Modifier.fillMaxHeight(1f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
        Text( textAlign = TextAlign.Center,text = "By continuing, you agree to our T&C and Privacy Policy", fontSize = 12.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = Color.Gray)

    }




}


@Composable
fun GoogleSignInButton() {
    val popinsFamily = FontFamily(
        Font(R.font.popins_medium, FontWeight.Medium),
        Font(R.font.popins_regular, FontWeight.Normal),
        Font(R.font.popins_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.popins_light, FontWeight.Medium)
    )
    FilledTonalButton(onClick = {}, modifier = Modifier.fillMaxWidth(1f)) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_fingerprint_24),
            modifier = Modifier.size(25.dp),
            contentDescription = "drawable icons",
            tint = Color.Unspecified
        )
        Text(modifier = Modifier.fillMaxWidth(1f), textAlign = TextAlign.Center,text = "Continue with Google", fontSize = 20.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = Color.DarkGray)

    }
}

@Composable
fun HorizontalLayoutWithLinesAndText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // View Line 1
        Box(
            modifier = Modifier
                .weight(1f)
                .height(2.dp)
                .background(Color.Red)
        )

        // TextView
        Text(
            text = "OR",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(horizontal = 8.dp),
        )

        // View Line 2
        Box(
            modifier = Modifier
                .weight(1f)
                .height(2.dp)
                .background(Color.Black)
        )
    }
}
