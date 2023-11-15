package com.redeyesncode.composewomenandroid.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redeyesncode.composewomenandroid.R
import com.redeyesncode.composewomenandroid.activity.ui.theme.ComposewomenandroidTheme

class AddFriendActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposewomenandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopBarAndroid()


                }
            }
        }
    }



    @Preview
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBarAndroid() {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Column {
                            Text(
                                "Add Friend",
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp
                            )
                        }

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
            Log.i("COMPOSE", "$it,_compose_toolbar")
            var userNameValue by remember {
                mutableStateOf("")
            }
            val popinsFamily = FontFamily(
                Font(R.font.popins_medium, FontWeight.Medium),
                Font(R.font.popins_regular, FontWeight.Normal),
                Font(R.font.popins_italic, FontWeight.SemiBold, FontStyle.Italic),
                Font(R.font.popins_light, FontWeight.Medium)
            )

            Column(modifier = Modifier.padding(it)) {
                Column(modifier = Modifier.padding(12.dp),verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_app_women),
                        contentDescription = null,
                        modifier = Modifier
                            .size(75.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .clip(RoundedCornerShape(CornerSize(8.dp))),
                        contentScale = ContentScale.Crop
                    )

                   CustomEditTextWithIcon()

                    Spacer(modifier = Modifier.height(12.dp))


                    CheckboxWithText(text = "Make this person my SOS Contact")
                    Spacer(modifier = Modifier.height(12.dp))
                    CustomCardWithImageView("Friend","You can share your live location with your friends using the track feature")
                    Spacer(modifier = Modifier.height(4.dp))
                    CustomCardWithImageView("SOS","You can send SOS alerts to only the SOS contacts during an emergency")
                    Spacer(modifier = Modifier.weight(1f))
                    ElevatedButton(modifier= Modifier.fillMaxWidth(1f),onClick = {


                    },    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)) {


                        Text(text = "Save", fontSize = 15.sp, fontFamily = popinsFamily, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.primaryContainer)

                    }

                }

            }



        }

    }
    @Composable
    fun CheckboxWithText(text: String) {
        var checked by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Checkbox
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                modifier = Modifier
                    .size(24.dp)
                    .clickable { checked = !checked }
            )

            // Text
            Text(
                text = text,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
                modifier = Modifier.padding(4.dp,0.dp)
            )
        }
    }
    @Composable
    fun CustomEditTextWithIcon() {
        var textValue by remember { mutableStateOf("") }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // EditText
            TextField(
                value = textValue,
                onValueChange = {
                    textValue = it
                },
                label = { Text(text = "Enter Mobile Number")},
                keyboardOptions = KeyboardOptions.Default,
                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )

            // ImageView
            Image(
                painter = painterResource(id = R.drawable.baseline_folder_shared_24),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(CornerSize(4.dp)))
                    .clickable {
                        // Handle image click if needed
                    }
            )
        }
    }
    @Composable
    fun CustomCardWithImageView(title:String,sub:String) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black, shape = MaterialTheme.shapes.medium)
                .padding(2.dp),
            shape = MaterialTheme.shapes.medium,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                // Composable function with ImageView and TextViews
                ComposableWithImageView(title,sub)

                // Additional TextView below the ImageView and TextViews

            }
        }
    }

    @Composable
    fun ComposableWithImageView(title: String, sub: String) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // ImageView at the start
                Image(
                    painter = painterResource(id = R.drawable.baseline_sports_handball_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )

                // TextView next to ImageView
                Text(
                    text = title,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
            }
            Text(
                text = sub,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )

        }
    }
}
