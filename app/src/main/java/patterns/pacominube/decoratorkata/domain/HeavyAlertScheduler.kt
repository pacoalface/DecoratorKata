package patterns.pacominube.decoratorkata.domain

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.view.View
import com.tapadoo.alerter.Alerter
import patterns.pacominube.decoratorkata.NotificationActivity
import patterns.pacominube.decoratorkata.R

/**
 * Created by franciscoalfacemartin on 3/6/17.
 */
class HeavyAlertScheduler(val mediumAlertScheduler: MediumAlertScheduler) : AlertScheduler by mediumAlertScheduler {

  override fun scheduleMessage(context: Context) {
    mediumAlertScheduler.scheduleMessage(context)

    val mediaPlayer = MediaPlayer.create(context, R.raw.siu)
    mediaPlayer.start()
  }

  fun scheduleWindow(context: Context) {
    Alerter.create(context as Activity)
        .setTitle("Genial!")
        .enableVibration(true)
        .setOnClickListener({ NotificationActivity.startActivity(context) })
        .setText("Tu valoracion sobre este rincon se ha hecho de forma correcta")
        .show()
  }

}