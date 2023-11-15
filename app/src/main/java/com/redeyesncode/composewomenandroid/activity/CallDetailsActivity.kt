package com.redeyesncode.composewomenandroid.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DoneAll
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redeyesncode.composewomenandroid.R
import com.redeyesncode.composewomenandroid.activity.ui.theme.ComposewomenandroidTheme

class CallDetailsActivity : ComponentActivity() {
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBarAndroid() {
        var callerName by remember {
            mutableStateOf("")
        }
        var callerNumber by remember {
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
                        Text("Call Details")
                    },
                            navigationIcon = {
                        IconButton(onClick = { finish() }) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                )
            },
        ) {
            Log.i("COMPOSE","$it,_compose_toolbar")
            Column(modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.White)) {
                Column (modifier = Modifier.padding(25.dp)){
                    Text("Setup fake a caller", fontFamily = popinsFamily, textAlign = TextAlign.Center,fontWeight = FontWeight.Medium, fontSize = 20.sp, color = Color.Black)
                    Spacer(modifier = Modifier.padding(12.dp,12.dp))

                    TextField(value = callerName, label = { Text(text = "Enter caller name ")},modifier = Modifier.fillMaxWidth(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done), onValueChange = {
                        callerName = it
                    },textStyle = TextStyle(fontSize = 15.sp, color = Color.Black, fontFamily = popinsFamily, fontWeight = FontWeight.Medium))
                    Spacer(modifier = Modifier.padding(12.dp,12.dp))

                    TextField(value = callerNumber, label = { Text(text = "Enter caller number ")},modifier = Modifier.fillMaxWidth(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done), onValueChange = {
                        callerNumber = it
                    },textStyle = TextStyle(fontSize = 15.sp, color = Color.Black, fontFamily = popinsFamily, fontWeight = FontWeight.Medium))
                    Spacer(modifier = Modifier.padding(12.dp,12.dp))

                    Text("Pre set Timer", fontFamily = popinsFamily, textAlign = TextAlign.Center,fontWeight = FontWeight.Medium, fontSize = 15.sp, color = Color.Black)

                    SelectableChips()
                    Spacer(modifier = Modifier.weight(1f)) // Add a spacer to push the button to the bottom

                    ElevatedButton(modifier= Modifier.fillMaxWidth(1f),onClick = {

                    },    colors = ButtonDefaults.buttonColors(containerColor = Color(83,15,64))) {


                        Text(text = "SAVE", fontSize = 18.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = Color.White)

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
                ,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Column {

                AssistChipExample(

                    text = "5 Seconds",
                    icon = Icons.Default.DoneAll,
                    selected = selectedChip == ChipType.FIVE_SECONDS,
                    onSelected = { selectedChip = ChipType.FIVE_SECONDS }
                )
                AssistChipExample(
                    text = "10 Seconds",
                    icon = Icons.Default.DoneAll,
                    selected = selectedChip == ChipType.TEN_SECONDS,
                    onSelected = { selectedChip = ChipType.TEN_SECONDS }
                )
            }
            Column {
                AssistChipExample(
                    text = "5 Minutes",
                    icon = Icons.Default.DoneAll,
                    selected = selectedChip == ChipType.FIVE_MINUTES,
                    onSelected = {
                        selectedChip = ChipType.FIVE_MINUTES
                    }
                )
                AssistChipExample(
                    text = "1 Minute",
                    icon = Icons.Default.DoneAll,
                    selected = selectedChip == ChipType.ONE_MINUTES,
                    onSelected = {
                        selectedChip = ChipType.ONE_MINUTES
                    }
                )
            }




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
        FIVE_SECONDS, TEN_SECONDS,ONE_MINUTES,FIVE_MINUTES
    }
}

