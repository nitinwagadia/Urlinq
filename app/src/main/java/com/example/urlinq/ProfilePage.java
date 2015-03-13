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


public class ProfilePage extends Fragment {


    private CustomSlidingTabLayout customSlidingTabLayout;

    public static ProfilePage getInstance(int position) {
        ProfilePage myFragment = new ProfilePage();
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_profile_page, container,
                false);

        customSlidingTabLayout = (CustomSlidingTabLayout) getActivity().findViewById(R.id.customSlidingTabLayout);
        customSlidingTabLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));

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
        Log.i("Resummee", "Profile");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Destroy", "Profile");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Pause", "Profile");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Detached", "Profile");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("ViewRestored", "Profile");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("Attach", "Profile");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("Configuration", "Profile");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Start", "Profile");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Oncreate", "Profile");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Stop", "Profile");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


}
