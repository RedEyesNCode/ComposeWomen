package com.redeyesncode.composewomenandroid.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Photo
import androidx.compose.material.icons.outlined.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redeyesncode.composewomenandroid.R
import com.redeyesncode.composewomenandroid.activity.ui.theme.ComposewomenandroidTheme

class RecordDetailActivity : ComponentActivity() {
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBarAndroid(){
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Column {
                            Text("Record", color = MaterialTheme.colorScheme.primary,fontWeight = FontWeight.Medium, fontSize = 20.sp)
                            Spacer(modifier = Modifier.padding(0.dp,6.dp))
                            Text("Detailed history of the recorded event", color = Color.Gray,fontWeight = FontWeight.Medium, fontSize = 14.sp)
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

            Column(modifier = Modifier.padding(it)) {
                Spacer(modifier = Modifier.padding(12.dp,12.dp))

                Column(modifier = Modifier.padding(12.dp)) {
                    ImageTextRow(imageRes = R.drawable.ic_record, text = "Recorded on 14/11/2023 at 5:37 PM",false)

                    Spacer(modifier = Modifier.padding(12.dp,12.dp))

                    ImageTextRow(imageRes = R.drawable.baseline_manage_history_24, text = "Record Lasted for 41 seconds",true)
                    Spacer(modifier = Modifier.padding(12.dp,12.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                            .height(2.dp)
                            .background(Color.Red)
                    )

                    Spacer(modifier = Modifier.padding(12.dp,12.dp))
                    Text("The pictures,audio and location information were captured during the anonymous record session", color = Color.Black, textAlign = TextAlign.Center,fontWeight = FontWeight.Medium, fontSize = 14.sp)
                    TabLayout()
                }




            }

        }



    }
    @Composable
    fun ImageTextRow(imageRes: Int, text: String,isSmallImage:Boolean) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            // Image View at the start
            if(isSmallImage){
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .clip(RoundedCornerShape(CornerSize(8.dp))),
                    contentScale = ContentScale.Crop
                )

            }else{
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(CornerSize(8.dp))),
                    contentScale = ContentScale.Crop
                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            // Text View at the end of the Image View
            Text(text, color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 14.sp)

        }
    }


    @Composable
    fun recordPhotoTab(){
        val itemsList = ArrayList<String>()
        itemsList.add("05:37 PM")
        itemsList.add("05:45 PM")
        itemsList.add("05:23 PM")
        itemsList.add("05:34 PM")
        itemsList.add("05:32 PM")
        itemsList.add("05:23 PM")
        itemsList.add("05:34 PM")
        itemsList.add("05:34 PM")
        LazyRow (modifier = Modifier.background(Color.White)){
            items(itemsList.size) { item ->
                // HERE IT IS THE INDEX FROM THE PROVIDED LIST
                RoundedImageViewWithText(imageRes = R.drawable.ic_app_women, text = itemsList[item])

            }
        }



    }

    @Composable
    fun recordAudioTab(){
        Column(modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()) {

            Text(
                text = "Audio may not be recorded due to",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.padding(12.dp,12.dp))

            Text(
                text = "1. Your Phone's mic being utilized by another application",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.padding(12.dp,12.dp))

            Text(
                text = "2. Recording session being too short (min duration required is 30 seconds)",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
        }


    }

    @Composable
    fun recordLocationTab(){

        val itemsList = ArrayList<String>()
        itemsList.add("05:37 PM")
        itemsList.add("05:45 PM")
        itemsList.add("05:23 PM")
        itemsList.add("05:34 PM")
        itemsList.add("05:32 PM")
        itemsList.add("05:23 PM")
        itemsList.add("05:34 PM")
        itemsList.add("05:34 PM")
        LazyColumn (modifier = Modifier.background(Color.White)){
            items(itemsList.size) { item ->
                // HERE IT IS THE INDEX FROM THE PROVIDED LIST
                recordLocationItem()

            }
        }
    }

    @Composable
    fun RoundedImageViewWithText(imageRes: Int, text: String, cornerRadius: Dp = 12.dp) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(cornerRadius))
        ) {
            // Rounded Image
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .border(2.dp,Color.LightGray)
                    .clip(RoundedCornerShape(cornerRadius))
            )
            Spacer(modifier = Modifier.padding(12.dp,12.dp))

            // Text View at the bottom center
            Text(
                text = text,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(Color.Black)
            )
        }
    }
    @Composable
    fun recordLocationItem() {
        Card(

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Rectangular Rounded Image View at the start
                Image(
                    painter = painterResource(id = R.drawable.ic_app_women),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(8.dp))
                )


                // Set of TextViews arranged vertically at the end
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = "Initial time",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.padding(6.dp,6.dp))

                    Text(
                        text = "05:37 PM",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.padding(12.dp,12.dp))

                    Text(
                        text = "Location",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.padding(6.dp,6.dp))

                    Text(
                        text = "India",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }

    @Composable
    fun TabLayout() {
        val tabs = remember {
            listOf(
                TabItem(icon = Icons.Outlined.Photo, text = "Photos"),
                TabItem(icon = Icons.Outlined.VolumeUp, text = "Audio"),
                TabItem(icon = Icons.Outlined.LocationOn, text = "Location")
            )
        }

        var selectedTabIndex by remember { mutableStateOf(0) }
        var content: @Composable () -> Unit = {
            when (selectedTabIndex) {
                0 -> recordPhotoTab()
                1 -> recordAudioTab()
                2 -> recordLocationTab()
            }
        }

        Column {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                // Set your desired background color
                contentColor = Color.White, // Set your desired text and icon color
                indicator = { tabPositions ->

                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(56.dp) // Set your desired tab height
            ) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        modifier = Modifier
                            .height(56.dp) // Set your desired tab height
                            .fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = null,
                                tint = if (selectedTabIndex == index) Color.Black else Color.Gray, // Set your desired icon color
                                modifier = Modifier.size(24.dp) // Set your desired icon size
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = tab.text,
                                color = if (selectedTabIndex == index) Color.Black else Color.Gray, // Set your desired text color
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }
                }
            }
            Spacer(modifier = Modifier.padding(6.dp,6.dp))

            content()

        }


    }


    data class TabItem(val icon: ImageVector, val text: String)

    @Composable
    fun Modifier.tabIndicatorOffset(position: TabPosition): Modifier = composed {
        // Adjust the indicator offset as needed
        val density = LocalDensity.current.density
        val indicatorWidth = 4.dp * density
        val indicatorHeight = 2.dp * density

        Modifier
            .padding(horizontal = position.left, vertical = position.right)
            .width(indicatorWidth)
            .height(indicatorHeight)
    }



}
