package com.gmribas.modalpresentation.presentation.contactList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gmribas.modalpresentation.R
import com.gmribas.modalpresentation.presentation.navigation.Screens
import org.koin.androidx.compose.getViewModel

@Composable
fun ContactListScreen(navController: NavHostController, viewModel: ContactListViewModel = getViewModel()) {
    val state = viewModel.state.value

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
        if (state.loading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(modifier = Modifier
                    .width(36.dp)
                    .height(36.dp)
                    .fillMaxSize())
            }
        }
        LazyColumn {
            items(state.contactList.size) { index ->
                ContactItem(contact = state.contactList[index]) { clickedContact ->
                    navController.navigate(Screens.ContactDetails.route)
                }

                if (index < state.contactList.size) {
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
    ContactListScreen(navController = rememberNavController())
}