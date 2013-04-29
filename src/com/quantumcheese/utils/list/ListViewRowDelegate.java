package com.quantumcheese.utils.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/**
 * Especially useful for a ListView Adapter with heterogeneous row types.
 * E.g., the Adapter can hold on to an array of ListViewRowDelegates
 * and grab the appropriate delegate to have it (create and) populate the convertView.
 */
public interface ListViewRowDelegate {
    public abstract class RowViewHolder {
        protected final View view;
        public RowViewHolder(final View view) {
            this.view = view;
        }
    }

    View populateView(final int position, final View convertView, final ViewGroup parent, final ListAdapter adapter);
}
