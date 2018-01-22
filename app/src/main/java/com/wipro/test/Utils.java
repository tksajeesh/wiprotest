package com.wipro.test;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;

/**
 * This is an Utility class.
 *
 * Created by Vishwajit on 19/01/18
 */

public class Utils {
    /**
     * Returns {@link boolean} indicating whether the string is neither null nor empty
     *
     * @param s the string that should be check
     * @return is empty/null
     */
    public static boolean notEmptyOrNull(String s) {
        return s != null && !s.trim().equals("");
    }

    /**
     * Returns {@link boolean} indicating whether the string is null or empty
     *
     * @param s the string that should be check
     * @return is empty/null
     */
    public static boolean isEmptyOrNull(String s) {
        return s == null || s.trim().equals("");
    }

    /**
     * Returns {@link boolean} indicating whether the array is neither null nor empty
     *
     * @param arrayList the array that should be checked
     * @return is empty/null
     */
    public static boolean notEmptyOrNull(ArrayList<?> arrayList) {
        return arrayList != null && !arrayList.isEmpty();
    }

    /**
     * This method check if the device is connected to internet or not
     *
     * @param context The context of the invoking class.
     * @return true if internet is connected and false otherwise.
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
