package com.example.retrievedata;

import android.util.Log;

import com.example.urlinq.R;
import com.example.urlinq.model.RecyclerViewData;

import org.json.JSONArray;
import org.json.JSONException;
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
		int images[] = { R.drawable.cow, R.drawable.cat, R.drawable.dog,
				R.drawable.dolphin, R.drawable.gorilla };
		boolean notify[] = { true, false, false, false, true };
		String notifycount[] = { "20", "0", "0", "0", "10" };

		try {
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
		}

		return listdata;

	}

}
