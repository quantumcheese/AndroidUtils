package com.quantumcheese.utils.list;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public abstract class SectionedListAdapter extends BaseAdapter {
    public abstract class SectionedListViewRowDelegate implements ListViewRowDelegate {

        public abstract View populateView(final int section, final int position
            , final View convertView, final ViewGroup parent
            , final SectionedListAdapter adapter);

        @Override
        public final View populateView(final int position, final View convertView, final ViewGroup parent
            , final ListAdapter adapter) {
            throw new UnsupportedOperationException("Must call other variant of populateView().");
        }

    }

    private SparseArray<Object> mSectionHeaders;

    @Override
    public final int getCount() {
        final int sectionCount = getCountOfSections();
        int total = 0;
        this.mSectionHeaders = new SparseArray<Object>(sectionCount);
        for (int i = 0; i != sectionCount; ++i) {
            mSectionHeaders.put(total++, getSectionItem(i));
            final int count = getCountForSection(i);
            total += count;
        }
        return total;
    }

    public abstract int getCountOfSections();

    public abstract int getCountForSection(int section);

    public abstract Object getSectionItem(int section);

    public abstract Object getItem(int section, int position);

    @Override
    public final Object getItem(final int position) {
        if (0 <= mSectionHeaders.indexOfKey(position)) {
            return mSectionHeaders.get(position);
        }
        final int section = getSectionForPosition(position);
        final int pos = getPositionWithinSection(section, position);
        return getItem(section, pos);
    }

    public abstract View getSectionView(int section, View convertView, ViewGroup parent);

    public abstract View getView(int section, int position, View convertView, ViewGroup parent);

    @Override
    public final View getView(final int position, final View convertView, final ViewGroup parent) {
        final int sectionIndex = mSectionHeaders.indexOfKey(position);
        if (0 <= sectionIndex) {
            return getSectionView(sectionIndex, convertView, parent);
        }
        final int section = getSectionForPosition(position);
        final int pos = getPositionWithinSection(section, position);
        return getView(section, pos, convertView, parent);
    }

    public long getSectionItemId(final int section) {
        return 0;
    }

    public long getItemId(final int section, final int position) {
        return 0;
    }

    @Override
    public long getItemId(final int position) {
        final int sectionIndex = mSectionHeaders.indexOfKey(position);
        if (0 <= sectionIndex) {
            return getSectionItemId(sectionIndex);
        }
        final int section = getSectionForPosition(position);
        final int pos = getPositionWithinSection(section, position);
        return getItemId(section, pos);
    }

    public int getSectionViewType(final int setcion) {
        return 0;
    }

    public int getItemViewType(final int section, final int position) {
        return 0;
    }

    @Override
    public final int getItemViewType(final int position) {
        final int sectionIndex = mSectionHeaders.indexOfKey(position);
        if (0 <= sectionIndex) {
            return getSectionViewType(sectionIndex);
        }
        final int section = getSectionForPosition(position);
        final int pos = getPositionWithinSection(section, position);
        return getItemViewType(section, pos);
    }

    private int getSectionForPosition(final int position) {
        final int index = mSectionHeaders.indexOfKey(position);
        if (0 <= index) {
            return index;
        }

        // linear search
        for (int i = 1; i != mSectionHeaders.size(); ++i) {
            final int sectionPosition = mSectionHeaders.keyAt(i);
            if (position < sectionPosition) {
                return i - 1;
            }
        }
        return mSectionHeaders.size() - 1;
    }

    private int getPositionWithinSection(final int section, final int position) {
        return position - mSectionHeaders.keyAt(section) - 1;
    }
}
