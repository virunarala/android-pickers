package dev.virunarala.androidpickers.pickers.takepicture

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.model.TakePictureInput
import dev.virunarala.androidpickers.pickers.model.TakePictureOutput

class TakePictureLauncher {

    fun launch(activity: ComponentActivity,
               uri: Uri,
               onSuccess: (TakePictureOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val takePictureLauncher = activity.registerForActivityResult(
            TakePicture()
        ) { uri ->

        }

        takePictureLauncher.launch(
            TakePictureInput(
                uri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }

    fun launch(fragment: Fragment,
               uri: Uri,
               onSuccess: (TakePictureOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val takePictureLauncher = fragment.registerForActivityResult(
            TakePicture()
        ) { uri ->

        }

        takePictureLauncher.launch(
            TakePictureInput(
                uri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }
}