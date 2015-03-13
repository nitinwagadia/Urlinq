package com.example.urlinq;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.customviews.CustomSlidingTabLayout;
import com.example.urlinq.model.HomeRecyclerViewData;

import java.util.ArrayList;
import java.util.List;

public class HomeFeed extends android.support.v4.app.Fragment {
    private RecyclerView recyclerView;
    private List<HomeRecyclerViewData> data;
    private CustomSlidingTabLayout customSlidingTabLayout;
    private Animation inAnim;
    private Animation outAnim;

    public static HomeFeed getInstance(int id) {
        HomeFeed myFragment = new HomeFeed();
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_home_feed, container,
                false);
        customSlidingTabLayout = (CustomSlidingTabLayout) getActivity().findViewById(R.id.customSlidingTabLayout);
        customSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.feed_tab_color));
        recyclerView = (RecyclerView) layout.findViewById(R.id.HomerecyclerView);
        inAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.abc_slide_in_top);
        outAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.abc_slide_out_top);


        (layout.findViewById(R.id.action_a)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), School.class);
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(getActivity());
                getActivity().startActivity(i, transitionActivityOptions.toBundle());
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
        });
        return layout;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeRecyclerDataAdapter adapter = new HomeRecyclerDataAdapter(getActivity(), getHomeData());
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

    private List<HomeRecyclerViewData> getHomeData() {
        data = new ArrayList<HomeRecyclerViewData>();
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
            HomeRecyclerViewData current;
            current = new HomeRecyclerViewData(images[i], title1[i], title2[i],
                    title3[i], title4[i], contents[i]);
            data.add(current);
        }
        return data;
    }


}