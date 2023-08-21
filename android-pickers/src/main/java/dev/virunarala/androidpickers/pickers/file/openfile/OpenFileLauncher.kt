package dev.virunarala.androidpickers.pickers.file.openfile

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.DocumentsContract
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.file.openfile.model.OpenFileInput
import dev.virunarala.androidpickers.pickers.file.openfile.model.OpenFileOutput

class OpenFileLauncher {

    companion object {
        private const val TAG = "OpenFileLauncher"
    }

    fun launch(activity: ComponentActivity,
               mimeTypes: String,
               onSuccess: (OpenFileOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val openFileLauncher = activity.registerForActivityResult(
            OpenFile()
        ) { uri ->

        }

        val openFileInput = OpenFileInput(
            mimeTypes,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        Log.i(TAG,"Found Activities: ${getIntent(openFileInput).resolveActivity(activity.packageManager)}")
        val isResolvable = getIntent(openFileInput).resolveActivity(activity.packageManager) != null

        if(isResolvable) {
            openFileLauncher.launch(
                openFileInput
            )
        } else {
            onFailure("No apps found in your device to perform this action.")
        }

    }

    fun launch(fragment: Fragment,
               mimeTypes: String,
               onSuccess: (OpenFileOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val openFileLauncher = fragment.registerForActivityResult(
            OpenFile()
        ) { uri ->

        }

        val openFileInput = OpenFileInput(
            mimeTypes,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        val isResolvable = getIntent(openFileInput).resolveActivity(fragment.requireActivity().packageManager) != null

        if(isResolvable) {
            openFileLauncher.launch(
                openFileInput
            )
        } else {
            onFailure("No apps found in your device to perform this action.")
        }
    }

    private fun getIntent(input: OpenFileInput): Intent {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            .putExtra(Intent.EXTRA_MIME_TYPES, input.getMimeTypes())
            .setType("*/*")
        return intent
    }
}