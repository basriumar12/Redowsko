package com.android.redowsko.network;

import android.content.Context;

import com.android.redowsko.model.ResponseLogin;
import com.infideap.atomic.Atom;
import com.infideap.atomic.FutureCallback;

/**
 * Created by User on 26/05/2018.
 */

public class NetworkService {

    private String URL_BASE ="http://fernaguez.umarta.tech/";
    private String URL_LOGIN ="api/user/login";
    public NetworkService() {

    }
    public void getLogin(Context context, FutureCallback<ResponseLogin> callback)
    {
        String final_url = URL_BASE.concat(URL_LOGIN);
        Atom.with(context)
                .load(final_url)
                .as(ResponseLogin.class)
                .setCallback(callback);
    }

}
