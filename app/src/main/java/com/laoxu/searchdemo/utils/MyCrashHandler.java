package com.laoxu.searchdemo.utils;

import android.util.Log;

/**
 * 全局异常捕获类，定位异常并打印异常的一个类
 */
public class MyCrashHandler implements Thread.UncaughtExceptionHandler {
    /**
     * 没有捕获到的异常，系统处理的方法
     * @param t
     * @param e
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {

        Log.e("exception=======",e+"");

    }
}
