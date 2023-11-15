package com.redeyesncode.composewomenandroid.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.redeyesncode.composewomenandroid.R
import com.redeyesncode.composewomenandroid.data.HelpLine
import com.redeyesncode.composewomenandroid.data.Screen
import com.redeyesncode.composewomenandroid.ui.theme.ComposewomenandroidTheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposewomenandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CenterAlignedTopAppBarExample()

                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
    @Composable
    fun CenterAlignedTopAppBarExample() {
        val activity = LocalContext.current as Activity
        val scope = rememberCoroutineScope()
        var showNotificationBottonSheet by remember { mutableStateOf(false) }
        var showAddFriendsBottomSheet by remember { mutableStateOf(false) }

        val notificationSheetContent = @Composable {
            // Content of the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "No Notification found",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

            }
        }

        val navController = rememberNavController()
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(
                            "SafeHaven",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Outlined.Face,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {

                            var intentUserProfileActivity = Intent(activity, UserProfileActivity::class.java)
                            startActivity(intentUserProfileActivity)

                        }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                        IconButton(onClick = {

                            //Open bottom sheet for notification
                            showNotificationBottonSheet = true

                        }) {
                            Icon(
                                imageVector = Icons.Filled.NotificationsActive,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
            }, bottomBar = {
                            viewBottomBarDashboard(navController)

            },
        ) {
            Log.i("COMPOSE","$it,_compose_toolbar")
            Log.i("COMPOSE","$it,_compose_toolbar")

            var isShow = false

            Column(modifier = Modifier.padding(it)) {
                AppNavigation(navController)
            }

            //NOTIFICATION BOTTOM SHEET
            if (showNotificationBottonSheet) {
                ModalBottomSheet(
                    modifier = Modifier.fillMaxSize(),
                    onDismissRequest = {showNotificationBottonSheet = false},

                    sheetState = SheetState(skipPartiallyExpanded = false, initialValue = SheetValue.Expanded)

                ) {

                    notificationSheetContent()
                }
            }
        }
    }
    @OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun ModalBottomSheetExample() {
        var sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
        val scope = rememberCoroutineScope()
        var showBottomSheet by remember { mutableStateOf(false) }
        val sheetContent = @Composable {
            // Content of the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "No Notification found",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(16.dp))


            }
        }

        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show bottom sheet") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        showBottomSheet = true
                        Log.i("COMPOSE", "$showBottomSheet,showBottomSheet")
                        Log.i("COMPOSE", "${sheetState.currentValue},sheetState")


                    }
                )
            }
        ) { contentPadding ->
            // Screen content
            Log.i("COMPOSE", "$contentPadding,contentPadding")


            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {showBottomSheet = false},

                    sheetState = SheetState(skipPartiallyExpanded = false, initialValue = SheetValue.Expanded)

                ) {

                    sheetContent()
                }
            }
        }





    }

    // Define navigation graph
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppNavigation(navController: NavHostController) {

        // Set up bottom navigation
        val items = listOf(
            Screen.TrackMe,
            Screen.Record,
            Screen.SOS,
            Screen.FakeCall,
            Screen.Helpline
        )
        NavHost(navController, startDestination = Screen.TrackMe.route) {
            composable(Screen.TrackMe.route) {
                TrackMeScreen()
            }
            composable(Screen.Record.route) {
                RecordScreen()
            }
            composable(Screen.SOS.route) {
                SOSScreen()
            }
            composable(Screen.FakeCall.route) {
                FakeCallScreen()
            }
            composable(Screen.Helpline.route) {
                HelplineScreen()
            }
        }




        // Set up navigation host

    }

    @Composable
    fun viewBottomBarDashboard(navController:NavController){

        // Set up bottom navigation
        val items = listOf(
            Screen.TrackMe,
            Screen.Record,
            Screen.SOS,
            Screen.FakeCall,
            Screen.Helpline
        )

        BottomNavigation(backgroundColor = MaterialTheme.colorScheme.primaryContainer, contentColor = MaterialTheme.colorScheme.primary) {


            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.arguments?.getString("route")

            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(screen.icon, contentDescription = null) },
                    label = { Text(screen.label) },
                    selected = currentRoute == screen.route,

                    alwaysShowLabel = false,
                    onClick = {
                        navController.navigate(screen.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }

        }


    }

    @Composable
    fun SOSScreen() {
        Text("SOS SCREEN", fontWeight = FontWeight.Medium, fontSize = 14.sp)

    }

    @Composable
    fun FakeCallScreen() {
        val activity = LocalContext.current as Activity

        Column(
            verticalArrangement = Arrangement.Top, // Align items from the top
            horizontalAlignment = Alignment.CenterHorizontally, // Center items horizontally
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Text("Fake Call", color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 20.sp, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.padding(0.dp,6.dp))
            Text("Schedule A Fake Call", color = Color.Gray,fontWeight = FontWeight.Medium, fontSize = 14.sp)
            Spacer(modifier = Modifier.padding(0.dp,12.dp))
            RoundedCardCallDetails(
                callerName = "Ashutosh Singh",
                callerNumber = "6261319133",
                drawable = R.drawable.baseline_create_24
            )

            Spacer(modifier = Modifier.weight(1f)) // Add a spacer to push the button to the bottom

            OutlinedButton(
                onClick = {
                          val intentCallDetailsActivity = Intent(activity,CallDetailsActivity::class.java)
                    startActivity(intentCallDetailsActivity)

                },
                border = BorderStroke(2.dp, Color(109,190,131)),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth() // Make the button take the full width
            ) {
                Text(text = "Get a Call", color = Color(109,190,131), fontSize = 15.sp)
            }
        }


    }

    @Composable
    fun HelplineScreen() {

        var itemsList = arrayListOf<HelpLine>()
        itemsList.add(HelpLine("112","National Helpline", R.drawable.ic_app_women))
        itemsList.add(HelpLine("108","Ambulance", R.drawable.ic_ambulance))
        itemsList.add(HelpLine("102","Pregnancy Medic", R.drawable.ic_pregnant))
        itemsList.add(HelpLine("101","Fire Service", R.drawable.ic_firehouse))
        itemsList.add(HelpLine("100","Police help", R.drawable.ic_policeman))


        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(1f)) {
            Text("Call for Help", color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 20.sp)
            Spacer(modifier = Modifier.padding(0.dp,6.dp))
            Text("In case of emergency, call an appropriate number for help", color = Color.Gray,fontWeight = FontWeight.Medium, fontSize = 14.sp)
            LazyColumn {
                items(itemsList.size) { item ->
                    // HERE IT IS THE INDEX FROM THE PROVIDED LIST
                    RoundedCardViewHelpline(number = itemsList[item].number, title = itemsList[item].title, drawable = itemsList[item].drawable)

                }
            }
        }






    }

    @Composable
    fun RecordScreen() {
        val activity = LocalContext.current as Activity

        Column(
            verticalArrangement = Arrangement.Top, // Align items from the top
            horizontalAlignment = Alignment.CenterHorizontally, // Center items horizontally
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {

            Text("Anonymous Recording", color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 20.sp, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.padding(0.dp,6.dp))
            Text("Anonymously record your surroundings without notifying others", color = Color.Gray,fontWeight = FontWeight.Medium, fontSize = 14.sp)
            Spacer(modifier = Modifier.padding(0.dp,12.dp))

            RoundedCardCallDetails(
                callerName = "Recordings",
                callerNumber = "Tap to See History",
                drawable = R.drawable.baseline_arrow_forward_ios_24
            )

            Spacer(modifier = Modifier.weight(1f)) // Add a spacer to push the button to the bottom
            OutlinedButton(
                onClick = {


                },
                border = BorderStroke(2.dp, Color.Red),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth() // Make the button take the full width
            ) {
                Text(text = "Start Recording", color = Color.Black, fontSize = 15.sp)
            }

        }


    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TrackMeScreen() {
        var showAddFriendsBottomSheet by remember { mutableStateOf(false) }

        val activity = LocalContext.current as Activity

        val notificationSheetContent = @Composable {
            // Content of the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Select friends & share your live location",
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Tap to select",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(6.dp))


                Text(
                    text = "All Contacts",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "No Friends Found",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Live Location Duration",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(9.dp))

                ElevatedButton(modifier= Modifier.fillMaxWidth(1f),onClick = {
                    showAddFriendsBottomSheet= false



                },    colors = ButtonDefaults.buttonColors(containerColor = Color(83,15,64))) {


                    Text(text = "Continue", fontSize = 25.sp, fontWeight = FontWeight.Medium, color = Color.White)

                }
            }
        }

        // Vertical arrangement of two TextViews

        Surface {
            Card(

                modifier = Modifier
                    .fillMaxWidth()

                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Add Friend",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "Add a friend to use SOS and Track me",
                            color = Color.Gray,
                            fontWeight = FontWeight.Light,
                            fontSize = 16.sp
                        )
                        ElevatedButton(modifier= Modifier.wrapContentSize(),onClick = {
                            showAddFriendsBottomSheet = true


                        },    colors = ButtonDefaults.buttonColors(containerColor = Color(83,15,64))) {


                            Text(text = "Add Friends", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.White)

                        }
                    }

                    // Button aligned at the center end

                }
            }


            if (showAddFriendsBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {showAddFriendsBottomSheet = false},

                    sheetState = SheetState(skipPartiallyExpanded = false, initialValue = SheetValue.Expanded)

                ) {

                    notificationSheetContent()
                }
            }

        }

        Box{
            GoogleMapTest()
            Column(modifier = Modifier.padding(12.dp)) {
                Text("Track Me", color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 20.sp, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.padding(0.dp,6.dp))
                Text("Share live location with your friends", color = Color.Gray,fontWeight = FontWeight.Medium, fontSize = 14.sp)
                Spacer(modifier = Modifier.padding(0.dp,12.dp))
                AddFriendLayout()

                Spacer(modifier = Modifier.weight(1f))
                OutlinedButton(
                    onClick = {
                        showAddFriendsBottomSheet = true

                    },
                    border = BorderStroke(2.dp, Color.Magenta),
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth() // Make the button take the full width
                ) {
                    Text(text = "Track Me", color = Color.Black, fontSize = 15.sp)
                }
            }

        }







    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddFriendLayout() {

        var showAddFriendsBottomSheet by remember { mutableStateOf(false) }

        val activity = LocalContext.current as Activity


        // Vertical arrangement of two TextViews

        Surface {
            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.White, RoundedCornerShape(8.dp))
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Add Friend",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "Add a friend to use SOS and Track me",
                            color = Color.Gray,
                            fontWeight = FontWeight.Light,
                            fontSize = 16.sp
                        )
                        ElevatedButton(modifier= Modifier.wrapContentSize(),onClick = {

                            val intentOtpVerficationActivity = Intent(activity, AddFriendActivity::class.java)
                            activity.startActivity(intentOtpVerficationActivity)


                        },    colors = ButtonDefaults.buttonColors(containerColor = Color(83,15,64))) {


                            Text(text = "Add Friends", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.White)

                        }
                    }


                }
            }


        }

    }

    @Composable
    fun GoogleMapTest(){
        val singapore = LatLng(23.259933, 77.412613)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 10f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        )


    }
    @Composable
    fun RoundedCardCallDetails(callerName: String, callerNumber: String, drawable: Int) {
        val activity = LocalContext.current as Activity

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp)
                .clip(RoundedCornerShape(CornerSize(16.dp)))
                .background(Color.LightGray)
                .clickable {
                    val intentCallDetailsActivity =
                        Intent(activity, AllRecordingsActivity::class.java)
                    startActivity(intentCallDetailsActivity)
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
                    painter = painterResource(id = R.drawable.baseline_mic_24),
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
                    androidx.compose.material3.Text(
                        text = callerNumber,
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
                            text = callerName,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp
                        )

                        // Additional TextView at the end of callerName
//                        Text(
//                            text = "TextView at the end",
//                            color = Color.Red, // Change color as needed
//                            fontWeight = FontWeight.Medium,
//                            fontSize = 15.sp
//                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                // Image View at the end
                Image(
                    painter = painterResource(id = drawable),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .clip(RoundedCornerShape(CornerSize(8.dp))),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }



    @Composable
    fun RoundedCardViewHelpline(number:String, title:String, drawable:Int) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp)
                .clip(RoundedCornerShape(CornerSize(16.dp)))
                .background(MaterialTheme.colorScheme.primary)
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
                    painter = painterResource(id = drawable),
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
                    androidx.compose.material3.Text(
                        text = number,
                        color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(title, color = Color.Black,fontWeight = FontWeight.Medium, fontSize = 15.sp)

                }

                Spacer(modifier = Modifier.weight(1f))

                // Image View at the end
                Image(
                    painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
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

