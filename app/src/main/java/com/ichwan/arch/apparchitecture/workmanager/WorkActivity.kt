package com.ichwan.arch.apparchitecture.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.ichwan.arch.apparchitecture.databinding.ActivityWorkBinding
import java.util.concurrent.TimeUnit

class WorkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkBinding
    companion object {
        const val TAG = "my_notification"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnOneTime.setOnClickListener {
                oneTimeWork()
            }
            btnPeriodic.setOnClickListener {
                periodicWork()
            }
        }
    }

    private fun periodicWork() {
        val myRequest = PeriodicWorkRequest.Builder(MyWorker::class.java, 15, TimeUnit.MINUTES)
            .setConstraints(constraints())
            .setInputData(data())
            .build()

        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork(TAG, ExistingPeriodicWorkPolicy.KEEP, myRequest)
    }

    private fun oneTimeWork() {
        val workRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setConstraints(constraints())
            .setInputData(data())
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }

    private fun data(): Data {
        return Data.Builder()
            .putString(MyWorker.key, "Worker")
            .build()
    }

    private fun constraints(): Constraints {
        return Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
            .build()
    }
}