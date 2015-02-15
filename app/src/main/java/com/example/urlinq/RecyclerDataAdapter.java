package com.example.urlinq;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.urlinq.RecyclerDataAdapter.MyRecyclerViewHolder;
import com.example.urlinq.model.RecyclerViewData;

import java.util.Collections;
import java.util.List;

public class RecyclerDataAdapter extends
        RecyclerView.Adapter<MyRecyclerViewHolder> {
    private List<RecyclerViewData> data = Collections.emptyList();
    private LayoutInflater inflator;
    private Context context;

    public RecyclerDataAdapter(Context context, List<RecyclerViewData> data) {

        this.context = context;
        this.data = data;
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.recycler_layout, parent, false);
        MyRecyclerViewHolder holder = new MyRecyclerViewHolder(view);
        Log.i("I am In", "OnCREATEVIEWHOLDER");
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        RecyclerViewData current = data.get(position);
        Typeface custom = Typeface.createFromAsset(context.getResources().getAssets(), "fonts/Roboto-Light.ttf");
        if (current.getHeader() == null) {

            holder.headerLayout.setVisibility(LinearLayout.INVISIBLE);
            holder.image.setImageResource(current.getImageId());
            holder.middleString.setText(current.getMiddleString());
            holder.middleString.setTypeface(custom);
            if (current.getIsNotificationVisible()) {
                holder.notification.setText(current.getNotificationString());
                holder.notification.setBackgroundResource(R.drawable.list_notification);
            } else {
                holder.notification.setText("");
            }
            Log.i("The data passed to holder is ", current.getImageId() + "-->" + current.getMiddleString() + "+-+-+" + current.getHeader());
        } else {
            holder.itemLayout.setVisibility(LinearLayout.INVISIBLE);
            holder.header.setText(current.getHeader());
            Log.i("The header is outtt ", current.getHeader() + "->" + current.getMiddleString() + "->>>?" + current.getHeader());
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView middleString, notification, header;
        ImageView image;
        LinearLayout headerLayout, itemLayout;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            middleString = (TextView) itemView
                    .findViewById(R.id.RecyclerMiddleString);
            notification = (TextView) itemView
                    .findViewById(R.id.RecyclerNotification);
            image = (ImageView) itemView.findViewById(R.id.RecyclerImage);
            headerLayout = (LinearLayout) itemView.findViewById(R.id.headerLayout);
            itemLayout = (LinearLayout) itemView.findViewById(R.id.itemLayout);
            header = (TextView) itemView.findViewById(R.id.header);
            itemLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You have Clicked on " + data.get(getPosition()).getMiddleString(), Toast.LENGTH_SHORT).show();

        }

    }
}


