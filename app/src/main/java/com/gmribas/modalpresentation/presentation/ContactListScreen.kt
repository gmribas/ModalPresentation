package com.gmribas.modalpresentation.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gmribas.modalpresentation.R
import com.gmribas.modalpresentation.domain.Contact
import com.gmribas.modalpresentation.data.Mock

@Composable
fun ContactListScreen(contacts: List<Contact>) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.contact_list_screen_name),
                        color = MaterialTheme.colors.onBackground
                    )
                },
                backgroundColor = MaterialTheme.colors.primaryVariant
            )
        }
    ) {
        LazyColumn {
            items(contacts.size) { index ->
                ContactItem(contact = contacts[index]) { clickedContact ->

                }

                if (index < contacts.size) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .background(Color.Gray)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewContactListScreen() {
    ContactListScreen(contacts = Mock.contactList(max = 10))
}