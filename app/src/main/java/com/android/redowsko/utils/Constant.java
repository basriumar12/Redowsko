package com.android.redowsko.utils;



/**
 * Created by Rezky Aulia Pratama on 9/3/2017.
 */

public class Constant {

    // Static member class member that holds only one instance of the
    // SingletonExample class
    private static class SingletonHolder{
        public static Constant singletonInstance =
                new Constant();
    }
    // SingletonExample prevents any other class from instantiating
    private Constant() {
    }

    // Providing Global point of access

    public static Constant getInstance() {
        return SingletonHolder.singletonInstance;
    }




    public String URL_BASE ="http://fernaguez.umarta.tech/";
    public String URL_LOGIN ="api/user/login";

}
