package dev.virunarala.androidpickers.pickers.model

import android.net.Uri

data class PickContactInput(
    val onSuccess: (Uri) -> Unit,

    val onFailure: (message: String) -> Unit
)
