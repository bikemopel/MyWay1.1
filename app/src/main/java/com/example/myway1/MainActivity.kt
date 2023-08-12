package com.example.myway1


import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.myway1.ui.theme.MyWay1Theme


class MainActivity : FragmentActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
           fun startDetailActivity() {
        val intent = Intent(this, MainStartActivity::class.java)
        startActivity(intent)
                }

        setContent {
            MyWay1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   val context = LocalContext.current


                   val biometricManager = remember { BiometricManager.from(context) }
                   val isBiometricAvailable = remember {
    biometricManager.canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
}
when (isBiometricAvailable) {
    BiometricManager.BIOMETRIC_SUCCESS -> {
        // Biometric features are available
    }

    BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
        // No biometric features available on this device
    }

    BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
        // Biometric features are currently unavailable.
    }

    BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
        // Biometric features available but a security vulnerability has been discovered
    }

    BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
        // Biometric features are currently unavailable because the specified options are incompatible with the current Android version..
    }

    BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> {
        // Unable to determine whether the user can authenticate using biometrics
    }

    BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
        // The user can't authenticate because no biometric or device credential is enrolled.
    }
}


val executor = remember { ContextCompat.getMainExecutor(context) }
val biometricPrompt = BiometricPrompt(
    context as FragmentActivity,
    executor,
    object : BiometricPrompt.AuthenticationCallback() {
        override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
            super.onAuthenticationError(errorCode, errString)
            // handle authentication error here

        }

        @RequiresApi(Build.VERSION_CODES.R)
        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
            super.onAuthenticationSucceeded(result)
            // handle authentication success here

                startDetailActivity()




        }

        override fun onAuthenticationFailed() {
            super.onAuthenticationFailed()
            // handle authentication failure here
        }
    }
)
                    val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setAllowedAuthenticators(BIOMETRIC_STRONG)
            .setTitle("Biometric Authentication")
            .setSubtitle("Log in using your biometric credential")
            .setNegativeButtonText("Use account password")
            .build()


                    Greeting("Android")


                    Button(onClick = { biometricPrompt.authenticate(promptInfo) }) {
    Text("Authenticate with Biometrics")
}

            }
        }

    }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyWay1Theme {
        Greeting("Android")
    }
}

@Composable
fun MyComposable(

  context: Context = LocalContext.current

) {

    Button(onClick = {

        val intent = Intent(context, StartActivity::class.java)

        context.startActivity(intent)

    }) {

        Text("Start Activity")

    }

}





















