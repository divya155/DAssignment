package com.dehaat.dehaatassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.util.AuthUtils;

public class SplashAcitivy extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_acitivy);

        findViewById(R.id.logo).postDelayed(new Runnable() {
            @Override
            public void run() {
                if(AuthUtils.INSTANCE.isUserLoggedIn(getApplicationContext())){
                    AuthUtils.INSTANCE.refreshSession();
                    launchActivity(MainActivity.class);
                }else {
                    launchActivity(LoginActivity.class);
                }
                finish();
            }
        },2000);
    }

}
