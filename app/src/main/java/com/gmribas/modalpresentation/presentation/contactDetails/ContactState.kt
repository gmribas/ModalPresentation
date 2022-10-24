package com.gmribas.modalpresentation.presentation.contactDetails

import com.gmribas.modalpresentation.domain.Contact

data class ContactState(
    val contact: Contact? = null,
    val loading: Boolean = false,
    val error: String? = null
)