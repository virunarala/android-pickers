package dev.virunarala.androidpickers.pickers.file.getfiles

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.file.getfiles.model.GetFilesInput
import dev.virunarala.androidpickers.pickers.file.getfiles.model.GetFilesOutput

class GetFilesLauncher {

    companion object {
        private const val TAG = "GetFilesLauncher"
    }

    fun launch(activity: ComponentActivity,
               mimeType: String,
               initialUri: Uri?,
               onSuccess: (GetFilesOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val getFilesLauncher = activity.registerForActivityResult(
            GetFiles()
        ) { uri ->

        }

        val getFilesInput = GetFilesInput(
            mimeType,
            initialUri,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        Log.i(TAG,"Found Activities: ${getIntent(getFilesInput).resolveActivity(activity.packageManager)}")
        val isResolvable = getIntent(getFilesInput).resolveActivity(activity.packageManager) != null

        if(isResolvable) {
            getFilesLauncher.launch(
                getFilesInput
            )
        } else {
            onFailure("No apps found in your device to perform this action.")
        }


    }

    fun launch(fragment: Fragment,
               mimeType: String,
               initialUri: Uri?,
               onSuccess: (GetFilesOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val getFilesLauncher = fragment.registerForActivityResult(
            GetFiles()
        ) { uri ->

        }

        val getFilesInput = GetFilesInput(
            mimeType,
            initialUri,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        Log.i(TAG,"Found Activities: ${getIntent(getFilesInput).resolveActivity(fragment.requireActivity().packageManager)}")
        val isResolvable = getIntent(getFilesInput).resolveActivity(fragment.requireActivity().packageManager) != null

        if(isResolvable) {
            getFilesLauncher.launch(
                getFilesInput
            )
        } else {
            onFailure("No apps found in your device to perform this action.")
        }

        getFilesLauncher.launch(
            GetFilesInput(
                mimeType,
                initialUri,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        )
    }

    private fun getIntent(input: GetFilesInput): Intent {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = input.fileType
        }
        return intent
    }
}