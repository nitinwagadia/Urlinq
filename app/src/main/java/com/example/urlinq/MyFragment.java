package com.example.urlinq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MyFragment extends ScrollTabHolderFragment implements OnScrollListener {

    private static final String ARG_POSITION = "position";
    Button b1, b2;
    private ListView mListView;
    private ArrayList<String> mListItems;
    private int mPosition;

    public static Fragment newInstance(int position) {
        MyFragment f = new MyFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.testing, container, false);
        b1 = (Button) v.findViewById(R.id.button1);
        // b2= (Button) v.findViewById(R.id.button2);
        // View placeHolderView = inflater.inflate(R.layout.view_header_placeholder, mListView, false);
        // mListView.addHeaderView(placeHolderView);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Department.class);
                startActivity(i);
            }
        });


    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public void adjustScroll(int ScrollHeight) {

    }
}