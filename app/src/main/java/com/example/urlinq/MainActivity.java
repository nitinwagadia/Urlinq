package com.example.urlinq;
//test of Verion control

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Visibility;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customviews.CustomSlidingTabLayout;
import com.example.customviews.CustomViewPager;
import com.example.model.HomeRecyclerViewData;
import com.example.model.RecyclerViewData;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    public static List<RecyclerViewData> listdata;
    private Toolbar toolbar;
    private DrawerLayout drawerlayout;
    private List<HomeRecyclerViewData> data;
    private SearchView searchView;
    private CustomSlidingTabLayout customSlidingTabLayout;
    private int colors[] = {android.R.color.holo_purple, android.R.color.holo_orange_dark, android.R.color.holo_blue_dark, android.R.color.holo_red_light};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 19) {
            setupWindowAnimations();
        }
        searchView = (SearchView) findViewById(R.id.searchView1);
        searchView.setQueryHint("Search for classes,clubs and people");
        int searchPlateId = searchView.getContext().getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        View searchPlate = searchView.findViewById(searchPlateId);
        int searchTextId = searchPlate.getContext().getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        TextView searchText = (TextView) searchPlate.findViewById(searchTextId);
        searchText.setTextSize(10);
        searchText.setHintTextColor(getResources().getColor(
                R.color.searchTextColor));
        searchText.setTextColor(getResources()
                .getColor(R.color.searchTextColor));

        //toolbar setup
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Campus Feed");
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_drawer_start);
        drawerFragment.setUp(drawerlayout, toolbar);

        setCustomViewPager();

    }

    private void setupWindowAnimations() {
        Explode explode = new Explode();
        explode.setDuration(1000);

        getWindow().setExitTransition(explode);

        Fade fade = new Fade(Visibility.MODE_OUT);
        fade.setDuration(500);
        getWindow().setReenterTransition(fade);
    }

    private void setCustomViewPager() {


        customSlidingTabLayout = (CustomSlidingTabLayout) findViewById(R.id.customSlidingTabLayout);
        customSlidingTabLayout.setCustomTabView(R.layout.custom_sliding_tab_layout, R.id.TabText);
        customSlidingTabLayout.setDistributeEvenly(true);
        CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.customViewPager);
        customViewPager.setAdapter(new MyHomePagerAdapter(getSupportFragmentManager()));
        customSlidingTabLayout.setCustomTabView(R.layout.custom_sliding_tab_layout, R.id.TabText);
        customSlidingTabLayout.setSelectedIndicatorColors(colors);
        customSlidingTabLayout.setViewPager(customViewPager);


    }

    public void clicked(View v) {
        if (v.getId() == R.id.School) {
            Toast.makeText(this, "School", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, School.class));

        }
        if (v.getId() == R.id.department)
            startActivity(new Intent(this, Department.class));
            Toast.makeText(this, "Department", Toast.LENGTH_SHORT).show();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Toolbar Success", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

   /* class ListData extends AsyncTask<String, Integer, Void> {

        public boolean CheckConnection() {
            boolean flag = false;

            ConnectivityManager check = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info[] = check.getAllNetworkInfo();
            for (int i = 0; i < info.length; i++) {
                Log.i("Checking ------>", info[i] + " for Connection");

                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    flag = true;
                    Log.i("Yoo!!!!!--------------->>>>!", info[i]
                            + " is connectd!!!!!!");
                    break;
                }

            }
            return flag;
        }

        @Override
        protected void onPreExecute() {
            Context context = getBaseContext();
            if (!CheckConnection()) {
                Log.i("No Connection<><><><><><><>", "Available");
            }
        }

        @Override
        protected Void doInBackground(String... params) {

            listdata = new ArrayList<RecyclerViewData>();
            RecyclerViewData recyclerViewData;
            URL url;
            InputStream in;
            BufferedReader reader;
            HttpURLConnection con;
            String userClubs = "", userClasses = "", data;

            try {
                url = new URL(params[0]);
                con = (HttpURLConnection) url.openConnection();
                con.connect();
                in = con.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                data = reader.readLine();
                while (data != null) {
                    userClasses += data + "\n";
                    data = reader.readLine();
                }

                url = new URL(params[1]);
                con = (HttpURLConnection) url.openConnection();
                con.connect();
                in = con.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                data = reader.readLine();
                while (data != null) {
                    userClubs += data + "\n";
                    data = reader.readLine();
                }
                Log.i("UserClassesData Recieved is<<<<<<---->>>>>> ",
                        userClasses);
                Log.i("UserClubsData Recieved is<<<<<<---->>>>>> ", userClubs);

                recyclerViewData = new RecyclerViewData("MY CLASSES");
                listdata.add(recyclerViewData);
                HandleUserClasses ucl = new HandleUserClasses(userClasses,
                        listdata);
                listdata = ucl.parseJSON();

                recyclerViewData = new RecyclerViewData("MY CLUBS");
                listdata.add(recyclerViewData);

                HandleUserClubs uc = new HandleUserClubs(userClubs, listdata);
                listdata = uc.ParseJson();


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void result) {

        }
    }
*/

    private class MyHomePagerAdapter extends FragmentPagerAdapter {

        String tabs[] = {"Home", "Events", "Notification", "Profile"};

        public MyHomePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            switch (position) {
                case 0:
                    HomeFeed fragment = HomeFeed.getInstance(position);
                    return fragment;

                case 1:
                    EventsPage eventsPage = EventsPage.getInstance(position);
                    return eventsPage;

                case 2:
                    NotificationsPage notificationsPage = NotificationsPage.getInstance(position);
                    return notificationsPage;

                case 3:
                    ProfilePage profilePage = ProfilePage.getInstance(position);
                    return profilePage;
            }

            return null;
        }


        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            int drawable[] = {R.drawable.cat, R.drawable.cow, R.drawable.gorilla, R.drawable.dog};
            Drawable icon = getResources().getDrawable(drawable[position]);
            icon.setBounds(0, 0, 40, 40);
            SpannableString spannableString = new SpannableString(" ");
            ImageSpan imageSpan = new ImageSpan(icon);
            spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return spannableString;

            // return tabs[position];

        }


    }


}