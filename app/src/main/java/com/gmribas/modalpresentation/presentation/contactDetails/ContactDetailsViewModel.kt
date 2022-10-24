package com.gmribas.modalpresentation.presentation.contactDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmribas.modalpresentation.domain.repository.ContactRepository
import com.gmribas.modalpresentation.presentation.contactList.ContactListState
import com.gmribas.modalpresentation.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ContactDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ContactRepository
) : ViewModel() {

    private val _state = mutableStateOf(ContactState())
    val state: State<ContactState> = _state

    private var getContactJob: Job? = null

    init {
        getContact()
    }

    private fun getContact() {
        getContactJob?.cancel()

        getContactJob = viewModelScope.launch {
            val id = savedStateHandle.get<Int>("contactId") ?: return@launch

            _state.value = _state.value.copy(loading = true)
            val contact = async { repository.getContact(id) }
            _state.value = _state.value.copy(contact = contact.await())
            _state.value = _state.value.copy(loading = false)
        }
    }
}