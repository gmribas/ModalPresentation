package com.gmribas.modalpresentation.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.gmribas.modalpresentation.R
import com.gmribas.modalpresentation.data.ContactDTO
import com.gmribas.modalpresentation.data.Mock

@Composable
fun ContactDetailsScreen(contact: ContactDTO) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.contact_details_screen_name),
                        color = MaterialTheme.colors.onBackground
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(contact.picture),
                    contentDescription = contact.name,
                    modifier = Modifier.size(128.dp)
                )
                Spacer(modifier = Modifier.padding(bottom = 24.dp))
                Text(
                    text = contact.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier)
                Text(
                    text = contact.nickname,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                Row(Modifier.fillMaxSize(), horizontalArrangement = Alignment.Start) {
                    Image(
                        painter = rememberAsyncImagePainter(contact.picture),
                        contentDescription = contact.name,
                        modifier = Modifier.size(128.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewContactDetailsScreen() {
    ContactDetailsScreen(contact = Mock.contactList(max = 1).first())
}