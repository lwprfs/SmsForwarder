package cn.ppps.forwarder.activity

import android.app.Activity
import android.os.Bundle
import android.content.Intent

class SecretDialerActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Launch the main app
        val intent = Intent(this, SplashActivity::class.java)
        intent.putExtra("launch_from_secret_code", true)
        startActivity(intent)
        finish()
    }
}