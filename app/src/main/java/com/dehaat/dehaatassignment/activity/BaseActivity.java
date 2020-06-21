package com.dehaat.dehaatassignment.activity;


import android.content.Intent;
import android.os.Bundle;

import com.dehaat.dehaatassignment.R;

import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void launchActivity(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
