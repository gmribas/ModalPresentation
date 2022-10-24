package com.gmribas.modalpresentation.domain

data class Contact(
    val id: Int,
    val name: String,
    val nickname: String,
    val picture: String,
    val phoneNumber: String,
    val email: String,
    val address: String
)