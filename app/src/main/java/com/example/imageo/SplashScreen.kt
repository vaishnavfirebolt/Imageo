package com.example.imageo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreen : AppCompatActivity() {

    private lateinit var zoom : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        zoom = AnimationUtils.loadAnimation(applicationContext,R.anim.zoom)
        image.startAnimation(zoom)

        val h = Handler()
        h.postDelayed(Runnable {
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 4000)

    }
}