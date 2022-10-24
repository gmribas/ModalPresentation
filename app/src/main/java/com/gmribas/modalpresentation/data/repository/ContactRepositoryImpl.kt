package com.gmribas.modalpresentation.data.repository

import com.gmribas.modalpresentation.data.Mock
import com.gmribas.modalpresentation.domain.Contact
import com.gmribas.modalpresentation.domain.repository.ContactRepository
import com.gmribas.modalpresentation.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactRepositoryImpl: ContactRepository {

    override suspend fun getContacts(): Flow<Resource<List<Contact>>> = flow {
        emit(Resource.Loading(true))
        delay(1500)
        val list = Mock.contactList(max = 20)
        emit(Resource.Success(list))
        emit(Resource.Loading(false))
    }

    override suspend fun getContact(id: Int): Contact = Mock.contact(id)
}