package com.codelamps.newsapp.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.codelamps.newsapp.presentation.Dimens

@Composable
fun PageIndicator(
    modifier : Modifier = Modifier,
    pageSize : Int,
    selectedPage : Int,
    selectedColor : Color = MaterialTheme.colorScheme.primary,
    unselectedColor : Color = Color.Gray
){

    Row (modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween){
        repeat(pageSize){page ->
            Box(modifier = Modifier.size(Dimens.dp14).clip(CircleShape)
                .background(color = if (page == selectedPage) selectedColor else unselectedColor))
            
        }
    }
}