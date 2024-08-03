package com.tejas.staggeredgridlayoutcompose.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ComposeApp(
    navController: NavHostController = rememberNavController()
){

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = "Screen1",
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ){
            composable(route = "Screen1"){
                Home()
            }
        }
    }
}