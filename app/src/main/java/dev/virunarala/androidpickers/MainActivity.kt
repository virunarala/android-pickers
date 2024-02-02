package dev.virunarala.androidpickers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import dev.virunarala.androidpickers.pickers.file.getdirectory.GetDirectoryLauncher
import dev.virunarala.androidpickers.pickers.file.getfile.GetFileLauncher
import dev.virunarala.androidpickers.pickers.file.getfiles.GetFilesLauncher
import dev.virunarala.androidpickers.pickers.file.openfile.OpenFileLauncher
import dev.virunarala.androidpickers.pickers.file.openfiles.OpenFilesLauncher
import dev.virunarala.androidpickers.pickers.permissions.RequestPermissionsLauncher
import dev.virunarala.androidpickers.pickers.photo.capture.PhotoCaptureLauncher
import dev.virunarala.androidpickers.pickers.photo.picker.VisualMediaPickerLauncher
import dev.virunarala.androidpickers.pickers.video.capture.VideoCaptureLauncher
import dev.virunarala.androidpickers.utils.FileExtensions
import dev.virunarala.androidpickers.utils.createInternalFile

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var button1: Button
    private lateinit var button2: Button

    val documentPick = registerForActivityResult(ActivityResultContracts.OpenDocument()) { result ->
        // do something
    }

    val getDirectoryLauncher = GetDirectoryLauncher(this@MainActivity)
    val visualMediaPickerLauncher = VisualMediaPickerLauncher(this@MainActivity)
    val photoCaptureLauncher = PhotoCaptureLauncher(this@MainActivity)
    val getFileLauncher = GetFileLauncher(this@MainActivity)
    val getFilesLauncher = GetFilesLauncher(this@MainActivity)
    val openFileLauncher = OpenFileLauncher(this@MainActivity)
    val openFilesLauncher = OpenFilesLauncher(this@MainActivity)
    val requestPermissionsLauncher = RequestPermissionsLauncher(this@MainActivity)
    val videoCaptureLauncher = VideoCaptureLauncher(this@MainActivity)

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        /** Photo Picker Sample
         * STATUS: OK
         * */
//        visualMediaPickerLauncher.launch(
//            ActivityResultContracts.PickVisualMedia.ImageOnly,
//            onSuccess = { pickImageOutput ->
//                imageView.setImageURI(pickImageOutput.uri)
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            })


        /** Photo Capture Sample
         * STATUS: OK
         * */
//        val capturedImgFile = createInternalFile(this@MainActivity, FileExtensions.JPG.extension)
//        val uri = FileProvider.getUriForFile(applicationContext,"$packageName.provider",capturedImgFile)
//        photoCaptureLauncher.launch(
//            uri,
//            onSuccess = { pickImageOutput ->
//                imageView.setImageURI(pickImageOutput.uri)
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )

        /** Get File Sample
         * STATUS: OK
         * */
//        getFileLauncher.launch(
//            "audio/flac",
//            null,
//            onSuccess = { getFileOutput ->
//                Log.i(TAG,"Picked File URI: ${getFileOutput.uri}")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )

        /** Get Files Sample
         * STATUS: WORKING
         * */
//        getFilesLauncher.launch(
//            "audio/flac",
//            null,
//            onSuccess = { getFilesOutput ->
//                Log.i(TAG,"Picked File URI: ${getFilesOutput.uris}")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )


        /** Open Single File(Document) Sample
         * STATUS: WORKING
         * */
//        openFileLauncher.launch(
//            "application/pdf;text/plain;audio/flac",
//            onSuccess = { openFileOutput ->
//                Log.i(TAG,"Picked File URI: ${openFileOutput.uri}")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )

        /** Open Multiple Files(Documents) Sample
         * STATUS: Throws ActivityNotFoundException
         * */
//        openFilesLauncher.launch(
//            arrayOf("application/pdf"),
//            null,
//            onSuccess = { openFilesOutput ->
//                Log.i(TAG,"Picked File URI: ${openFilesOutput.uris}")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )

        /** Request Permissions
         * STATUS: WORKING
         * ADD: A new callback for shouldShowRationale and when permission is permanently denied (if possible)
         * */
//            requestPermissionsLauncher.launch(
//                arrayOf("android.permission.CAMERA","android.permission.ACCESS_COARSE_LOCATION"),
//                onSuccess = {
//                    Log.i(TAG,"Success")
//                },
//                onFailure = { errorMessage ->
//                    Log.e(TAG,errorMessage)
//                }
//            )

        /** Video Capture Sample
         * STATUS: WORKING
         * */
//        val capturedVideoFile = createInternalFile(this@MainActivity, FileExtensions.MP4.extension)
//        val uri = FileProvider.getUriForFile(applicationContext,"$packageName.provider",capturedVideoFile)
//        videoCaptureLauncher.launch(
//            uri,
//            onSuccess = { videoCaptureOutput ->
//                Log.i(TAG,"Video captured successfully")
//            },
//            onFailure = { errorMessage ->
//                Log.e(TAG,errorMessage)
//            }
//        )

        /** Get Directory Access
         * STATUS: WORKING
         * */
        getDirectoryLauncher.launch(
            null,
            onSuccess = {
                Log.i(TAG,"Directory accessed successfully: ${it.uri}")
            },
            onFailure = {
                Log.e(TAG,"Error: $it")
            }
        )

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

    override fun onResume() {
        super.onResume()


        button1.setOnClickListener {

        }

        button2.setOnClickListener {
            /** Get Directory Access */
            getDirectoryLauncher.launch(
                null,
                onSuccess = {
                    Log.i(TAG,"Directory accessed successfully: ${it.uri}")
                },
                onFailure = {
                    Log.e(TAG,"Error: $it")
                }
            )
        }
    }
}