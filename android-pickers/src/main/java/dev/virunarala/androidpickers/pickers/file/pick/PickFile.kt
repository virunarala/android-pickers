package dev.virunarala.androidpickers.pickers.file.pick

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.DocumentsContract
import androidx.activity.result.contract.ActivityResultContract
import dev.virunarala.androidpickers.pickers.file.pick.model.PickFileInput
import dev.virunarala.androidpickers.pickers.file.pick.model.PickFileOutput

class PickFile: ActivityResultContract<PickFileInput, Uri?>() {

    private lateinit var onSuccess: (PickFileOutput) -> Unit
    private lateinit var onFailure: (message: String) -> Unit

    override fun createIntent(context: Context, input: PickFileInput): Intent {
        onSuccess = input.onSuccess
        onFailure = input.onFailure

        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = input.fileType
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                input.initialUri?.let {
                    putExtra(DocumentsContract.EXTRA_INITIAL_URI, it)
                }
            }
        }
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        val uri = intent.takeIf { resultCode == Activity.RESULT_OK }?.run {
            data
        }
        if(uri==null) {
            onFailure("Failed to open file. Check your permissions and try again")
        } else {
            onSuccess(PickFileOutput(uri))
        }

        return uri
    }
}