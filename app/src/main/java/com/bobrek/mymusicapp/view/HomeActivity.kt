package com.bobrek.mymusicapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bobrek.mymusicapp.databinding.ActivityHomeBinding
import com.bobrek.mymusicapp.databinding.ActivityMainBinding
import com.bobrek.mymusicapp.di.SpotifyConstants

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SpotifyConstants.mSpotifyAppRemote.playerApi.playerState.setResultCallback {
            binding.textView.text = it.toString()
        }
    }
}