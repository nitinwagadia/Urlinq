package com.example.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapters.RecyclerDataAdapter.MyRecyclerViewHolder;
import com.example.model.RecyclerViewData;
import com.example.urlinq.Classes;
import com.example.urlinq.R;

import java.util.Collections;
import java.util.List;


public class RecyclerDataAdapter extends
        RecyclerView.Adapter<MyRecyclerViewHolder> {
    private List<RecyclerViewData> data = Collections.emptyList();
    private LayoutInflater inflator;
    private Context context;
    private int lastposition = -1;

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


        //setAnimation(holder.container,position);

    }

    private void setAnimation(RelativeLayout container, int position) {

        if (position > lastposition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.animation_navigation_drawer);
            container.startAnimation(animation);
            lastposition = position;
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView middleString, notification, header;
        ImageView image;
        RelativeLayout container;
        LinearLayout headerLayout, itemLayout;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            container = (RelativeLayout) itemView.findViewById(R.id.container);
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

            int type = data.get(getPosition()).getType();
            if (type == 0) {
                Toast.makeText(context, "You have Clicked on " + data.get(getPosition()).getMiddleString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, Classes.class);
                i.putExtra("Name", data.get(getPosition()).getMiddleString());
                View sharedView = middleString;
                String transitionName = "test";
                if (Build.VERSION.SDK_INT >= 19) {
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, sharedView, transitionName);
                    context.startActivity(i, transitionActivityOptions.toBundle());
                } else {
                    context.startActivity(i);
                }
            } else {
                Toast.makeText(context, "You have Clicked on " + data.get(getPosition()).getMiddleString(), Toast.LENGTH_SHORT).show();
                //context.startActivity(new Intent(context,Classes.class));

            }
        }
    }
}


