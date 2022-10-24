package com.gmribas.modalpresentation.domain.repository

import com.gmribas.modalpresentation.domain.Contact
import com.gmribas.modalpresentation.util.Resource
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    suspend fun getContacts(): Flow<Resource<List<Contact>>>

    suspend fun getContact(id: Int): Contact
}