package dev.virunarala.androidpickers.pickers.file.getfile

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.file.getfile.model.GetFileInput
import dev.virunarala.androidpickers.pickers.file.getfile.model.GetFileOutput

class GetFileLauncher {

    companion object {
        private const val TAG = "GetFilesLauncher"
    }

    fun launch(activity: ComponentActivity,
               mimeType: String,
               initialUri: Uri?,
               onSuccess: (GetFileOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val getFileLauncher = activity.registerForActivityResult(
            GetFile()
        ) { uri ->

        }

        val getFileInput = GetFileInput(
            mimeType,
            initialUri,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        Log.i(TAG,"Found Activities: ${getIntent(getFileInput).resolveActivity(activity.packageManager)}")
        val isResolvable = getIntent(getFileInput).resolveActivity(activity.packageManager) != null

        if(isResolvable) {
            getFileLauncher.launch(
                getFileInput
            )
        } else {
            onFailure("No apps found in your device to perform this action.")
        }


    }

    fun launch(fragment: Fragment,
               mimeType: String,
               initialUri: Uri?,
               onSuccess: (GetFileOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val getFilesLauncher = fragment.registerForActivityResult(
            GetFile()
        ) { uri ->

        }

        val getFileInput = GetFileInput(
            mimeType,
            initialUri,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        Log.i(TAG,"Found Activities: ${getIntent(getFileInput).resolveActivity(fragment.requireActivity().packageManager)}")
        val isResolvable = getIntent(getFileInput).resolveActivity(fragment.requireActivity().packageManager) != null

        if(isResolvable) {
            getFilesLauncher.launch(
                getFileInput
            )
        } else {
            onFailure("No apps found in your device to perform this action.")
        }

        getFilesLauncher.launch(
            GetFileInput(
                mimeType,
                initialUri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }

    private fun getIntent(input: GetFileInput): Intent {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = input.fileType
        }
        return intent
    }
}