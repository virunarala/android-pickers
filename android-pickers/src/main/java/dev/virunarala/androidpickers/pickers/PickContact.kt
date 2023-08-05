package dev.virunarala.androidpickers.pickers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import androidx.activity.result.contract.ActivityResultContract
import dev.virunarala.androidpickers.pickers.model.PickContactInput

class PickContact: ActivityResultContract<PickContactInput, Uri?>() {

    private lateinit var onSuccess: (uri: Uri) -> Unit
    private lateinit var onFailure: (message: String) -> Unit

    override fun createIntent(context: Context, input: PickContactInput): Intent {
        onSuccess = input.onSuccess
        onFailure = input.onFailure

        return Intent(Intent.ACTION_PICK).setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        val uri = intent.takeIf { resultCode == Activity.RESULT_OK }?.run {
            data
        }

        if(uri==null) {
            onFailure("No Contact selected. Try again")
        } else {
            onSuccess(uri)
        }
        return uri
    }
}