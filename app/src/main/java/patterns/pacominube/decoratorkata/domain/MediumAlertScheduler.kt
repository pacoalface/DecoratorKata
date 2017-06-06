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
class MediumAlertScheduler(val silentAlertScheduler: SilentAlertScheduler) : AlertScheduler by silentAlertScheduler {

  override fun scheduleMessage(context: Context) {
    silentAlertScheduler.scheduleMessage(context)
    val vibrator: Vibrator = context.getSystemService(VIBRATOR_SERVICE) as Vibrator
    vibrator.vibrate(800)
  }

  fun scheduleNotification(context: Context) {
    val intent = Intent(context, NotificationActivity::class.java)

    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

    val mBuilder = NotificationCompat.Builder(context)
        .setSmallIcon(R.mipmap.ic_launcher_round)
        .setAutoCancel(true)
        .setContentTitle("Comparte tu experiencia valorada")
        .setContentText("Para ayudar a otros viajeros comparte tus experiencias vividas en dicho lugar")
        .setContentIntent(pendingIntent)

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.notify(34, mBuilder.build())
  }
}