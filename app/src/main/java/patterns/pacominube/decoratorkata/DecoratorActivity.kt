package patterns.pacominube.decoratorkata

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioGroup
import patterns.pacominube.decoratorkata.domain.HeavyAlertScheduler
import patterns.pacominube.decoratorkata.domain.MediumAlertScheduler
import patterns.pacominube.decoratorkata.domain.SilentAlertScheduler



class DecoratorActivity : AppCompatActivity() {

  val silentScheduler: SilentAlertScheduler = SilentAlertScheduler()
  val mediumScheduler: MediumAlertScheduler = MediumAlertScheduler(silentScheduler)
  val heavyScheduler: HeavyAlertScheduler = HeavyAlertScheduler(mediumScheduler)

  var currentProfileId: Int = R.id.silent

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_decorator)

    val radioGroup = findViewById(R.id.radio_group) as RadioGroup

    radioGroup.setOnCheckedChangeListener { group, checkedId ->
      currentProfileId = checkedId
    }

    findViewById(R.id.simple_alert).setOnClickListener({
      when(currentProfileId) {
        R.id.silent -> silentScheduler.scheduleToast(this)
        R.id.medium -> mediumScheduler.scheduleToast(this)
        R.id.heavy -> heavyScheduler.scheduleNoisyToast(this)
      }

    })

    findViewById(R.id.power_alert).setOnClickListener({
      when(currentProfileId) {
        R.id.silent -> silentScheduler.scheduleNotification(findViewById(R.id.root_view))
        R.id.medium -> mediumScheduler.scheduleNotification(this)
        R.id.heavy -> heavyScheduler.scheduleWindow(this)
      }
    })
  }

}
