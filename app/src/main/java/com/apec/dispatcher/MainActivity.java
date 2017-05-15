package com.apec.dispatcher;

import android.os.Bundle;

import base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public void setDisplayHomeEnabled(boolean b) {
        super.setDisplayHomeEnabled(false);
    }
}
