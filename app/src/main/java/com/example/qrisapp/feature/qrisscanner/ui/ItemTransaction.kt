package com.example.qrisapp.feature.qrisscanner.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.qrisapp.R
import com.example.qrisapp.core.design.theme.Color_199EFF
import com.example.qrisapp.core.design.theme.Color_757F90
import com.example.qrisapp.core.design.theme.Color_ED0226
import com.example.qrisapp.core.design.theme.Color_FFFFFF
import com.example.qrisapp.core.design.theme.QRISTheme

@Composable
fun ItemTransaction(type: String = "Income") {
    val textColor = if (type == "Income".uppercase()) Color_199EFF else Color_ED0226
    val text = if (type == "Income".uppercase()) "+Rp 19.000" else "-Rp 19.000"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color_FFFFFF, RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_avatar),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "User",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "22 April 2023",
                modifier = Modifier.fillMaxWidth(),
                color = Color_757F90,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Column(horizontalAlignment = Alignment.End){
            Text(
                text = text,
                color = textColor,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "03:23 PM",
                color = Color_757F90,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemTransactionList() {
    QRISTheme {
        ItemTransaction()
    }
}