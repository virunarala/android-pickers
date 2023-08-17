package dev.virunarala.androidpickers.pickers.takepicture

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract
import dev.virunarala.androidpickers.pickers.takepicture.model.TakePictureInput
import dev.virunarala.androidpickers.pickers.takepicture.model.TakePictureOutput

class TakePicture: ActivityResultContract<TakePictureInput, Uri?>() {

    private var uri: Uri? = null
    private lateinit var onSuccess: (TakePictureOutput) -> Unit
    private lateinit var onFailure: (message: String) -> Unit

    override fun createIntent(context: Context, takePictureInput: TakePictureInput): Intent {
        uri = takePictureInput.uri
        onSuccess = takePictureInput.onSuccess
        onFailure = takePictureInput.onFailure

        return Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT,takePictureInput.uri)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {

        if(uri==null) {
            onFailure("Failed to capture image. Check Camera permissions")
        } else {
            onSuccess(TakePictureOutput(uri!!))
        }
        return uri
    }
}