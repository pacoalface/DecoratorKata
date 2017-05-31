package patterns.pacominube.decoratorkata.domain

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.content.Intent
import android.os.Vibrator
import android.support.v7.app.NotificationCompat
import patterns.pacominube.decoratorkata.NotificationActivity
import patterns.pacominube.decoratorkata.R




/**
 * Created by pacominube on 31/5/17.
 */
class NormalScheduler(val silentAlertScheduler: SilentAlertScheduler) : AlertScheduler by silentAlertScheduler {

  fun scheduleVibratorToast(context: Context) {
    silentAlertScheduler.scheduleToast(context)
    val vibrator: Vibrator = context.getSystemService(VIBRATOR_SERVICE) as Vibrator
    vibrator.vibrate(800)
  }

  fun schedulePushNotification(context: Context) {
    val intent = Intent(context, NotificationActivity::class.java)

    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)


    val mBuilder = NotificationCompat.Builder(context)
        .setSmallIcon(R.mipmap.ic_launcher_round)
        .setContentTitle("Comparte tu experiencia valorada")
        .setContentText("Para ayudar a otros viajeros comparte tus experiencias vividas en dicho lugar")
        .setContentIntent(pendingIntent)

    val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    mNotificationManager.notify(34, mBuilder.build())
  }
}