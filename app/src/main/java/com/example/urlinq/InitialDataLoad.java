package com.example.urlinq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.RecyclerViewData;
import com.example.retrievedata.HandleUserClasses;
import com.example.retrievedata.HandleUserClubs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InitialDataLoad extends Activity {
    public static List<RecyclerViewData> listdata;
    static int count = 0;
    int drawable[] = {R.drawable.background, R.drawable.background1, R.drawable.background2};
    String universityNames[] = {"New York Univeristy", "Columbia Unversity", "Pace University"};
    String departmentNames[] = {"Computer Science and Engineering", "Mathematics ", "Finances"};
    Button b;
    LoadData d;
    RelativeLayout rl;
    TextView universityName, departmentName;
    Button signup, login;
    EditText username, password;
    String userClass = "https://urlinq.com/urlinqyii/api/getUserClasses/?user_id=7&token=12435362";
    String userClubs = "https://urlinq.com/urlinqyii/api/getUserClubs/?user_id=7&token=12435362";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = (Button) findViewById(R.id.SignIn);
        boolean flag = CheckSharedPreferences();
        d = new LoadData();
        Toast.makeText(this, flag + "", Toast.LENGTH_SHORT).show();
        if (flag) {
            setContentView(R.layout.initialloadscreen);
            d.execute(userClass, userClubs);
        } else {
            setContentView(R.layout.onboarding_first_page);
            rl = (RelativeLayout) findViewById(R.id.relativeLayoutOnBoarding);
            universityName = (TextView) findViewById(R.id.universityName);
            departmentName = (TextView) findViewById(R.id.departmentName);
            Log.i("Id of University is", universityName + "");
            universityName.setText(universityNames[count]);
            departmentName.setText(departmentNames[count]);
            signup = (Button) findViewById(R.id.signup);
            login = (Button) findViewById(R.id.login);
            changeBackgroundImage(count + 1);


        }
    }

    void changeBackgroundImage(int count) {

        new Handler().postDelayed(new Runnable() {
            public void run() {
                int count = InitialDataLoad.count;
                count = count % drawable.length;
                rl.setBackgroundResource(drawable[count]);

                Log.i("uni and Dept  is ", universityNames[count] + " " + departmentNames[count]);
                universityName.setText(universityNames[count]);
                departmentName.setText(departmentNames[count]);
                InitialDataLoad.count = count + 1;
                Log.i("Count is ", count + "");
                changeBackgroundImage(count);
            }
        }, 1000);
    }

    private boolean CheckSharedPreferences() {
        SharedPreferences prefs = getSharedPreferences("LoginCredentials",
                MODE_PRIVATE);
        String uname = prefs.getString("username", "ERR");
        String pass = prefs.getString("password", "ERR");

        if (uname.equals("ERR") || pass.equals("ERR"))
            return false;

        return true;
    }

    public void click(View v) {
        //  Intent i=new Intent(getApplicationContext(),MainActivity.class);
        d.execute(userClass, userClubs);
        // startActivity(i);
        //finish();
    }

    public void ButtonClick(View v) {
        username = (EditText) findViewById(R.id.UsernameEdit);
        password = (EditText) findViewById(R.id.PasswordEdit);
        SharedPreferences sp = getSharedPreferences("LoginCredentials",
                MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();
        LoadData d = new LoadData();
        d.execute(userClass, userClubs);

    }

    class LoadData extends AsyncTask<String, Integer, Void> {

        Context context = getBaseContext();

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
            if (!CheckConnection()) {
                Toast.makeText(context, "No Connection", Toast.LENGTH_LONG)
                        .show();
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
            String userClubs = "", userClasses = "", data = "";

            try {
              /*  url = new URL(params[0]);
                con = null;
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
                con = null;
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
                */

                recyclerViewData = new RecyclerViewData("MY CLASSES");
                listdata.add(recyclerViewData);
                HandleUserClasses ucl = new HandleUserClasses(userClasses,
                        listdata);
                listdata = ucl.parseJSON();

                recyclerViewData = new RecyclerViewData("MY CLUBS");
                listdata.add(recyclerViewData);

                HandleUserClubs uc = new HandleUserClubs(userClubs, listdata);
                listdata = uc.ParseJson();

                //recyclerViewData = new RecyclerViewData("MY TEAMS");
                //listdata.add(recyclerViewData);


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void result) {
            Intent i = new Intent(context, MainActivity.class);
            startActivity(i);
            finish();
        }

    }
}
