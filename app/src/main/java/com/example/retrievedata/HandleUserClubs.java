package com.example.retrievedata;

import android.util.Log;

import com.example.model.RecyclerViewData;
import com.example.urlinq.R;

import org.json.JSONObject;

import java.util.List;

public class HandleUserClubs {
    List<RecyclerViewData> listdata;
    String webpage = "";

    public HandleUserClubs(String webpage, List<RecyclerViewData> listdata) {
        this.webpage = webpage;
        this.listdata = listdata;
    }

    public List<RecyclerViewData> ParseJson() {
        JSONObject jsonObject;
        int images[] = {R.drawable.cat, R.drawable.dog,
                R.drawable.dolphin, R.drawable.gorilla};
        boolean notify[] = {true, false, false, false, true};
        String notifycount[] = {"20", "0", "0", "0", "10"};
        String clubsName[] = {"CLUB CAT", "CLUB DOG", "CLUB DOLPHIN", "CLUB GORILLA"};

		/*try {
            jsonObject = new JSONObject(webpage);
			JSONArray jsonArray = jsonObject.getJSONArray("clubs");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject clubsData = jsonArray.getJSONObject(i);
				RecyclerViewData recyclerViewData = new RecyclerViewData(
						images[(i * 2) % images.length],
						clubsData.getString("group_name"), 0 + "", false);
				listdata.add(recyclerViewData);

				Log.i("Data added is", recyclerViewData.getMiddleString());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        for (int i = 0; i < 4; i++) {
            RecyclerViewData recyclerViewData = new RecyclerViewData(
                    images[(i * 2) % images.length],
                    clubsName[i], 0 + "", false, 1);
            listdata.add(recyclerViewData);

            Log.i("Data added is", recyclerViewData.getMiddleString());
        }
        return listdata;


    }
}
