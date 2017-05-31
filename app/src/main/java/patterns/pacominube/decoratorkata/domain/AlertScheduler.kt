package patterns.pacominube.decoratorkata.domain

/**
 * Created by pacominube on 31/5/17.
 */
interface AlertScheduler {
  fun scheduleNotification()
  fun scheduleToast()
}