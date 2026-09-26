package cn.ppps.forwarder.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import cn.ppps.forwarder.utils.SettingUtils
import com.xuexiang.xutil.app.ActivityUtils

class SecretLauncherActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Check if launched correctly
        val launchedFromSecretCode = intent?.getBooleanExtra("launch_from_secret_code", false) == true
        val launchedFromScheme = intent?.action == Intent.ACTION_VIEW && intent?.data?.scheme == "smsforwarder"
        
        if (!launchedFromSecretCode && !launchedFromScheme) {
            finish()
            return
        }
        
        // Launch directly without splash
        if (SettingUtils.enablePureTaskMode) {
            ActivityUtils.startActivity(TaskActivity::class.java)
        } else if (SettingUtils.enablePureClientMode) {
            ActivityUtils.startActivity(ClientActivity::class.java)
        } else {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("launch_from_secret_code", true)
            startActivity(intent)
        }
        finish()
    }
}