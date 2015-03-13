package com.example.urlinq;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.customviews.CustomSlidingTabLayout;


public class EventsPage extends Fragment {


    private CustomSlidingTabLayout customSlidingTabLayout;

    public static EventsPage getInstance(int position) {
        EventsPage myFragment = new EventsPage();
        return myFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Resummee", "EventsPage");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Destroy", "EventsPage");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Pause", "EventsPage");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Detached", "EventsPage");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_events_page, container,
                false);
        customSlidingTabLayout = (CustomSlidingTabLayout) getActivity().findViewById(R.id.customSlidingTabLayout);
        customSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.planner_tab_color));

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("ViewRestored", "Events");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("Attach", "Events");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("Configuration", "Events");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Start", "Events");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Stop", "Events");
    }
}
