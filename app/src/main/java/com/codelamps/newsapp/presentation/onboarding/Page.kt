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
        "Kenaikan suku bunga ini diambil sebagai respons terhadap ketidakpastian global yang meningkat. \"Rapat Dewan Gubernur Bank Indonesia pada tanggal 18 dan 19 Oktober 2023 memutuskan untuk menaikkan BI7DRRR sebesar 25 basis poin (bps) menjadi 6 persen,\" ujar Gubernur BI Perry Warjiyo dikutip dari Kompas.com, Kamis (19/10/2023).",
        R.drawable.onboarding1
    ),

    Page(title = "10 Wisata Yang Bagus di Indonesia", "Negara kita tercinta, Indonesia, memang memiliki alam yang sangat indah. Dari Sabang sampai Merauke, kita bisa dengan mudah menemukan tempat-tempat indah dan memukau.\n" +
            "\n" +
            "Sebagai penduduk asli Indonesia, kita sudah sepatutnya berbangga hati lho Toppers tinggal di negeri yang dikelilingi beribu – ribu pulau dengan keindahan yang tiada duanya.", R.drawable.onboarding2),

    Page(title = "10 Makanan Sehat untuk Ibu Hamil", "Konsumsi makanan sehat saat hamil sangat penting bagi Bunda dan Si Kecil. Semua ahli setuju bahwa konsumsi makanan bergizi bisa membantu tumbuh kembang bayi sejak dalam kandungan.\n" +
            "Sebenarnya, Bunda tak perlu bingung memilih makanan sehat apa yang harus dikonsumsi saat hamil. Ada banyak jenis makanan yang bergizi, bahkan dapat mencerdaskan anak sejak dalam kandungan.", R.drawable.onboarding3)
    )