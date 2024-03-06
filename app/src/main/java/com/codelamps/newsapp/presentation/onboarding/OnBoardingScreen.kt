package com.codelamps.newsapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.codelamps.newsapp.presentation.Dimens
import com.codelamps.newsapp.presentation.common.ButtonNews
import com.codelamps.newsapp.presentation.common.TextButtonNews
import com.codelamps.newsapp.presentation.onboarding.components.OnBoardingPage
import com.codelamps.newsapp.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        // SET PAGER SELALU KE HALAMAN 1
        val pagerState = rememberPagerState(initialPage = 0) { pages.size }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        // HORIZONTAL PAGER, DIGUNAKAN UNTUK PAGER KE SAMPING
        /**
         * - **`pageCount: Int`**: Menentukan jumlah total halaman yang akan ditampilkan di dalam **`HorizontalPager`**.
         * - **`modifier: Modifier`**: Modifier yang dapat digunakan untuk mengonfigurasi properti seperti ukuran, warna, atau margin pada **`HorizontalPager`**.
         * - **`state: PagerState`**: Menyimpan informasi tentang keadaan dan posisi saat ini dari **`HorizontalPager`**. Ini mencakup indeks halaman saat ini, posisi geser saat ini, dan informasi lainnya.
         * - **`contentPadding: PaddingValues`**: Menentukan jarak antara tepi **`HorizontalPager`** dan kontennya.
         * - **`pageSize: PageSize`**: Menentukan ukuran halaman, baik dalam piksel atau persentase dari lebar **`HorizontalPager`**.
         * - **`beyondBoundsPageCount: Int`**: Menentukan jumlah halaman tambahan di luar batas yang seharusnya terlihat. Ini dapat membantu dalam mempersiapkan halaman yang akan dipersiapkan sebelumnya atau sesudahnya untuk mempercepat pengalaman geser.
         * - **`pageSpacing: Dp`**: Menentukan jarak antara halaman.
         * - **`verticalAlignment: Alignment.Vertical`**: Menentukan cara halaman di-vertikal-kan di dalam **`HorizontalPager`**.
         * - **`flingBehavior: SnapFlingBehavior`**: Menentukan perilaku "fling" saat pengguna menggeser halaman. Misalnya, **`PagerDefaults.defaultPagerFlingConfig()`** dapat digunakan untuk mengaktifkan "snap" ke halaman terdekat.
         * - **`userScrollEnabled: Boolean`**: Menentukan apakah pengguna diizinkan untuk menggeser halaman. Jika diatur ke **`false`**, pengguna tidak dapat menggeser halaman secara manual.
         * - **`reverseLayout: Boolean`**: Jika diatur ke **`true`**, halaman akan ditampilkan secara terbalik, dengan halaman terakhir ditampilkan di bagian kiri.
         * - **`key: ((Int) -> Any)?`**: Sebuah fungsi yang memberikan kunci untuk mewakili item pada posisi tertentu. Ini digunakan oleh Compose untuk mengidentifikasi item secara unik.
         * - **`pageNestedScrollConnection: NestedScrollConnection`**: Koneksi untuk mengaktifkan nested scrolling di dalam halaman.
         * - **`pageContent: @Composable (Int) -> Unit`**: Blok komposisi yang menerima indeks halaman sebagai parameter dan membangun tampilan untuk halaman tersebut.
         */
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }

        // VERTICAL PAGER, DIGUNAKAN UNTUK PAGER KE BAWAH
//        VerticalPager(pageCount = pages.size, state = pagerState) { index ->
//            OnBoardingPage(page = pages[index])
//        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.dp30)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            PageIndicator(
                pageSize = pages.size,
                selectedPage = pagerState.currentPage,
                modifier = Modifier.width(Dimens.dp52),
                selectedColor = Color.Black,
                unselectedColor = Color.Gray
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                val scope = rememberCoroutineScope()

                if (buttonState.value[0].isNotEmpty()) {
                    TextButtonNews(text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                            }
                        }
                    )
                }

                ButtonNews(
                    text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 3) {
                                // TODO : Navigate to Home Screen
                            } else {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                )
            }
            
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}


