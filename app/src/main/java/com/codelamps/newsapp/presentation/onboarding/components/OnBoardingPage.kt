package com.codelamps.newsapp.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.codelamps.newsapp.presentation.onboarding.Page


// THIRD : KUMPULKAN PAGE DI SATU TEMPAT, MEMBENTUK TAMPILAN YANG KITA INGINKAN
@Composable
fun OnBoardingPage(
    page : Page,
    modifier : Modifier = Modifier
){

    Column(
        modifier = Modifier
    ) {
        Image(painter = painterResource(id = page.image), contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0))
    }
}