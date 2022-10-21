package com.gmribas.modalpresentation.di

import com.gmribas.modalpresentation.presentation.contactDetails.ContactDetailsViewModel
import com.gmribas.modalpresentation.presentation.contactList.ContactListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::ContactListViewModel)
    viewModelOf(::ContactDetailsViewModel)
}