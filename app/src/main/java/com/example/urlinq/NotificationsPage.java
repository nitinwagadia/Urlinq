package com.example.urlinq;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.customviews.CustomSlidingTabLayout;


public class NotificationsPage extends Fragment {

    private CustomSlidingTabLayout customSlidingTabLayout;

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
    public void onResume() {
        super.onResume();
        Log.i("Resummee", "Notification");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Destroy", "Notification");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Pause", "Notification");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Detached", "Notification");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("Attach", "Notification");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("Configuration", "Notification");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Start", "Notification");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Stop", "Notification");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("ViewRestored", "Notification");

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


}
