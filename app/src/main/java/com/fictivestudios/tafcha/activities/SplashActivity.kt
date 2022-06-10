package com.fictivestudios.tafcha.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fictivestudios.tafcha.R
import android.content.Intent




class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this@SplashActivity, RegisterationActivity::class.java))

        finish()
    }
}