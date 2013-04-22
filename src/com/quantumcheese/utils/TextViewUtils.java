package com.quantumcheese.utils;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public final class TextViewUtils {

    private TextViewUtils() {
    }

    private static String concatenateStrings(final String... strings) {
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

    public static void setText(final View parent, final int targetResourceId, final String... strings) {
        final String text = concatenateStrings(strings);
        final TextView tv = (TextView) parent.findViewById(targetResourceId);
        tv.setText(text);
    }

    public static void setText(final TextView tv, final String... strings) {
        final String text = concatenateStrings(strings);
        tv.setText(text);
    }

    public static boolean editTextIsEmpty(final EditText textField) {
        return 0 == textField.getText().toString().length();
    }

    public static TextView findTextViewById(final View view, final int id) {
        final View found = view.findViewById(id);
        if (TextView.class.isInstance(found)) {
            return (TextView) found;
        }
        return null;
    }
}
