package com.ichwan.arch.apparchitecture.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
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
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .build()

        val myRequest = PeriodicWorkRequest.Builder(MyWorker::class.java, 15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .addTag(TAG)
            .build()

        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork(TAG, ExistingPeriodicWorkPolicy.KEEP, myRequest)
    }

    private fun oneTimeWork() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(true)
            .build()

        val workRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }
}