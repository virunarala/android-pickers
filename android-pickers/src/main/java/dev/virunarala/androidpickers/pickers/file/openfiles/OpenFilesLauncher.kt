package dev.virunarala.androidpickers.pickers.file.openfiles

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.DocumentsContract
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.file.openfiles.model.OpenFilesInput
import dev.virunarala.androidpickers.pickers.file.openfiles.model.OpenFilesOutput

class OpenFilesLauncher {

    fun launch(activity: ComponentActivity,
               mimeTypes: Array<String>,
               initialUri: Uri?,
               onSuccess: (OpenFilesOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val openFilesLauncher = activity.registerForActivityResult(
            OpenFiles()
        ) { uri ->

        }

        val openFilesInput = OpenFilesInput(
            mimeTypes,
            initialUri,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        val isResolvable = getIntent(openFilesInput).resolveActivity(activity.packageManager) != null

        if(isResolvable) {
            openFilesLauncher.launch(
                openFilesInput
            )
        } else {
            onFailure("No apps found in your device to perform this action.")
        }

    }

    fun launch(fragment: Fragment,
               mimeTypes: Array<String>,
               initialUri: Uri?,
               onSuccess: (OpenFilesOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val openFilesLauncher = fragment.registerForActivityResult(
            OpenFiles()
        ) { uri ->

        }

        val openFilesInput = OpenFilesInput(
            mimeTypes,
            initialUri,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        val isResolvable = getIntent(openFilesInput).resolveActivity(fragment.requireActivity().packageManager) != null

        if(isResolvable) {
            openFilesLauncher.launch(
                openFilesInput
            )
        } else {
            onFailure("No apps found in your device to perform this action.")
        }
    }

    fun getIntent(openFilesInput: OpenFilesInput): Intent {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            putExtra(Intent.EXTRA_MIME_TYPES,openFilesInput.mimeTypes)
            putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                openFilesInput.initialUri?.let {
                    putExtra(DocumentsContract.EXTRA_INITIAL_URI, it)
                }
            }
        }

        return intent
    }
}