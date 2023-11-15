package com.redeyesncode.composewomenandroid.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redeyesncode.composewomenandroid.R
import com.redeyesncode.composewomenandroid.activity.ui.theme.ComposewomenandroidTheme
import com.redeyesncode.composewomenandroid.data.HelpLine
import com.redeyesncode.composewomenandroid.data.RecordListData

class AllRecordingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposewomenandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White


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
                        Text("Recordings")
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


            var itemsList = arrayListOf<RecordListData>()
            itemsList.add(RecordListData("14/11/2023","4"))
            itemsList.add(RecordListData("15/11/2023","23"))
            itemsList.add(RecordListData("16/11/2023","56"))
            itemsList.add(RecordListData("17/07/2023","6"))
            itemsList.add(RecordListData("3/11/2023","4"))
            itemsList.add(RecordListData("8/11/2023","21"))

            Column(modifier = Modifier.padding(it)) {
                Column(modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(1f)) {
                    Spacer(modifier = Modifier.padding(0.dp,6.dp))
                    Text("Detailed history of the recorded event", color = Color.Gray,fontWeight = FontWeight.Medium, fontSize = 14.sp)
                    LazyColumn (modifier = Modifier.background(Color.White)){
                        items(itemsList.size) { item ->
                            // HERE IT IS THE INDEX FROM THE PROVIDED LIST

                            recordItem(recorderListData = itemsList[item])
                        }
                    }
                }
            }


            
            
        }


    }


    @Composable
    fun recordItem(recorderListData: RecordListData) {
        val activity = LocalContext.current as Activity

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp)
                .clip(RoundedCornerShape(CornerSize(16.dp)))
                .background(Color.White)
                .clickable {
                    val intentRecordDetailActivity = Intent(activity, RecordDetailActivity::class.java)
                    activity.startActivity(intentRecordDetailActivity)
                }
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
                    painter = painterResource(id = R.drawable.ic_record),
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
                    // Existing callerNumber Text
                    Text(
                        text = "Recorded on",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    // Modified callerName Column to include the additional TextView
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = recorderListData.date,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))


                        // Additional TextView at the end of callerName
                        Text(
                            text = "Lasted for ${recorderListData.duration} secs",
                            color = Color.Black, // Change color as needed
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                // Image View at the end
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
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

