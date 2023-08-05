package dev.virunarala.androidpickers.pickers.pickimage

import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.model.PickImageInput
import dev.virunarala.androidpickers.pickers.model.PickImageOutput


class PickImageLauncher {

    fun launch(activity: ComponentActivity,
               mediaType: ActivityResultContracts.PickVisualMedia.VisualMediaType,
               onSuccess: (PickImageOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val pickImageLauncher = activity.registerForActivityResult(
            PickImage()
        ) { uri ->

        }

        pickImageLauncher.launch(
            PickImageInput(
                mediaType,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }

    fun launch(fragment: Fragment,
               mediaType: ActivityResultContracts.PickVisualMedia.VisualMediaType,
               onSuccess: (PickImageOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val pickImageLauncher = fragment.registerForActivityResult(
            PickImage()
        ) { uri ->

        }

        pickImageLauncher.launch(
            PickImageInput(
                mediaType,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }
}



