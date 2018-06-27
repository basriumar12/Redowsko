package com.android.redowsko;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by User on 26/05/2018.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

    }
}
