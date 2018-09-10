package com.zulip.android.satchat.activities;

import android.support.v7.app.AppCompatActivity;

import com.zulip.android.satchat.ZulipApp;
import com.zulip.android.satchat.service.ZulipServices;


public abstract class BaseActivity extends AppCompatActivity {

    protected ZulipApp getApp() {
        return ZulipApp.get();
    }

    protected ZulipServices getServices() {
        return getApp().getZulipServices();
    }
}
