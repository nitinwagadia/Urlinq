package com.example.urlinq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.adapters.ClassMembersListAdapater;
import com.example.model.ClassMemberData;

import java.util.ArrayList;
import java.util.List;


public class ClassMembers extends ScrollTabHolderFragment implements AbsListView.OnScrollListener

{

    //private ArrayList<String> mListItems;

    public static final int MEMBER_VIEW = 0;
    public static final int MEMBER_VALUE = 10;
    public static final int ADMIN_VALUE = 20;
    public static final int MEMBER = 0;
    public static final int ADMIN = 1;
    ListView listViews;
    private ArrayList<ClassMemberData> data;

    public static Fragment newInstance() {
        ClassMembers classMembers = new ClassMembers();
        return classMembers;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View row = inflater.inflate(R.layout.layout_class_members, null);
        listViews = (ListView) row.findViewById(R.id.listViewClassMembers);
        View placeHolderView = inflater.inflate(R.layout.view_header_placeholder, listViews, false);
        listViews.addHeaderView(placeHolderView);
        return row;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*mListItems = new ArrayList<String>();

        for (int i = 1; i <= 100; i++) {
            mListItems.add(i + ". item - currnet page: " );
        }*/
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listViews.setOnScrollListener(this);
        listViews.setAdapter(new ClassMembersListAdapater(getActivity(), getData()));
        //listViews.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, android.R.id.text1, mListItems));
    }


    @Override
    public void adjustScroll(int scrollHeight) {

        if (scrollHeight == 0 && listViews.getFirstVisiblePosition() >= 1) {
            return;
        }

        listViews.setSelectionFromTop(1, scrollHeight);

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (mScrollTabHolder != null)
            mScrollTabHolder.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount, 1);


    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // nothing
    }


    private List<ClassMemberData> getData() {
        data = new ArrayList<ClassMemberData>();

        int memberType[] = {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0};
        String memberName[] = {"James", "Kerry", "Phil", "Rogers", "Andrew Flintop Tendulkar", "Hazard", "Oscar", "Lampard", "Terry", "Drogba", "Torres"};
        int images[] = {R.drawable.cat, R.drawable.chicken, R.drawable.cow,
                R.drawable.dolphin, R.drawable.dog, R.drawable.dolphin, R.drawable.dog, R.drawable.dolphin, R.drawable.dolphin, R.drawable.dog, R.drawable.dolphin};
        ClassMemberData current;
        current = new ClassMemberData(ADMIN_VALUE);
        data.add(current);

        for (int i = 0; i < memberType.length; i++) {
            if (memberType[i] == ADMIN) {
                current = new ClassMemberData(ADMIN, memberName[i], images[i], MEMBER_VIEW);
                data.add(current);
            }
        }
        current = new ClassMemberData(MEMBER_VALUE);
        data.add(current);

        for (int i = 0; i < memberType.length; i++) {
            if (memberType[i] == MEMBER) {
                current = new ClassMemberData(MEMBER, memberName[i], images[i], MEMBER_VIEW);
                data.add(current);
            }
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getViewtype() == (ADMIN_VALUE) || data.get(i).getViewtype() == (MEMBER_VALUE))
                Log.i("I am Seprartor", data.get(i).getViewtype() + "");
            else
                Log.i("I am Member", data.get(i).getMemberType() + "");

        }
        return data;
    }


}
