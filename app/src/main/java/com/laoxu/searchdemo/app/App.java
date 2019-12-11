package com.laoxu.searchdemo.app;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    /**
     * 调用者使用的上下文对象
     * @return
     */
    public static Context getContext() {
        return context;
    }
}
