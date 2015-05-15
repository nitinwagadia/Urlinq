package com.example.urlinq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.adapters.ClassFeedListAdapater;
import com.example.model.ClassFeedRecyclerData;

import java.util.ArrayList;
import java.util.List;


public class ClassFeed extends ScrollTabHolderFragment implements AbsListView.OnScrollListener

{

    ListView listView;
    //Button post, ask;
    private List<ClassFeedRecyclerData> data;

    public static Fragment newInstance(int position) {
        ClassFeed classFeed = new ClassFeed();
        return classFeed;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View row = inflater.inflate(R.layout.layout_class_feed, null);
        listView = (ListView) row.findViewById(R.id.ListViewClassFeed);
        View placeHolderView = inflater.inflate(R.layout.view_header_placeholder, listView, false);
        listView.addHeaderView(placeHolderView);
        return row;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnScrollListener(this);
        listView.setAdapter(new ClassFeedListAdapater(getActivity(), getData()));


    }

    @Override
    public void adjustScroll(int scrollHeight) {

        if (scrollHeight == 0 && listView.getFirstVisiblePosition() >= 1) {
            return;
        }

        listView.setSelectionFromTop(1, scrollHeight);

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (mScrollTabHolder != null)
            mScrollTabHolder.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount, 0);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // nothing
    }

    private List<ClassFeedRecyclerData> getData() {
        data = new ArrayList<ClassFeedRecyclerData>();
        int images[] = {R.drawable.cat, R.drawable.chicken, R.drawable.cow,
                R.drawable.dolphin, R.drawable.dog, R.drawable.dolphin, R.drawable.dog, R.drawable.dolphin, R.drawable.dog};
        String title1[] = {"Cat", "Chicken", "Cow", "Crab", "Dog", "Crab", "Dog", "Crab", "Dog"};
        String title2[] = {"Meowwww", "Puck PUCK", "MOWWWWWWWWW", "Tick Tick",
                "Bow wowwwwwwww", "Tick Tick",
                "Bow wowwwwwwww", "Tick Tick",
                "Bow wowwwwwwww"};
        String title3[] = {"now", "now", "now", "now", "now", "now", "now", "now", "now"};
        String title4[] = {"Lecture of Cat", "Lecture of Chicken",
                "Lecture of Cow", "Lecture of Crab", "Lecture of Dog", "Lecture of Crab", "Lecture of Dog", "Lecture of Crab", "Lecture of Dog"};
        String contents[] = {
                "I am CAt and i meow I am CAt and i meowI am CAt and i meowI am CAt and i meowI am CAt and i meowI am CAt and i meow",
                "I am Chicken and i puck puck I am Chicken and i puck puck I am Chicken and i puck puck I am Chicken and i puck puck ",
                "I am Cow and i mow I am Cow and i mow I am Cow and i mow I am Cow and i mowI am Cow and i mow I am Cow and i mow",
                "I am a cran and i tick tock I am a cran and i tick tock I am a cran and i tick tock I am a cran and i tick tockI am a cran",
                "I am a dog and i bow wow I am a dog and i bow wow I am a dog and i bow wow I am a dog and i bow wowI am a dog and i bow wow ",
                "I am a cran and i tick tock I am a cran and i tick tock I am a cran and i tick tock I am a cran and i tick tockI am a cran",
                "I am a dog and i bow wow I am a dog and i bow wow I am a dog and i bow wow I am a dog and i bow wowI am a dog and i bow wow ",
                "I am a cran and i tick tock I am a cran and i tick tock I am a cran and i tick tock I am a cran and i tick tockI am a cran",
                "I am a dog and i bow wow I am a dog and i bow wow I am a dog and i bow wow I am a dog and i bow wowI am a dog and i bow wow "};
        for (int i = 0; i < title1.length; i++) {
            ClassFeedRecyclerData current;
            current = new ClassFeedRecyclerData(images[i], title1[i], title2[i],
                    title3[i], title4[i], contents[i]);
            data.add(current);
        }
        return data;
    }


}
