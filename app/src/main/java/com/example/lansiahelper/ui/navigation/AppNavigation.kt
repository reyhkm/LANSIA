package com.example.lansiahelper.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lansiahelper.ui.screens.ContactsScreen
import com.example.lansiahelper.ui.screens.HomeScreen
import com.example.lansiahelper.ui.screens.MedicationScreen

object AppRoutes {
    const val HOME = "home"
    const val MEDICATIONS = "medications"
    const val CONTACTS = "contacts"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.HOME) {
        composable(AppRoutes.HOME) {
            HomeScreen(navController = navController)
        }
        composable(AppRoutes.MEDICATIONS) {
            MedicationScreen(navController = navController)
        }
        composable(AppRoutes.CONTACTS) {
            ContactsScreen(navController = navController)
        }
    }
}
