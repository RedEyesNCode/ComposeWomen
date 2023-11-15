package com.redeyesncode.composewomenandroid.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redeyesncode.composewomenandroid.R
import com.redeyesncode.composewomenandroid.ui.theme.ComposewomenandroidTheme
import com.yogeshpaliyal.speld.PinInput

class OtpVerficationActivity : ComponentActivity() {
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
                        Text("OTP")
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
                Column (modifier = Modifier.padding(25.dp)){
                    Text("Verification", fontFamily = popinsFamily, fontWeight = FontWeight.Medium, fontSize = 20.sp)
                    Spacer(modifier = Modifier.padding(12.dp,12.dp))
                    Text("A 4 digit OTP is sent to your registered mobile number ", fontFamily = popinsFamily, fontWeight = FontWeight.Light, fontSize = 14.sp)

                    Text("${intent.getStringExtra("NUMBER")} ", fontFamily = popinsFamily, fontWeight = FontWeight.Light, fontSize = 14.sp)
                    Spacer(modifier = Modifier.padding(12.dp,12.dp))

                    Text("Enter OTP", fontFamily = popinsFamily, fontWeight = FontWeight.Medium, fontSize = 20.sp)

                    Column(
                        modifier = Modifier
                            .fillMaxSize(1f),
                    ) {
//                        otpView()
                        DigitTextField()
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))

                        ElevatedButton(modifier= Modifier.fillMaxWidth(1f),onClick = {
                            val intentCompleteProfileActivity = Intent(activity,
                                CompleteProfileActivity::class.java)
                            activity.startActivity(intentCompleteProfileActivity)

                        },    colors = ButtonDefaults.buttonColors(containerColor = Color(83,15,64))) {
                            Text(text = "Verify Otp", fontSize = 25.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = Color.White)
                        }
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))

                        Text( textAlign = TextAlign.Center,text = "Didn't Receive OTP ?", fontSize = 12.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = Color.Gray)


                    }
                }

            }

        }



    }


    @Composable
    fun otpView(){
        val text = remember { mutableStateOf("") }
        val focusRequester = remember { FocusRequester() }


        PinInput(
            cellModifier = Modifier.border(
                BorderStroke(2.dp, Color.Blue),
                shape = RoundedCornerShape(3.dp)
            ), value = text.value,
            obscureText = "*",

            length = 4,
            disableKeypad = false // Optional
        ) {
            text.value = it
        }

    }

    @Composable
    fun DigitTextField() {
        var textFieldsState by remember { mutableStateOf(List(4) { "" }) }
        val focusRequesterList = remember { List(4) { FocusRequester() } }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            textFieldsState.forEachIndexed { index, text ->
                DigitInputField(
                    value = text,
                    onValueChange = { newValue ->
                        if (newValue.length <= 1) {
                            textFieldsState = textFieldsState.toMutableList().also {
                                it[index] = newValue
                            }
                            if (newValue.isNotEmpty() && index < textFieldsState.size - 1) {
                                focusRequesterList[index + 1].requestFocus()
                            }
                        }
                    },

                                        focusRequester = focusRequesterList[index]
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DigitInputField(
        value: String,
        onValueChange: (String) -> Unit,
        focusRequester: FocusRequester
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = LocalTextStyle.current.copy(color = Color.Black, textAlign = TextAlign.Center),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .padding(4.dp)
                .focusRequester(focusRequester)
        )
    }
}

