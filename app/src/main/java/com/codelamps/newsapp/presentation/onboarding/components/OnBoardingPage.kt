package com.codelamps.newsapp.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.codelamps.newsapp.R
import com.codelamps.newsapp.presentation.Dimens
import com.codelamps.newsapp.presentation.onboarding.Page
import com.codelamps.newsapp.presentation.onboarding.pages
import com.codelamps.newsapp.ui.theme.NewsAppTheme


// THIRD : KUMPULKAN PAGE DI SATU TEMPAT, MEMBENTUK TAMPILAN YANG KITA INGINKAN
@Composable
fun OnBoardingPage(
    page: Page,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier
    ) {

        // UNTUK GAMBAR DI ONBOARDING
        Image(
            painter = painterResource(id = page.image), contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            contentScale = ContentScale.Crop
        ) // 0.6f itu sama dengan 60% tinggi
        
        Spacer(modifier = Modifier.height(Dimens.dp24))

        // UNTUK TITLE ONBOARDING
        Text(text = page.title,
            modifier = Modifier
                .padding(horizontal = Dimens.dp30),
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )

        // UNTUK DESCRIPTION ONBOARDING
        Text(text = page.description,
            modifier = Modifier
                .padding(horizontal = Dimens.dp30),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}


// UNTUK MELIHAT TAMPILAN ONBOARDING PREVIEW
@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun OnBoardingPagePreview(){
    NewsAppTheme {
        OnBoardingPage(page = pages[0])
    }
}