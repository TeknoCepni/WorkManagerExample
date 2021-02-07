package work.manager.workmanagerexample

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class SwitchControlWorker(private val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {

        SharedPreference(context).changeSwitch(true)
        return Result.success()
    }
}
