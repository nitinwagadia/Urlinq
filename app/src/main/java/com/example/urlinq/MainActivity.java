package com.example.urlinq;
//test of Verion control

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrievedata.HandleUserClasses;
import com.example.retrievedata.HandleUserClubs;
import com.example.urlinq.model.HomeRecyclerViewData;
import com.example.urlinq.model.RecyclerViewData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    public static List<RecyclerViewData> listdata;
    private Toolbar toolbar;
    private DrawerLayout drawerlayout;
    private RecyclerView recyclerView;
    private List<HomeRecyclerViewData> data;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        // Home Screen Set up
        recyclerView = (RecyclerView) findViewById(R.id.HomerecyclerView);
        HomeRecyclerDataAdapter adapter = new HomeRecyclerDataAdapter(this, getHomeData());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        //toolbar setup
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.actionbaricon);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Campus Feed");
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_drawer_start);
        drawerFragment.setUp(drawerlayout, toolbar);

        //findViewById(R.id.fab_expand_menu_button).;


        (findViewById(R.id.action_a)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.translate_floating_button);
                v.startAnimation(animation);
                Intent i = new Intent(MainActivity.this, School.class);
                startActivity(i);
            }
        });


        (findViewById(R.id.action_b)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.translate_floating_button);
                v.startAnimation(animation);
            }
        });


        (findViewById(R.id.action_c)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.translate_floating_button);
                v.startAnimation(animation);
            }
        });

    }

    public void clicked(View v) {
        if (v.getId() == R.id.School) {
            Toast.makeText(this, "School", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, School.class));

        }
        if (v.getId() == R.id.department)
            Toast.makeText(this, "Department", Toast.LENGTH_SHORT).show();


    }

    private List<HomeRecyclerViewData> getHomeData() {
        data = new ArrayList<HomeRecyclerViewData>();
        int images[] = {R.drawable.cat, R.drawable.chicken, R.drawable.cow,
                R.drawable.dolphin, R.drawable.dog};
        String title1[] = {"Cat", "Chicken", "Cow", "Crab", "Dog"};
        String title2[] = {"Meowwww", "Puck PUCK", "MOWWWWWWWWW", "Tick Tick",
                "Bow wowwwwwwww"};
        String title3[] = {"now", "now", "now", "now", "now"};
        String title4[] = {"Lecture of Cat", "Lecture of Chicken",
                "Lecture of Cow", "Lecture of Crab", "Lecture of Dog"};
        String contents[] = {
                "I am CAt and i meow I am CAt and i meowI am CAt and i meowI am CAt and i meowI am CAt and i meowI am CAt and i meow",
                "I am Chicken and i puck puck I am Chicken and i puck puck I am Chicken and i puck puck I am Chicken and i puck puck ",
                "I am Cow and i mow I am Cow and i mow I am Cow and i mow I am Cow and i mowI am Cow and i mow I am Cow and i mow",
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Toolbar Success", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class ListData extends AsyncTask<String, Integer, Void> {

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

}