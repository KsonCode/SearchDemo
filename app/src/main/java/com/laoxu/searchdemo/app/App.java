package com.laoxu.searchdemo.app;

import android.app.Application;
import android.content.Context;

import com.laoxu.searchdemo.utils.MyCrashHandler;

/**
 * 全局类
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        //创建全局异常捕获对象
        MyCrashHandler myCrashHandler = new MyCrashHandler();
        //配置全局异常捕获器
        Thread.setDefaultUncaughtExceptionHandler(myCrashHandler);
    }

    /**
     * 调用者使用的上下文对象
     * @return
     */
    public static Context getContext() {
        return context;
    }
}
