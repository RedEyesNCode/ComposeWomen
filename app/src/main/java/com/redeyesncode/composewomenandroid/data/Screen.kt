package com.redeyesncode.composewomenandroid.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.rounded.Sos
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector, val label: String) {
    object TrackMe : Screen("track_me", Icons.Default.LocationOn, "Track Me")
    object Record : Screen("record", Icons.Default.Mic, "Record")
    object SOS : Screen("sos", Icons.Rounded.Sos, "SOS")
    object FakeCall : Screen("fake_call", Icons.Default.Call, "Fake Call")
    object Helpline : Screen("helpline", Icons.Outlined.HelpOutline, "Helpline")
}