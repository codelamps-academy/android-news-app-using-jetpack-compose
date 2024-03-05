package com.codelamps.newsapp.presentation.common

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


// MEMBUAT BUTTON, YANG ADA TEKS
@Composable
fun ButtonNews(
    modifier : Modifier = Modifier,
    text : String,
    onClick : () -> Unit
){

    Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White
    )) {
        Text(text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold))
    }

}