package com.example.qrisapp.feature.main.ui

import android.Manifest
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrisapp.R
import com.example.qrisapp.core.design.helper.AnalyzerType
import com.example.qrisapp.core.design.theme.Color_199EFF
import com.example.qrisapp.core.design.theme.Color_9CA9B9
import com.example.qrisapp.core.design.theme.Color_D1ECFF
import com.example.qrisapp.core.design.theme.QRISTheme
import com.example.qrisapp.feature.camera.ui.CameraScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@Composable
fun HomeScreen() {
    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(color = Color_D1ECFF, shape = CircleShape),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Good day, User",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.titleSmall
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .background(color = Color_D1ECFF, shape = CircleShape)
                        .padding(12.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color_199EFF, RoundedCornerShape(5.dp))
                    .padding(top = 48.dp, bottom = 48.dp)
            ) {
                Text(
                    text = "Rp 2.000.000",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(modifier = Modifier.size(2.dp))
                Text(
                    text = "Total Balance",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Recent Transaction",
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleSmall
            )
//            HomeScreenContent(onClick)
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeScreenContent(
    onClick: (String) -> Unit
) {
    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    var analyzerType by remember { mutableStateOf(AnalyzerType.UNDEFINED) }

    if (cameraPermissionState.status.isGranted) {
        if (analyzerType == AnalyzerType.UNDEFINED) {
            Column {
                Button(onClick = { analyzerType = AnalyzerType.BARCODE }) {
                    Text(text = "BARCODE")
                }
                Button(onClick = { analyzerType = AnalyzerType.TEXT }) {
                    Text(text = "TEXT")
                }
            }
        } else {
            CameraScreen()
        }
    } else if (cameraPermissionState.status.shouldShowRationale) {
        Text("Camera Permission permanently denied")
    } else {
        SideEffect {
            cameraPermissionState.run { launchPermissionRequest() }
        }
        Text("No Camera Permission")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    QRISTheme {
        HomeScreenContent(
            onClick = {}
        )
    }
}
