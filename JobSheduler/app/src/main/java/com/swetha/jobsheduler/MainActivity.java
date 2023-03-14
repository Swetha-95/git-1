package com.swetha.jobsheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    JobScheduler jobScheduler;
    JobInfo jobInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        jobInfo = new JobInfo.Builder(12, new ComponentName(this, MyJobScheduler.class.getName()))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .build();
    }

    public void scheduleJob(View view) {
        jobScheduler.schedule(jobInfo);
    }
}