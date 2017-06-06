package patterns.pacominube.decoratorkata.domain

import android.content.Context
import android.media.MediaPlayer
import patterns.pacominube.decoratorkata.NotificationActivity
import patterns.pacominube.decoratorkata.R

/**
 * Created by franciscoalfacemartin on 3/6/17.
 */
class HeavyAlertScheduler(val mediumAlertScheduler: MediumAlertScheduler) : AlertScheduler by mediumAlertScheduler {

  override fun scheduleToast(context: Context) {
    mediumAlertScheduler.scheduleToast(context)

    val mediaPlayer = MediaPlayer.create(context, R.raw.siu)
    mediaPlayer.start()
  }

  fun scheduleWindow(context: Context) {
    NotificationActivity.startActivity(context)
  }

}