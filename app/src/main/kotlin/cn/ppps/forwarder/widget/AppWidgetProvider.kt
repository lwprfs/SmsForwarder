package cn.ppps.forwarder.widget

import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import cn.ppps.forwarder.activity.SplashActivity

class AppWidgetProvider : AppWidgetProvider() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "OPEN_APP") {
            val launchIntent = Intent(context, SplashActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra("launch_from_widget", true)
            }
            context.startActivity(launchIntent)
        }
        super.onReceive(context, intent)
    }
}