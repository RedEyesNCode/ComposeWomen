package com.redeyesncode.composewomenandroid.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
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

class CompleteProfileActivity : ComponentActivity() {
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

        var userNameValue by remember {
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
                        Text("Profile")
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
                    Text("Complete Profile", fontFamily = popinsFamily, textAlign = TextAlign.Center,fontWeight = FontWeight.Medium, fontSize = 20.sp, color = Color.DarkGray)
                    Spacer(modifier = Modifier.padding(12.dp,12.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxSize(1f),
                    ) {
                        TextField(maxLines = 1, label = { Text(text = "Enter Your name")},value = userNameValue,modifier = Modifier.fillMaxWidth(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done), onValueChange = {

                            userNameValue = it
                        },textStyle = TextStyle(fontSize = 15.sp, color = Color.Black, fontFamily = popinsFamily, fontWeight = FontWeight.Medium))
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))

                        Text("Choose Gender", fontFamily = popinsFamily, textAlign = TextAlign.Center,fontWeight = FontWeight.Medium, fontSize = 15.sp, color = Color.DarkGray)
                        SelectableChips()
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))

                        Text( textAlign = TextAlign.Center,text = "Allowing others genders into the App is important as it enables husbands,fathers,family and friends to render immediate help in case of emergency", fontSize = 12.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = Color.LightGray)
                        Spacer(modifier = Modifier.padding(12.dp,12.dp))

                        ElevatedButton(modifier= Modifier.fillMaxWidth(1f),onClick = {

                            val intentCreatePasswordActivity = Intent(activity,
                                CreatePasswordActivity::class.java)
                            activity.startActivity(intentCreatePasswordActivity)

                        },    colors = ButtonDefaults.buttonColors(containerColor = Color(83,15,64))) {


                            Text(text = "Continue", fontSize = 25.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = Color.White)


                        }
                    }
                }

            }

        }



    }

    @Composable
    fun SelectableChips() {
        var selectedChip by remember { mutableStateOf<ChipType?>(null) }

        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            AssistChipExample(

                text = "Male",
                icon = Icons.Default.AccountCircle,
                selected = selectedChip == ChipType.MALE,
                onSelected = { selectedChip = ChipType.MALE }
            )
            AssistChipExample(
                text = "Female",
                icon = Icons.Default.Face,
                selected = selectedChip == ChipType.FEMALE,
                onSelected = { selectedChip = ChipType.FEMALE }
            )
            AssistChipExample(
                text = "Others",
                icon = Icons.Default.AccountBox,
                selected = selectedChip == ChipType.OTHERS,
                onSelected = {
                    selectedChip = ChipType.OTHERS
                }
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AssistChipExample(
        text: String,
        icon: ImageVector,
        selected: Boolean,
        onSelected: () -> Unit
    ) {

        FilterChip(
            onClick = {
                onSelected()
                      },
            label = {
                Text(text)
            },

            selected = selected,
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
        )
    }

    enum class ChipType {
        MALE, FEMALE, OTHERS
    }


}


