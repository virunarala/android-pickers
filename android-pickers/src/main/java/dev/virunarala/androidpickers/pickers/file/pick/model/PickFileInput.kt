package dev.virunarala.androidpickers.pickers.file.pick.model

import android.net.Uri

data class PickFileInput(
    val fileType: String = "*/*",
    val initialUri: Uri? = null,
    val onSuccess: (PickFileOutput) -> Unit,
    val onFailure: (message: String) -> Unit
)
