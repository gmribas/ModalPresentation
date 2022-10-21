package com.gmribas.modalpresentation.presentation.contactList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmribas.modalpresentation.data.Mock
import com.gmribas.modalpresentation.domain.repository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ContactListViewModel(private val repository: ContactRepository): ViewModel() {

    private val _state = mutableStateOf(ContactListState())
    val state: State<ContactListState> = _state

    private var getContactsJob: Job? = null

    init {
        getContacts()
    }

    private fun getContacts() {
        getContactsJob?.cancel()
        _state.value = _state.value.copy(loading = true)

        getContactsJob = viewModelScope.launch(Dispatchers.IO) {
            delay(1500)
            val list = Mock.contactList()
            viewModelScope.launch(Dispatchers.Main) {
                _state.value = _state.value.copy(loading = false)
                _state.value = _state.value.copy(contactList = list)
            }
        }
    }
}