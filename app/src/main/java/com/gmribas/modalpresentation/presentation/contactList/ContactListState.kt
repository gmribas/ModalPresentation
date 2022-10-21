package com.gmribas.modalpresentation.presentation.contactList

import com.gmribas.modalpresentation.data.ContactDTO

data class ContactListState(
    val contactList: List<ContactDTO> = emptyList()
)