package com.android.redowsko.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.redowsko.R;
import com.android.redowsko.helper.Session;
import com.google.gson.Gson;
import com.infideap.atomic.Atom;
import com.infideap.atomic.FutureCallback;

import java.util.HashMap;

import okhttp3.Headers;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    Session sessionManager;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new Session(getApplicationContext());
        getToken();
        cobaGetdata();
    }

    private void cobaGetdata() {
        Headers.Builder builder = new Headers.Builder();
        builder.add("Authorization", "Bearer"+token);
        Atom.with(MainActivity.this)
                .load("http://fernaguez.umarta.tech/api/report")
                .setHeader(builder.build())
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        if (e!=null){
                            e.printStackTrace();
                            Timber.e("ERROR E MAINACTIVITY :"+e.getMessage());
                        }
                        if (result!=null){
                            Timber.e("Result token :"+new Gson().toJson(result));
                        }
                    }
                });

    }

    private void getToken() {
        HashMap<String, String> user = sessionManager.getUserDetails();
        token = user.get(Session.token);
        Timber.e("Get Token Mainactivity :"+token);


    }
}
