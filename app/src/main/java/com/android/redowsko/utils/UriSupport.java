package com.android.redowsko.utils;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * Created by Shiburagi on 14/11/2017.
 */

public class UriSupport {

    public static Uri fromFile(Context context, File mFile) {


        try {
            return FileProvider.getUriForFile(context,
                    context.getApplicationContext().getPackageName() + ".provider", mFile);

        } catch (Exception e) {
            return Uri.fromFile(mFile);
        }

    }
}
