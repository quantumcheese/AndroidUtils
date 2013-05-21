package com.quantumcheese.utils;

public final class StringUtils {
    private StringUtils() {
    }

    public static boolean isNullOrEmpty(final String s) {
        return null == s || 0 == s.length();
    }

}
