package dev.virunarala.androidpickers.pickers.photo.capture

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.photo.capture.model.PhotoCaptureInput
import dev.virunarala.androidpickers.pickers.photo.capture.model.PhotoCaptureOutput

class PhotoCaptureLauncher {

    fun launch(activity: ComponentActivity,
               uri: Uri,
               onSuccess: (PhotoCaptureOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val photoCaptureLauncher = activity.registerForActivityResult(
            PhotoCapture()
        ) { uri ->

        }

        photoCaptureLauncher.launch(
            PhotoCaptureInput(
                uri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }

    fun launch(fragment: Fragment,
               uri: Uri,
               onSuccess: (PhotoCaptureOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val photoCaptureLauncher = fragment.registerForActivityResult(
            PhotoCapture()
        ) { uri ->

        }

        photoCaptureLauncher.launch(
            PhotoCaptureInput(
                uri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }
}