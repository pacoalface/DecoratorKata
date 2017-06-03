package patterns.pacominube.decoratorkata

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class DecoratorActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_decorator)

    findViewById(R.id.simple_alert).setOnClickListener({  })
    findViewById(R.id.power_alert).setOnClickListener({  })

  }
}
