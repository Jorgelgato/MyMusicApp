package com.bobrek.mymusicapp.ui.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bobrek.mymusicapp.databinding.ActivityMainBinding
import com.bobrek.mymusicapp.di.SpotifyConstants
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launcher = spotifyLogin()
        binding.btnLogin.setOnClickListener {
            launch(launcher)
        }
    }

    private fun spotifyLogin(): ActivityResultLauncher<Intent> {
        return registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK
                && activityResult(it.resultCode, it.data)
            ) {
                loginSuccess(
                    Intent(
                        this,
                        HomeActivity::class.java
                    ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                )
            }
        }
    }

    private fun launch(launcher: ActivityResultLauncher<Intent>) {
        launcher.launch(
            AuthorizationClient.createLoginActivityIntent(
                this,
                getAuthenticationRequest()
            )
        )
    }

    private fun loginSuccess(intent: Intent) {
        SpotifyAppRemote.connect(this, ConnectionParams.Builder(SpotifyConstants.CLIENT_ID)
            .setRedirectUri(SpotifyConstants.REDIRECT_URI)
            .showAuthView(true)
            .build(),
            object : Connector.ConnectionListener {
                override fun onConnected(spotifyAppRemote: SpotifyAppRemote) {
                    SpotifyConstants.mSpotifyAppRemote = spotifyAppRemote
                    startActivity(intent)
                    finish()
                }

                override fun onFailure(throwable: Throwable) {
                    Log.e("MyActivity", throwable.message, throwable)
                }
            })
    }

    private fun getAuthenticationRequest(): AuthorizationRequest {
        return AuthorizationRequest.Builder(
            SpotifyConstants.CLIENT_ID,
            AuthorizationResponse.Type.TOKEN,
            SpotifyConstants.REDIRECT_URI
        )
            .setShowDialog(true)
            .setScopes(
                arrayOf(
                    "streaming",
                    "user-library-read",
                    "user-top-read"
                )
            )
            .build()
    }

    private fun activityResult(resultCode: Int, intent: Intent?): Boolean {
        val response = AuthorizationClient.getResponse(resultCode, intent)

        when (response.type) {
            AuthorizationResponse.Type.TOKEN -> Log.d("TOKEN", response.accessToken)
            else -> Log.e("ERROR", response.error)
        }

        val accessToken: String? = response.accessToken
        if (accessToken == null) {
            Log.e("Status ", "No Access Token found")
            return false
        }
        println(accessToken)
        SpotifyConstants.TOKEN = accessToken
        return true
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, 0)
    }
}
