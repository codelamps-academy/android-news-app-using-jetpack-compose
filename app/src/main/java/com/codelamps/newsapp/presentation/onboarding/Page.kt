package com.codelamps.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.codelamps.newsapp.R

// FIRST : ADD PAGE WHAT WE WANT TO SHOW IN ONBOARDING, TITLE, DESCRIPTION, AND IMAGE
data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


// SECOND : ADD DATA TO PAGE
val pages = listOf<Page>(
    Page(
        "Suku Bunga Bank Indonesia Meningkat",
        "Kenaikan suku bunga ini diambil sebagai respons terhadap ketidakpastian global yang meningkat.",
        R.drawable.onboarding1
    ),

    Page(title = "10 Wisata Yang Bagus di Indonesia", "Negara kita tercinta, Indonesia, memang memiliki alam yang sangat indah. Dari Sabang sampai Merauke, kita bisa dengan mudah menemukan tempat-tempat indah dan memukau.\n", R.drawable.onboarding2),

    Page(title = "10 Makanan Sehat untuk Ibu Hamil", "Konsumsi makanan sehat saat hamil sangat penting bagi Bunda dan Si Kecil." +
            "Sebenarnya, Bunda tak perlu bingung memilih makanan sehat apa yang harus dikonsumsi saat hamil.", R.drawable.onboarding3)
    )