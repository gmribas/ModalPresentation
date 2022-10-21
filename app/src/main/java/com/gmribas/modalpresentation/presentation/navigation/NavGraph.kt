package com.gmribas.modalpresentation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gmribas.modalpresentation.presentation.contactList.ContactListScreen
import com.gmribas.modalpresentation.presentation.contactDetails.ContactDetailsScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
    navController = navController,
    startDestination = Screens.ContactList.route)
    {
        composable(Screens.ContactList.route) { 
            ContactListScreen(contacts = )
        }
        composable(Screens.ContactDetails.route) {
            ContactDetailsScreen(contact = )
        }
    }
}