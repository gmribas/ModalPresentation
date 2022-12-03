package com.gmribas.modalpresentation.presentation.contactList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmribas.modalpresentation.domain.repository.ContactRepository
import com.gmribas.modalpresentation.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ContactListViewModel(private val repository: ContactRepository) : ViewModel() {

    private val _state = mutableStateOf(ContactListState())
    val state: State<ContactListState> = _state

    private var getContactsJob: Job? = null

    init {
        getContacts()
    }

    private fun getContacts() {
        getContactsJob?.cancel()

        getContactsJob = viewModelScope.launch {
            repository
                .getContacts()
                .flowOn(Dispatchers.IO)
                .collect { result ->
                    when (result) {
                        is Resource.Error -> TODO()
                        is Resource.Loading -> {
                            _state.value = _state.value.copy(loading = true)
                        }
                        is Resource.Success -> {
                            _state.value = _state.value.copy(contactList = result.data ?: emptyList())
                        }
                    }
                }
        }
    }

    fun askForPermissionIfNeeded() {
        _state.value = _state.value.copy(showDialogPermission = true)
    }

    fun dismissPermission() {
        _state.value = _state.value.copy(showDialogPermission = false)
    }
}