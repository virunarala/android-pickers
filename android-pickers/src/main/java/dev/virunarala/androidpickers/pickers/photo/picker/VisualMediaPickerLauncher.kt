package dev.virunarala.androidpickers.pickers.photo.picker

import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.photo.picker.model.VisualMediaPickerInput
import dev.virunarala.androidpickers.pickers.photo.picker.model.VisualMediaPickerOutput

class VisualMediaPickerLauncher {

    fun launch(activity: ComponentActivity,
               mediaType: ActivityResultContracts.PickVisualMedia.VisualMediaType,
               onSuccess: (VisualMediaPickerOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val visualMediaPickerLauncher = activity.registerForActivityResult(
            VisualMediaPicker()
        ) { uri ->

        }

        visualMediaPickerLauncher.launch(
            VisualMediaPickerInput(
                mediaType,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }

    fun launch(fragment: Fragment,
               mediaType: ActivityResultContracts.PickVisualMedia.VisualMediaType,
               onSuccess: (VisualMediaPickerOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val visualMediaPickerLauncher = fragment.registerForActivityResult(
            VisualMediaPicker()
        ) { uri ->

        }

        visualMediaPickerLauncher.launch(
            VisualMediaPickerInput(
                mediaType,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }
}