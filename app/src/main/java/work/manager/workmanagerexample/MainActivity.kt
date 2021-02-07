package work.manager.workmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreference = SharedPreference(this)
        switch1.isChecked = sharedPreference.checkPrefs()

        switch1.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                sharedPreference.changeSwitch(false)
                createWorker()
            } else {
                sharedPreference.changeSwitch(true)
            }
        }
    }

    private fun createWorker() {
        val workRequest: WorkRequest =
                OneTimeWorkRequestBuilder<SwitchControlWorker>()
                        .setInitialDelay(5, TimeUnit.MINUTES)
                        .build()

        WorkManager
                .getInstance(this)
                .enqueue(workRequest)

    }
}