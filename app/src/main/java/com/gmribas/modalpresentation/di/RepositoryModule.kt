package com.gmribas.modalpresentation.di

import com.gmribas.modalpresentation.data.repository.ContactRepositoryImpl
import com.gmribas.modalpresentation.domain.repository.ContactRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<ContactRepository> {
        ContactRepositoryImpl()
    }
}