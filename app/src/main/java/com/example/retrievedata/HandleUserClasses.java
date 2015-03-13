package com.example.retrievedata;

import android.util.Log;

import com.example.urlinq.R;
import com.example.urlinq.model.RecyclerViewData;

import org.json.JSONObject;

import java.util.List;

public class HandleUserClasses {

    List<RecyclerViewData> listdata;
    String userClasses = "";

    public HandleUserClasses(String userClasses, List<RecyclerViewData> listdata) {
        this.userClasses = userClasses;
        this.listdata = listdata;
    }

    public List<RecyclerViewData> parseJSON() {

        JSONObject jsonObject;
        int images[] = {R.drawable.cow, R.drawable.cat, R.drawable.dog,
                R.drawable.dolphin, R.drawable.gorilla};
        boolean notify[] = {true, false, false, false, true};
        String notifycount[] = {"20", "0", "0", "0", "10"};
        String className[] = {"Theories of the french Republic", "Computer Biology", "Principles of Supply and Demand", "Graphical Computing"};

//Important for JSON parsing
        /*
        try {
			jsonObject = new JSONObject(userClasses);
			JSONArray jsonArray = jsonObject.getJSONArray("classes");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject clubsData = jsonArray.getJSONObject(i);
				RecyclerViewData recyclerViewData = new RecyclerViewData(
						images[i], clubsData.getString("class_name"),
						notifycount[i], notify[i]);

				listdata.add(recyclerViewData);
				Log.i("Data added is", recyclerViewData.getMiddleString());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        // Temporary solution as API KEY not working
        for (int i = 0; i < 4; i++) {

            RecyclerViewData recyclerViewData = new RecyclerViewData(
                    images[i], className[i],
                    notifycount[i], notify[i]);
            listdata.add(recyclerViewData);
            Log.i("Data added is", recyclerViewData.getMiddleString());

        }

        return listdata;
    }

}
