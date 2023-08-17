package dev.virunarala.androidpickers.pickers.takepicture.model

import android.net.Uri

data class TakePictureInput(

    val uri: Uri,

    val onSuccess: (TakePictureOutput) -> Unit,

    val onFailure: (message: String) -> Unit
)