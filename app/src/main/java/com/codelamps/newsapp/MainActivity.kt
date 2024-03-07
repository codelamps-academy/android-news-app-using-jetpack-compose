package com.codelamps.newsapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.codelamps.newsapp.domain.usecase.AppEntryUseCases
import com.codelamps.newsapp.presentation.onboarding.OnBoardingScreen
import com.codelamps.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUseCases : AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // MENGGUNAKAN SELURUH LAYAR UNTUK APLIKASI
//        WindowCompat.setDecorFitsSystemWindows(window, false)

        // UNTUK MENAMPILKAN SPLASH SCREEN
        installSplashScreen().setOnExitAnimationListener { splashScreenView ->
            // Tambahkan durasi splash screen
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

                // Pastikan splash screen diakhiri setelah durasi tertentu
                splashScreenView.remove()
            }, 4000) // 5000 milidetik = 5 detik
        }

        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect(){
                Log.d("Test", it.toString())
            }
        }

        setContent {
            NewsAppTheme {
                OnBoardingScreen()
            }
        }
    }
}