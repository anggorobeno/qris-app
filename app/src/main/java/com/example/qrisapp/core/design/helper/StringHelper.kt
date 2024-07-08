package com.example.qrisapp.core.design.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun String.getString(resource: Int) = this.ifEmpty { stringResource(resource) }