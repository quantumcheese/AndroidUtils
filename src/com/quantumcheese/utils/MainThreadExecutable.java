package com.quantumcheese.utils;

import android.app.Activity;
import android.os.Looper;

public abstract class MainThreadExecutable implements Runnable {
    private final Activity mActivity;

    public MainThreadExecutable(final Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void run() {
        if (!Looper.myLooper().equals(Looper.getMainLooper())) {
            mActivity.runOnUiThread(this);
            return;
        }
        execute();
    }

    public abstract void execute();
}
