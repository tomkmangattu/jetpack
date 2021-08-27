package com.tomkmangattu.app5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tomkmangattu.app5.ui.theme.App5Theme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App5Theme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "home",
                                    route = "home",
                                    icon = Icons.Default.Home,
                                    badgeCount = 0,
                                ),
                                BottomNavItem(
                                    name = "chats",
                                    route = "chats",
                                    icon = Icons.Default.Notifications,
                                    badgeCount = 10,
                                ),
                                BottomNavItem(
                                    name = "settings",
                                    route = "settings",
                                    icon = Icons.Default.Settings,
                                    badgeCount = 20,
                                )
                            ),
                            navHostController = navController,
                            modifier = Modifier,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navHostController = navController)
                }
            }
        }
    }
}

@Composable
fun Navigation(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = "home"){
        composable("home"){
            HomeScreen()
        }
        composable("chats"){
            ChatsScreen()
        }
        composable("settings"){
            SettingsScreen()
        }
    }
}

@Composable
fun HomeScreen(){
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
            ){
        Text(text = "Home Screen")
    }
}

@Composable
fun ChatsScreen(){
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Chats Screen")
    }
}

@Composable
fun SettingsScreen(){
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Settings Screen")
    }
}

@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navHostController: NavHostController,
    modifier: Modifier,
    onItemClick: (BottomNavItem) -> Unit,
){
    val backStackEntry = navHostController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp,
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route

            BottomNavigationItem(
                selected = selected,
                onClick = {onItemClick(item)},
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if(item.badgeCount > 0){
                            BadgeBox(
                                badgeContent ={
                                    Text(text = item.badgeCount.toString())
                                }
                            ) {
                                Icon(imageVector = item.icon, contentDescription = item.name)
                            }
                        }else{
                            Icon(imageVector = item.icon, contentDescription = item.name)
                        }
                        if (selected){
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp,
                            )
                        }
                    }
                },
                unselectedContentColor = Color.Gray,
                selectedContentColor = Color.Green,
            )
        }
    }
}