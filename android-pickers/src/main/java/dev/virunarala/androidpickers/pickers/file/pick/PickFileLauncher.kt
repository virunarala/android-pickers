package dev.virunarala.androidpickers.pickers.file.pick

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.file.pick.model.PickFileInput
import dev.virunarala.androidpickers.pickers.file.pick.model.PickFileOutput

class PickFileLauncher {

    fun launch(activity: ComponentActivity,
               mimeType: String,
               initialUri: Uri?,
               onSuccess: (PickFileOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val pickFileLauncher = activity.registerForActivityResult(
            PickFile()
        ) { uri ->

        }

        pickFileLauncher.launch(
            PickFileInput(
                mimeType,
                initialUri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }

    fun launch(fragment: Fragment,
               mimeType: String,
               initialUri: Uri?,
               onSuccess: (PickFileOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val pickFileLauncher = fragment.registerForActivityResult(
            PickFile()
        ) { uri ->

        }

        pickFileLauncher.launch(
            PickFileInput(
                mimeType,
                initialUri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }
}