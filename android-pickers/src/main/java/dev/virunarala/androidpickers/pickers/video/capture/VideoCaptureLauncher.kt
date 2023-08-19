package dev.virunarala.androidpickers.pickers.video.capture

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.photo.capture.model.PhotoCaptureInput
import dev.virunarala.androidpickers.pickers.photo.capture.model.PhotoCaptureOutput
import dev.virunarala.androidpickers.pickers.video.capture.model.VideoCaptureInput
import dev.virunarala.androidpickers.pickers.video.capture.model.VideoCaptureOutput

class VideoCaptureLauncher {

    fun launch(activity: ComponentActivity,
               uri: Uri,
               onSuccess: (VideoCaptureOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val videoCaptureLauncher = activity.registerForActivityResult(
            VideoCapture()
        ) { uri ->

        }

        videoCaptureLauncher.launch(
            VideoCaptureInput(
                uri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }

    fun launch(fragment: Fragment,
               uri: Uri,
               onSuccess: (VideoCaptureOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val videoCaptureLauncher = fragment.registerForActivityResult(
            VideoCapture()
        ) { uri ->

        }

        videoCaptureLauncher.launch(
            VideoCaptureInput(
                uri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }
}