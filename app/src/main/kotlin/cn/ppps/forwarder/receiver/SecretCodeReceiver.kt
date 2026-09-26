package cn.ppps.forwarder.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import cn.ppps.forwarder.activity.SplashActivity
import cn.ppps.forwarder.utils.Log

class SecretCodeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.provider.Telephony.SECRET_CODE") {
            val host = intent.data?.host
            Log.d("SecretCodeReceiver", "Secret code detected: $host")
            if (host == "123456") {
                Log.d("SecretCodeReceiver", "Launching app via secret code")
                val launchIntent = Intent(context, SplashActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    putExtra("launch_from_secret_code", true)
                }
                context.startActivity(launchIntent)
            }
        }
    }
}