package com.wipro.test;

import java.util.ArrayList;

/**
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
}
