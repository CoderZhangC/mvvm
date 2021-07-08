package com.wan.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wan.android.databinding.ActivitySplashBinding
import com.wan.base.util.setVisibleOrGone

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        binding.root.setVisibleOrGone(true)
    }
}