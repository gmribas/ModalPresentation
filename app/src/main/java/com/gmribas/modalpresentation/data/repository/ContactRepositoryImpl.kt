package com.gmribas.modalpresentation.data.repository

import com.gmribas.modalpresentation.domain.Contact
import com.gmribas.modalpresentation.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class ContactRepositoryImpl: ContactRepository {

    override suspend fun getContacts(): Flow<List<Contact>> {
        TODO("Not yet implemented")
    }

    override suspend fun getContact(id: Int): Contact {
        TODO("Not yet implemented")
    }
}