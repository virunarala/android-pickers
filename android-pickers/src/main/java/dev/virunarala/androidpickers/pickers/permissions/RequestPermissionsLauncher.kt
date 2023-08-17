package dev.virunarala.androidpickers.pickers.permissions

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import dev.virunarala.androidpickers.pickers.permissions.model.RequestPermissionsInput
import dev.virunarala.androidpickers.pickers.permissions.model.RequestPermissionsOutput

class RequestPermissionsLauncher {

    fun launch(activity: ComponentActivity,
               permissions: Array<String>,
               onSuccess: (RequestPermissionsOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val requestPermissionsLauncher = activity.registerForActivityResult(
            RequestPermissions()
        ) { arePermissionsGranted ->

        }

        requestPermissionsLauncher.launch(
            RequestPermissionsInput(
                permissions,
                onSuccess,
                onFailure
            )
        )
    }

    fun launch(fragment: Fragment,
               permissions: Array<String>,
               onSuccess: (RequestPermissionsOutput) -> Unit,
               onFailure: (message: String) -> Unit) {
        val requestPermissionsLauncher = fragment.registerForActivityResult(
            RequestPermissions()
        ) { arePermissionsGranted ->

        }

        requestPermissionsLauncher.launch(
            RequestPermissionsInput(
                permissions,
                onSuccess,
                onFailure
            )
        )
    }
}