package com.example.urlinq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Clubs extends Fragment {

    ListView list;
    ArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.testlayout, container, false);

        list = (ListView) layout.findViewById(R.id.listView);
        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String test[] = {"A", "B", "C", "D", "E", "F", "G"};
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, test);
        list.setAdapter(adapter);


    }
}
