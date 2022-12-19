package com.punk.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.punk.R
import com.punk.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {

    lateinit var mHandler: Handler
    private val delay: Long = 2000

    private val mRunnable: Runnable = Runnable {
        startActivity(Intent(this, HomeActivity::class.java))
        finishAffinity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        init()
    }

    private fun init() {
        mHandler = Handler()
        mHandler.postDelayed(mRunnable, delay)
    }

    public override fun onDestroy() {
        mHandler.removeCallbacks(mRunnable)
        super.onDestroy()
    }

}