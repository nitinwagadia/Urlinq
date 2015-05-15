package com.example.urlinq;

import android.widget.AbsListView;

/**
 * Created by nitin on 2/13/15.
 */
public interface ScrollTabHolder {

    void adjustScroll(int ScrollHeight);

    void onScroll(AbsListView view, int firstVisibleItem, int VisibleItemCount, int totalItemCount, int pagePosition);
}
