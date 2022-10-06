package com.gmribas.modalpresentation.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.gmribas.modalpresentation.data.ContactDTO
import com.gmribas.modalpresentation.data.Mock

@Composable
fun ContactItem(contact: ContactDTO, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background)
            .then(modifier)
    ) {
        Row(
            modifier = Modifier.height(128.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = rememberAsyncImagePainter(contact.picture),
                    contentDescription = contact.name,
                    modifier = Modifier.size(64.dp)
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = contact.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = contact.nickname,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewContactItem() {
    ContactItem(contact = Mock.contact())
}

@Preview
@Composable
fun PreviewContactItem2() {
    ContactItem(contact = Mock.contact(), modifier = Modifier.background(Color.Red))
}