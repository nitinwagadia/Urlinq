package com.example.urlinq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tabs.SlidingTabLayout;

public class School extends ActionBarActivity {
    private SlidingTabLayout mTabs;
    private ViewPager mPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_layout);
        toolbar = (Toolbar) findViewById(R.id.schooltoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTabs = (SlidingTabLayout) findViewById(R.id.slidingTabs);
        mTabs.setDistributeEvenly(true);
        mPager = (ViewPager) findViewById(R.id.ViewPager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs.setViewPager(mPager);
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {

                return getResources().getColor(R.color.SlidingTabColor);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);

        }
        return super.onOptionsItemSelected(item);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String tabs[] = {"Announcements", "Departments", "Clubs", "Members",
                "A", "B", "C"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Announcement mAnnouncement = new Announcement();
                    return mAnnouncement;

                case 1:
                    Clubs mClubs = new Clubs();
                    return mClubs;

                default:
                    MyFragment myFragment = MyFragment.getInstance(position);
                    return myFragment;

            }

        }

        @Override
        public CharSequence getPageTitle(int position) {
            // TODO Auto-generated method stub
            return tabs[position];
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

    }

    public static class MyFragment extends Fragment {

        private TextView textView;

        public static MyFragment getInstance(int position) {
            MyFragment myFragment = new MyFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            myFragment.setArguments(args);
            return myFragment;

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.announcements, container,
                    false);
            textView = (TextView) layout.findViewById(R.id.textViewFrag);
            Bundle bundle = getArguments();
            if (bundle != null) {

                textView.setText("You are on Page number "
                        + bundle.getInt("position"));
            }

            return layout;
        }

    }

}
