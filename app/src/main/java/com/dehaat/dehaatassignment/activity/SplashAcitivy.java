package com.dehaat.dehaatassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.datalayer.model.Author;
import com.dehaat.dehaatassignment.datalayer.model.AuthorResponse;
import com.dehaat.dehaatassignment.datalayer.rest.ApiHelper;
import com.dehaat.dehaatassignment.util.AuthUtils;

import javax.inject.Inject;

import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashAcitivy extends BaseActivity {

    @Inject
    ApiHelper apiHelper;

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

//        apiHelper.getAuthors().enqueue(new Callback<AuthorResponse>() {
//            @Override
//            public void onResponse(Call<AuthorResponse> call, Response<AuthorResponse> response) {
//                Log.d("DD::","onResponse");
//            }
//
//            @Override
//            public void onFailure(Call<AuthorResponse> call, Throwable t) {
//                Log.d("DD::","onFailure");
//            }
//        });
    }

}
