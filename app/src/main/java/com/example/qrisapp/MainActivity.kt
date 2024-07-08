package com.example.qrisapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.qrisapp.navigation.QrisNavigation
import com.example.qrisapp.core.design.theme.QRISTheme
import dagger.hilt.android.AndroidEntryPoint
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinIsolatedContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRISTheme {
                val navController = rememberNavController()
                QrisNavigation(navController)
            }
        }
    }
}
