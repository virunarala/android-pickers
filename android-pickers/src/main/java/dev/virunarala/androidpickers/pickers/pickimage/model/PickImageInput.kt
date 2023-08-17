package dev.virunarala.androidpickers.pickers.pickimage.model

import androidx.activity.result.contract.ActivityResultContracts

data class PickImageInput(

    val mediaType: ActivityResultContracts.PickVisualMedia.VisualMediaType,

    val onSuccess: (PickImageOutput) -> Unit,

    val onFailure: (message: String) -> Unit
)