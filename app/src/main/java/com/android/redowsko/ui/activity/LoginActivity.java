package com.android.redowsko.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.android.redowsko.R;
import com.android.redowsko.helper.Session;
import com.android.redowsko.model.LoginRequest;
import com.android.redowsko.model.ResponseLogin;
import com.android.redowsko.network.IntrafaceListiner;
import com.app.infideap.stylishwidget.view.AButton;
import com.app.infideap.stylishwidget.view.AEditText;
import com.google.gson.Gson;
import com.infideap.atomic.Atom;
import com.infideap.atomic.FutureCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class LoginActivity extends AppCompatActivity implements IntrafaceListiner {
    String getToken;
    String email;
    String password;
    @BindView(R.id.etUsername)
    AEditText etUsername;
    @BindView(R.id.etPassword)
    AEditText etPassword;
    @BindView(R.id.btnLogin)
    AButton btnLogin;
    @BindView(R.id.layout_main)
    LinearLayout layoutMain;
    @BindView(R.id.layout_content_main)
    RelativeLayout layoutContentMain;
    @BindView(R.id.idLoginActivity)
    LinearLayout idLoginActivity;
    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    Session sessionManager;
    @BindView(R.id.layout_progress)
    FrameLayout layoutProgress;
    @BindView(R.id.spLevelLogin)
    Spinner spLevelLogin;
    String levelLogin[] = {"Pilih Level Login", "Supeverior Medis", "Supeverior Perawat",
            "Supeverior Pasien", "Rumah Sakit"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ArrayAdapter adapter =
                new ArrayAdapter<String>(LoginActivity.this,
                        R.layout.item_spinner, levelLogin);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLevelLogin.setAdapter(adapter);


        sessionManager = new Session(getApplicationContext());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   getdata();
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }


    private void getdata() {
        final LoginRequest loginRequest = new LoginRequest();
        loginRequest.Email = etUsername.getText().toString();
        loginRequest.Password = etPassword.getText().toString();

        onLoadingListener();

        if (etUsername.getText().toString().isEmpty()) {
            snackBar("Nama tidak bisa kosong");
        } else if (etPassword.getText().toString().isEmpty()) {
            snackBar("Password tidak bisa kosong");
        } else {


            Atom.with(LoginActivity.this)
                    //.load(Constant.getInstance().URL_BASE.concat(Constant.getInstance().URL_LOGIN))
                    .load("http://fernaguez.umarta.tech/api/user/login")
                    .setJsonPojoBody(loginRequest)
                    .as(ResponseLogin.class)
                    .setCallback(new FutureCallback<ResponseLogin>() {
                        @Override
                        public void onCompleted(Exception e, ResponseLogin result) {

                            if (e != null) {
                                Timber.e("error " + e.getMessage());
                                e.printStackTrace();
                            }
                            Timber.e("Succes" + new Gson().toJson(result));

                            if (result != null) {
                                if (result.isSuccess() == true) {
                                    String getToken = result.getToken();
                                    Timber.e("Get Token :" + getToken);

                                    sessionManager.createSession(getToken);
                                    startActivity(new Intent(LoginActivity.this,
                                            MainActivity.class));
                                    finish();
                                }
                            } else {
                                snackBar("Email / Password incorrect");
                                onHideLoadingListener();
                            }

                        }
                    });

            // Testing Retrofit
          /*  String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            Service sr = RestClient.getClient();
         Call<ResponseLogin> call = sr.postLogin(username,password);
            call.enqueue(new Callback<ResponseLogin>() {
                @Override
                public void onResponse(retrofit2.Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    if (response != null){
                        Timber.e("Result respon"+new Gson().toJson(response.body()));
                    }

                    if (response.body().isSuccess()==true){

                    }
                }

                @Override
                public void onFailure(retrofit2.Call<ResponseLogin> call, Throwable t) {

                    Timber.e("ERROR"+t.getMessage());
                }
            });
*/
        }

    }

    public void snackBar(String message) {
        Snackbar.make(idLoginActivity, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onErrorListener() {

    }

    @Override
    public void onLoadingListener() {
        layoutProgress.setVisibility(View.VISIBLE);

    }

    @Override
    public void onHideLoadingListener() {

        layoutProgress.setVisibility(View.GONE);
    }

    @Override
    public void onSuccesfullListener() {

    }
}
