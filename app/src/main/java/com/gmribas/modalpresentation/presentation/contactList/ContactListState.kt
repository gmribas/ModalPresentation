package com.gmribas.modalpresentation.presentation.contactList

import com.gmribas.modalpresentation.domain.Contact

data class ContactListState(
    val contactList: List<Contact> = emptyList(),
    val loading: Boolean = false
)