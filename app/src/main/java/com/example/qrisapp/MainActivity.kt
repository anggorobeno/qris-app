package com.example.qrisapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.qrisapp.di.FeatureModules
import com.example.qrisapp.navigation.QrisNavigation
import com.example.qrisapp.core.design.theme.QRISTheme
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinIsolatedContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRISTheme {
                val navController = rememberNavController()

                FeatureModules.IsolatedKoinContext.koinApp.androidContext(this@MainActivity)
                KoinIsolatedContext(context = FeatureModules.IsolatedKoinContext.koinApp) {
                    QrisNavigation(navController)
                }
            }
        }
    }
}
