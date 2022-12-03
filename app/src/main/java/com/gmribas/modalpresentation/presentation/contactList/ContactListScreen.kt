package com.gmribas.modalpresentation.presentation.contactList

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gmribas.modalpresentation.R
import com.gmribas.modalpresentation.presentation.navigation.Screens
import com.google.accompanist.permissions.*
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ContactListScreen(
    navController: NavHostController,
    viewModel: ContactListViewModel = getViewModel()
) {
    val state = viewModel.state.value

    val readContactsPermissionState = rememberPermissionState(
        android.Manifest.permission.READ_CONTACTS
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.contact_list_screen_name),
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                backgroundColor = MaterialTheme.colors.primaryVariant
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.askForPermissionIfNeeded()
                }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
        }
    ) {
        if (state.loading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(36.dp)
                        .height(36.dp)
                        .fillMaxSize()
                )
            }
        }
        if (state.showDialogPermission) {
            if (readContactsPermissionState.status.isGranted) {
                Toast.makeText(
                    LocalContext.current,
                    stringResource(id = R.string.contact_list_screen_permission_granted_title),
                    Toast.LENGTH_LONG
                )
                    .show()
            } else {
                DialogPermission(
                    viewModel = viewModel,
                    state = readContactsPermissionState,
                    rationale = readContactsPermissionState.status.shouldShowRationale
                )
            }
        }

        LazyColumn {
            items(state.contactList.size) { index ->
                ContactItem(contact = state.contactList[index]) { clickedContact ->
                    navController.navigate(Screens.ContactDetails.route + "/${clickedContact.id}")
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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun DialogPermission(
    viewModel: ContactListViewModel,
    state: PermissionState,
    rationale: Boolean
) {
    val title = if (rationale) {
        stringResource(id = R.string.contact_list_screen_first_time_permission_title)
    } else {
        stringResource(id = R.string.contact_list_screen_rationale_permission_title)
    }

    AlertDialog(
        title = { Text(text = title) },
        onDismissRequest = { viewModel.dismissPermission() },
        confirmButton = {
            Button(onClick = {
                state.launchPermissionRequest()
                viewModel.dismissPermission()
            }) {
                Text(text = stringResource(id = R.string.ok))
            }
        }
    )
}

@Preview
@Composable
fun PreviewContactListScreen() {
    ContactListScreen(navController = rememberNavController())
}