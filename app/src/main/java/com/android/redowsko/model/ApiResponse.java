package com.android.redowsko.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 26/05/2018.
 */

public class ApiResponse<T> {
    @SerializedName(value = "ApiStatus")
    @Expose
    public String ApiStatus;
    @SerializedName(value = "ApiMessage")
    @Expose
    public String ApiMessage;
}
