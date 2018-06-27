package com.android.redowsko.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 26/05/2018.
 */

public class LoginRequest {
    @SerializedName(value = "email")
    public String Email;

    @SerializedName(value = "password")
    public String Password;

    @SerializedName(value = "token")
    public String Token;

    public LoginRequest() {
    }

    public LoginRequest(String email, String password, String token) {
        Email = email;
        Password = password;
        Token = token;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
