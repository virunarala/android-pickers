package dev.virunarala.androidpickers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import dev.virunarala.androidpickers.pickers.pickimage.PickImageLauncher
import dev.virunarala.androidpickers.pickers.takepicture.TakePictureLauncher
import dev.virunarala.androidpickers.utils.FileExtensions
import dev.virunarala.androidpickers.utils.createInternalFile

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)

        /** Pick Image Sample */
        PickImageLauncher().launch(
            this@MainActivity,
            ActivityResultContracts.PickVisualMedia.ImageOnly,
            onSuccess = { pickImageOutput ->
                imageView.setImageURI(pickImageOutput.uri)
            },
            onFailure = { errorMessage ->
                Log.e(TAG,errorMessage)
            })


        /** Take Picture Sample */

//        val capturedImgFile = createInternalFile(this@MainActivity,FileExtensions.JPG.extension)
//        val uri = FileProvider.getUriForFile(applicationContext,"$packageName.provider",capturedImgFile)
//        TakePictureLauncher().launch(
//            this@MainActivity,
//            uri,
//            onSuccess = { pickImageOutput ->
//                imageView.setImageURI(pickImageOutput.uri)
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )
    }
}