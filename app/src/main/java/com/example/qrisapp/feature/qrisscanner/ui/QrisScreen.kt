package com.example.qrisapp.feature.qrisscanner.ui

import android.Manifest
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.qrisapp.R
import com.example.qrisapp.core.design.theme.Color_199EFF
import com.example.qrisapp.core.design.theme.Color_D1ECFF
import com.example.qrisapp.core.design.theme.Color_F2F3F3
import com.example.qrisapp.feature.qrisscanner.QrisViewModel
import com.example.qrisapp.feature.qrisscanner.data.model.ScannerModel
import com.example.qrisapp.navigation.CAMERA_SCREEN
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun QrisScreen(
    qrisViewModel: QrisViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    qrisViewModel.setBalance(5000000L)
    val state by qrisViewModel.state.collectAsStateWithLifecycle()
    QrisContent(qrisViewModel, state) {
        qrisViewModel.startScanning()
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun QrisContent(
    qrisViewModel: QrisViewModel,
    result: ScannerModel,
    onClick: (String) -> Unit
) {
    val userBalance by qrisViewModel.userBalance.collectAsState()
    var showSheet by remember { mutableStateOf(false) }
    var bankSender by remember {
        mutableStateOf("")
    }
    bankSender = result.bankSender
    if (showSheet) {
        BottomSheetPaymentInformation(result) {
            showSheet = false
        }
    }
    LaunchedEffect(bankSender) {
        if (bankSender.isNotBlank()) {
            showSheet = true
            qrisViewModel.setBalance(userBalance - result.transactionAmount.toLong())
        }
    }

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
                    text = "Rp $userBalance",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(modifier = Modifier.size(2.dp))
                Text(
                    text = stringResource(id = R.string.total_balance),
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Features",
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                val cameraPermission = rememberPermissionState(Manifest.permission.CAMERA)
                Row(
                    modifier = Modifier
                        .background(Color_F2F3F3, RoundedCornerShape(5.dp))
                        .padding(12.dp)
                        .clickable {
                            requestCameraPermission(permissionState = cameraPermission) {
                                onClick(it)
                            }
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_pay),
                        contentDescription = null,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Pay",
                        modifier = Modifier,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Recent Transaction",
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            ItemTransaction("INCOME")
            ItemTransaction("EXPENSE")
            ItemTransaction("EXPENSE")
            ItemTransaction("INCOME")
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
fun requestCameraPermission(permissionState: PermissionState, onClick: (String) -> Unit) {
    if (permissionState.status.isGranted) {
        onClick(CAMERA_SCREEN)
    } else {
        permissionState.run { launchPermissionRequest() }
    }
}

