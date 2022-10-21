package com.gmribas.modalpresentation.domain.repository

import com.gmribas.modalpresentation.domain.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    suspend fun getContacts(): Flow<List<Contact>>

    suspend fun getContact(id: Int): Contact
}