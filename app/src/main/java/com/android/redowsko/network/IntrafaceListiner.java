package com.android.redowsko.network;

/**
 * Created by User on 26/05/2018.
 */

public interface IntrafaceListiner {
    void onErrorListener();
    void onLoadingListener();
    void onHideLoadingListener();
    void onSuccesfullListener();
}
