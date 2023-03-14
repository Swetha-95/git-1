package com.swetha.jobsheduler;

import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.widget.Toast;

public class MyJobScheduler extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        Toast.makeText(getApplicationContext(), "job performed",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
