package com.yangge.test;

import android.app.Application;
import android.content.Context;

/**
 * Created by charming-yin on 2017/9/30.
 */

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
       context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
