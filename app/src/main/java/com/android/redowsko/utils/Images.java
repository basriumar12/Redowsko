package com.android.redowsko.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import timber.log.Timber;

/**
 * Created by Shiburagi on 10/10/2016.
 */

public class Images {
    public static void save(File file, byte[] data) {
        //Toast.makeText(getContext(), "Capture", Toast.LENGTH_LONG).show();
        FileOutputStream outStream = null;
        try {

            outStream = new FileOutputStream(file);

            outStream.write(data);
            outStream.close();

            Timber.e("onPictureTaken - wrote bytes: " + data.length);
        } catch (IOException e) {
            //Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
            Timber.e("save error :" + e.getMessage());
        } finally {

        }
    }


    public static Bitmap rotateImage(Context activity, Bitmap bitmap, File file) throws IOException {
        return rotateImage(activity, bitmap, file.getAbsolutePath());
    }

    public static Bitmap rotateImage(Context activity, Bitmap bitmap, String path) throws IOException {
        ExifInterface ei = new ExifInterface(path);
        return rotateImage(activity, bitmap, ei);
    }



    public static Bitmap rotateImage(Context activity, Bitmap bitmap, ExifInterface ei) throws IOException {
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_UNDEFINED);

        Bitmap rotatedBitmap;
        Timber.e("Orientation : %d", orientation);
        switch (orientation) {

            case ExifInterface.ORIENTATION_ROTATE_90:
                rotatedBitmap = rotateImage(bitmap, 90);
                break;

            case ExifInterface.ORIENTATION_ROTATE_180:
                rotatedBitmap = rotateImage(bitmap, 180);
                break;

            case ExifInterface.ORIENTATION_ROTATE_270:
                rotatedBitmap = rotateImage(bitmap, 270);
                break;

            case ExifInterface.ORIENTATION_NORMAL:
            default:
                rotatedBitmap = bitmap;
        }
        return rotatedBitmap;
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }


    public static ByteArrayOutputStream compress(Bitmap bitmap) {
        bitmap = Utils.getInstance().resize(bitmap);
        ByteArrayOutputStream blob = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, blob);

        return blob;
    }
}
