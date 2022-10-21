package com.gmribas.modalpresentation.presentation.contactDetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactDetailsItem(modifier: Modifier = Modifier, text: String, image: ImageVector, description: String?) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 8.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            image,
            contentDescription = description,
            tint = MaterialTheme.colors.primaryVariant
        )
        Spacer(modifier = Modifier.padding(end = 16.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Light,
            fontSize = 18.sp,
            color = MaterialTheme.colors.onBackground,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Composable
@Preview
fun PreviewContactDetailsItem() {
    ContactDetailsItem(text = "text", image = Icons.Rounded.AccountBox, description = "")
}