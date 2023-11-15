package com.redeyesncode.composewomenandroid.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redeyesncode.composewomenandroid.R
import com.redeyesncode.composewomenandroid.data.ProfileSettings
import com.redeyesncode.composewomenandroid.ui.theme.ComposewomenandroidTheme

class UserProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposewomenandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    TopAppBarAndroid()

                }
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
                        Text("Your Profile")
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
            Log.i("COMPOSE","$it,_compose_toolbar")
            val itemsList = ArrayList<ProfileSettings>()
            itemsList.add(ProfileSettings("History", R.drawable.baseline_manage_history_24))
            itemsList.add(ProfileSettings("Friends", R.drawable.baseline_sports_handball_24))
            itemsList.add(ProfileSettings("Block list", R.drawable.baseline_person_add_disabled_24))
            itemsList.add(ProfileSettings("Feedback", R.drawable.baseline_recommend_24))
            itemsList.add(ProfileSettings("Legal", R.drawable.baseline_folder_shared_24))
            itemsList.add(ProfileSettings("Help", R.drawable.baseline_emoji_objects_24))
            itemsList.add(ProfileSettings("Settings", R.drawable.baseline_settings_24))
            itemsList.add(ProfileSettings("Logout", R.drawable.baseline_logout_24))

            Column(modifier = Modifier.padding(it)) {
                Column (modifier = Modifier.padding(25.dp)){
                    Spacer(modifier = Modifier.padding(6.dp,6.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxSize(1f),
                    ) {
                        CardViewProfile()
                        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                            items(itemsList.size) { item ->
                               
                                // HERE IT IS THE INDEX FROM THE PROVIDED LIST
                                itemProfileSetting(title = itemsList[item].name, drawable = itemsList[item].drawable)
                            }
                        }
                    }
                }

            }

        }



    }


    @Composable
    fun itemProfileSetting(title:String,drawable: Int){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clip(RoundedCornerShape(CornerSize(16.dp)))
                .background(Color.White)

        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(id = drawable),
                    contentDescription = null,

                    modifier = Modifier
                        .size(40.dp)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(CornerSize(8.dp))),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 15.sp
                )
            }
        }
    }


    @Composable
    fun CardViewProfile() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clip(RoundedCornerShape(CornerSize(16.dp)))
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Image View at the start
                Image(
                    painter = painterResource(id = R.drawable.ic_app_women),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(CornerSize(8.dp))),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(16.dp))

                // Two Text Views vertically aligned
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Ashutosh Singh",
                        color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("+91 6261319133", color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 15.sp)

                }

                Spacer(modifier = Modifier.weight(1f))

                // Image View at the end
                Image(
                    painter = painterResource(id = R.drawable.baseline_create_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .clip(RoundedCornerShape(CornerSize(8.dp))),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

