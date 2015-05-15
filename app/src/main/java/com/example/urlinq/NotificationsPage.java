package com.example.urlinq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.adapters.NotificationRecyclerDataAdapter;
import com.example.customviews.CustomSlidingTabLayout;
import com.example.model.NotificationRecyclerData;

import java.util.ArrayList;
import java.util.List;


public class NotificationsPage extends Fragment {

    public static final int TYPE_NOTIFICATION = 1;
    public static final int TYPE_FOLLOW = 2;
    public static final int TYPE_EVENT = 3;
    RecyclerView recyclerView;
    private CustomSlidingTabLayout customSlidingTabLayout;
    private Animation inAnim, outAnim;
    private List<NotificationRecyclerData> data;


    public static NotificationsPage getInstance(int position) {
        NotificationsPage myFragment = new NotificationsPage();
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_notifications_page, container,
                false);

        customSlidingTabLayout = (CustomSlidingTabLayout) getActivity().findViewById(R.id.customSlidingTabLayout);
        customSlidingTabLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        recyclerView = (RecyclerView) layout.findViewById(R.id.notificationList);
        inAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.abc_slide_in_top);
        outAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.abc_slide_out_top);


/*        (layout.findViewById(R.id.action_a)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.translate_floating_button);
                v.startAnimation(animation);
                Intent i = new Intent(getActivity(), School.class);
                startActivity(i);
            }
        });


        (layout.findViewById(R.id.action_b)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.translate_floating_button);
                v.startAnimation(animation);
            }
        });


        (layout.findViewById(R.id.action_c)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.translate_floating_button);
                v.startAnimation(animation);
            }
        });*/
        return layout;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        NotificationRecyclerDataAdapter adapter = new NotificationRecyclerDataAdapter(getActivity(), NotificationPageData());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 20) {

                    if (customSlidingTabLayout.getVisibility() == View.VISIBLE) {
                        hideView();
                    }
                } else if (dy < -3) {
                    if (customSlidingTabLayout.getVisibility() == View.GONE)
                        showView();

                }
            }

        });

    }

    private void hideView() {
        customSlidingTabLayout.startAnimation(outAnim);
        customSlidingTabLayout.setVisibility(View.GONE);
    }

    private void showView() {

        customSlidingTabLayout.startAnimation(inAnim);
        customSlidingTabLayout.setVisibility(View.VISIBLE);
    }

    private List<NotificationRecyclerData> NotificationPageData() {
        data = new ArrayList<NotificationRecyclerData>();
        int images[] = {R.drawable.cat, R.drawable.chicken, R.drawable.cow,
                R.drawable.dolphin, R.drawable.dog, R.drawable.dolphin, R.drawable.dog, R.drawable.dolphin, R.drawable.dog};
        String time[] = {"now", "now", "30 minutes ago", "2 hours ago", "3 hours ago", "Yesterday", "Yesterday", "03/17/2015", "03/15/2015"};
        boolean now[] = {true, true, false, false, false, false, false, false, false};
        int notificationType[] = {TYPE_FOLLOW, TYPE_NOTIFICATION, TYPE_EVENT,
                TYPE_EVENT, TYPE_FOLLOW, TYPE_NOTIFICATION,
                TYPE_FOLLOW, TYPE_NOTIFICATION, TYPE_FOLLOW};

        String content[] = {"Notification from Prof. XYZ for class ABC", "XYZ invited you to event ABC",
                "Notification from Prof. XYZ for class ABC", "XYZ invited you to event ABC",
                "Notification from Prof. XYZ for class ABC", "XYZ invited you to event ABC",
                "Notification from Prof. XYZ for class ABC", "XYZ invited you to event ABC",
                "Notification from Prof. XYZ for class ABC"};

        for (int i = 0; i < images.length; i++) {
            NotificationRecyclerData current;
            current = new NotificationRecyclerData(images[i], content[i], notificationType[i], time[i], now[i]);
            data.add(current);
        }
        return data;
    }

}
