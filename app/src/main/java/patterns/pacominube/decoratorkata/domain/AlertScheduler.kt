package patterns.pacominube.decoratorkata.domain

import android.content.Context
import android.view.View

/**
 * Created by pacominube on 31/5/17.
 */
interface AlertScheduler {
  fun scheduleNotification(view: View)
  fun scheduleToast(context : Context)
}