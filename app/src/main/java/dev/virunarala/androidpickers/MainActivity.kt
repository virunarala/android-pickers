package dev.virunarala.androidpickers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    val documentPick = registerForActivityResult(ActivityResultContracts.OpenDocument()) { result ->
        // do something
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)

        /** Photo Picker Sample */
//        PickImageLauncher().launch(
//            this@MainActivity,
//            ActivityResultContracts.PickVisualMedia.ImageOnly,
//            onSuccess = { pickImageOutput ->
//                imageView.setImageURI(pickImageOutput.uri)
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            })


        /** Photo Capture Sample */
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

        /** Get File Sample */
//        GetFileLauncher().launch(
//            activity = this@MainActivity,
//            "audio/flac",
//            null,
//            onSuccess = { getFileOutput ->
//                Log.i(TAG,"Picked File URI: ${getFileOutput.uri}")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )

        /** Get Files Sample */
//        GetFilesLauncher().launch(
//            activity = this@MainActivity,
//            "audio/flac",
//            null,
//            onSuccess = { getFilesOutput ->
//                Log.i(TAG,"Picked File URI: ${getFilesOutput.uris}")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )


        /** Open Single File(Document) Sample */
//        OpenFileLauncher().launch(
//            activity = this@MainActivity,
//            "application/pdf;text/plain;audio/flac",
//            onSuccess = { openFileOutput ->
//                Log.i(TAG,"Picked File URI: ${openFileOutput.uri}")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )

        /** Open Multiple Files(Documents) Sample */
//        OpenFilesLauncher().launch(
//            activity = this@MainActivity,
//            arrayOf("application/pdf"),
//            null,
//            onSuccess = { openFilesOutput ->
//                Log.i(TAG,"Picked File URI: ${openFilesOutput.uris}")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )

        /** Request Permissions */
//        RequestPermissionsLauncher()
//            .launch(
//                this@MainActivity,
//                arrayOf("android.permission.CAMERA","android.permission.ACCESS_COARSE_LOCATION"),
//                onSuccess = {
//                    Log.i(TAG,"Success")
//                },
//                onFailure = { errorMessage ->
//                    Log.e(TAG,errorMessage)
//                }
//            )

        /** Video Capture Sample */
//        val capturedVideoFile = createInternalFile(this@MainActivity, FileExtensions.MP4.extension)
//        val uri = FileProvider.getUriForFile(applicationContext,"$packageName.provider",capturedVideoFile)
//        VideoCaptureLauncher().launch(
//            this@MainActivity,
//            uri,
//            onSuccess = { videoCaptureOutput ->
//                Log.i(TAG,"Video captured successfully")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )

//        documentPick.launch(
//            arrayOf(
//                "application/pdf",
//                "application/msword",
//                "application/ms-doc",
//                "application/doc",
//                "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
//                "text/plain"
//            )
//        )


    }
}