package com.lionsquare.movilia;

import android.app.Application;
import android.content.Context;

/**
 * Created by edgararana on 06/02/17.
 */

public class MoviliaApplication extends Application {
    private static MoviliaApplication instance;


    public static MoviliaApplication getInstance() {
        return instance;
    }

    public static Context getContext() {
        return instance.getApplicationContext();

    }

    @Override
    public void onCreate() {

        super.onCreate();

        instance = this;
    }
}
