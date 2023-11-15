package com.redeyesncode.composewomenandroid.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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

class CreatePasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposewomenandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    TopAppBarAndroid()
                }
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBarAndroid(){
        val activity = LocalContext.current as Activity

        var firstPassword by remember {
            mutableStateOf("")
        }


        var confirmPassword by remember {
            mutableStateOf("")
        }
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
                        Text("Password")
                    },
                    navigationIcon = {
                        IconButton(onClick = { finish() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    }

                )
            },
        ) {
            Log.i("COMPOSE","$it,_compose_toolbar")
            Log.i("COMPOSE","$it,_compose_toolbar")

            Column(modifier = Modifier.padding(it)) {
                Column (modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth(1f)){
                    Text("Create Password", fontFamily = popinsFamily, textAlign = TextAlign.Center,fontWeight = FontWeight.Medium, fontSize = 20.sp, color = Color.Black)

                    Column(
                        modifier = Modifier
                            .fillMaxSize(1f),
                    ) {
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))

                        Text("Your password must be different to previously used password", fontFamily = popinsFamily, textAlign = TextAlign.Start,fontWeight = FontWeight.Medium, fontSize = 15.sp, color = Color.Black)
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))

                        TextField(value = firstPassword, label = { Text(text = "Enter new password ")},modifier = Modifier.fillMaxWidth(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done), onValueChange = {
                            firstPassword = it
                        },textStyle = TextStyle(fontSize = 15.sp, color = Color.Black, fontFamily = popinsFamily, fontWeight = FontWeight.Medium))
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))

                        TextField(value = confirmPassword, label = { Text(text = "Re-enter New Password")},modifier = Modifier.fillMaxWidth(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done), onValueChange = {
                            confirmPassword = it
                        },textStyle = TextStyle(fontSize = 15.sp, color = Color.Black, fontFamily = popinsFamily, fontWeight = FontWeight.Medium))
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))

                        Text("Note : We Highly recommend you to create a unique password, one which you don't use of other sites.", fontFamily = popinsFamily, textAlign = TextAlign.Start,fontWeight = FontWeight.Medium, fontSize = 15.sp, color = Color.Black)

                        ElevatedButton(modifier= Modifier.fillMaxWidth(1f),onClick = {

                            val intentDashboardActivity = Intent(activity, DashboardActivity::class.java)
                            startActivity(intentDashboardActivity)


                        },    colors = ButtonDefaults.buttonColors(containerColor = Color(83,15,64))) {


                            Text(text = "Continue", fontSize = 25.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = Color.White)

                        }
                    }
                }

            }

        }



    }
}

