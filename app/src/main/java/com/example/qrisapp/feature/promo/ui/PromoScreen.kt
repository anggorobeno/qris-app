package com.example.qrisapp.feature.promo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.qrisapp.R
import com.example.qrisapp.core.design.theme.Color_ED0226
import com.example.qrisapp.core.design.theme.QRISTheme
import com.example.qrisapp.core.network.util.Resource
import com.example.qrisapp.feature.promo.PromoViewModel
import com.example.qrisapp.feature.promo.data.response.PromoResponse

@Preview(showBackground = true)
@Composable
fun PromoScreen(
    viewModel: PromoViewModel = hiltViewModel(),
) {
    QRISTheme {
        Column(
            modifier = Modifier
                .padding(vertical = 18.dp, horizontal = 44.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            viewModel.getPromos.collectAsState().value.let { resp ->
                when (resp) {
                    is Resource.Loading -> {
                        LoadingSection()
                    }

                    is Resource.Success -> {
                        PromoSection(data = resp.data)
                    }

                    is Resource.Error -> {
                        ErrorSection(
                            tryAgain = { viewModel.getPromos() }
                        )
                    }

                    else -> {
                        LoadingSection()
                    }
                }
            }
        }
    }
}

@Composable
fun PromoSection(
    modifier: Modifier = Modifier,
    data: List<PromoResponse>
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(data) { value ->
                Box(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterStart),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Spacer(modifier = Modifier.padding(8.dp))
                            Text(
                                text = value.nama.orEmpty(),
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.padding(4.dp))
                            Text(
                                text = value.desc.orEmpty(),
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 2,
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            HorizontalDivider()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = Color_ED0226,
        )
    }
}

@Composable
fun ErrorSection(
    modifier: Modifier = Modifier,
    tryAgain: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.error),
            color = Color_ED0226,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Button(
            onClick = {
                tryAgain.invoke()
            },
            modifier = Modifier
                .height(36.dp)
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF1614B))
        ) {
            Text(
                text = stringResource(R.string.try_again),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}