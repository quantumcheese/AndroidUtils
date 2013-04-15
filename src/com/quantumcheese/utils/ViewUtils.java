package com.quantumcheese.utils;

import android.view.View;
import android.widget.TextView;

public final class ViewUtils {

    private ViewUtils() {
    }

    private String concatenateStrings(final String... strings) {
        if (1 == strings.length) {
            return strings[0];
        } else {
            final StringBuilder sb = new StringBuilder();
            for (final String line : strings) {
                sb.append(line);
            }
            return sb.toString();
        }
    }

    public void setText(final View parent, final int targetResourceId, final String... strings) {
        final String text = concatenateStrings(strings);
        final TextView tv = (TextView) parent.findViewById(targetResourceId);
        tv.setText(text);
    }

}
