package com.gmribas.modalpresentation.presentation.contactDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.gmribas.modalpresentation.R
import com.gmribas.modalpresentation.domain.Contact
import com.gmribas.modalpresentation.data.Mock
import org.koin.androidx.compose.getViewModel

@Composable
fun ContactDetailsScreen(navController: NavController, viewModel: ContactDetailsViewModel = getViewModel()) {
    val state = viewModel.state.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.contact_details_screen_name),
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                backgroundColor = MaterialTheme.colors.primaryVariant,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
            if (state.error == null) {
                state.contact?.let { contact ->
                    Column(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 36.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(state.contact.picture),
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

                        //computes  only once during composition and returns it during recomposition
                        val detailItems = remember {
                            listOf(
                                ContactDetailsItemDTO(
                                    text = contact.phoneNumber,
                                    image = Icons.Rounded.Phone
                                ),
                                ContactDetailsItemDTO(
                                    text = contact.email,
                                    image = Icons.Rounded.Email
                                ),
                                ContactDetailsItemDTO(
                                    text = contact.address,
                                    image = Icons.Rounded.Home
                                )
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(4.dp)
                        )
                        Card {
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 32.dp)
                            ) {
                                items(detailItems.size) { index ->
                                    val item = detailItems[index]
                                    ContactDetailsItem(
                                        text = item.text,
                                        image = item.image,
                                        description = item.description
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewContactDetailsScreen() {
    ContactDetailsScreen(rememberNavController())
}