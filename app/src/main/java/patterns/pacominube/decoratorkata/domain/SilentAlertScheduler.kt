package patterns.pacominube.decoratorkata.domain

import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

/**
 * Created by pacominube on 31/5/17.
 */
class SilentAlertScheduler : AlertScheduler {

  constructor()

  override fun scheduleToast(context: Context) {
    Toast.makeText(context, "Tu valoracion sobre este rincon se ha hecho de forma correcta", Toast.LENGTH_SHORT).show()
  }

  override fun scheduleNotification(view: View) {
    Snackbar.make(view,"Tu valoracion sobre este rincon se ha hecho de forma correcta", Snackbar.LENGTH_LONG).show()
  }

}