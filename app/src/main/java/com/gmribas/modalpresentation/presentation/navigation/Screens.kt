package com.gmribas.modalpresentation.presentation.navigation

sealed class Screens(val route: String) {
    object ContactList: Screens("contact_list")
    object ContactDetails: Screens("contact_details")
}