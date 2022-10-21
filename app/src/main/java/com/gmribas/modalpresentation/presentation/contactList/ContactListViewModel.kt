package com.gmribas.modalpresentation.presentation.contactList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class ContactListViewModel: ViewModel() {

    private val _state = mutableStateOf(ContactListState())
    val state: State<ContactListState> = _state

    private var getContactsJob: Job? = null

    init {
        getContacts()
    }

    private fun getContacts() {

    }
}