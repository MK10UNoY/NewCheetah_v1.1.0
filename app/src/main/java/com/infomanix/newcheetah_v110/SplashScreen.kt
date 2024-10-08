package com.infomanix.newcheetah_v110

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SplashScreen(navController: NavHostController){
    Column(Modifier
        .fillMaxSize()
        .background(Color(0xFF49CFCA)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){
//        Image(
//            painter = painterResource(R.drawable.spash),
//            contentDescription = "Splash Icon",
//            modifier = Modifier.background(Color.Transparent))

        Text(text = "News Cheetah",
            fontWeight = FontWeight.W600,
            fontSize = 48.sp,
            softWrap = true,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            color = Color.White
        )
    }
}