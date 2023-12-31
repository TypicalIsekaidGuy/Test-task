package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(viewModels: HashMap<Screen, ViewModel>){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.UserScreen.route/*+ "/name/10F" */){//try using from userviewmodel if statement
        composable(route = Screen.UserScreen.route){
            UserScreen(navController,viewModels[Screen.UserScreen] as UserViewModel)
        }
        composable(route = Screen.MainScreen.route)
        {
            MainScreen(navController, viewModels[Screen.MainScreen] as MainViewModel)
        }

        /*        composable(route = Screen.CalculatorScreen.route + "/{name}/{price}", arguments = listOf(navArgument("name") { type = NavType.StringType },navArgument("price") { type = NavType.FloatType } )){backStackEntry ->
                    if(backStackEntry.arguments?.getString("name").isNullOrEmpty()||backStackEntry.arguments?.getFloat("price")==null){
                        throw NullPointerException("NULL NAME||PRICE")
                    }
                    val name = backStackEntry.arguments?.getString("name") as String
                    val price = backStackEntry.arguments?.getFloat("price") as Float
                    CalculatorScreen(navController =  navController, viewModel, name, price)
                }*/
    }
}