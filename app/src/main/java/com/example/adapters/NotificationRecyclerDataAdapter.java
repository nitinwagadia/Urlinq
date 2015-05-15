package com.example.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.model.NotificationRecyclerData;
import com.example.urlinq.NotificationsPage;
import com.example.urlinq.R;

import java.util.Collections;
import java.util.List;


public class NotificationRecyclerDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    Context context;
    List<NotificationRecyclerData> data = Collections.emptyList();
    LayoutInflater inflater;

    public NotificationRecyclerDataAdapter(Context context, List<NotificationRecyclerData> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == TYPE_ITEM) {
            view = inflater.inflate(R.layout.layout_notification_page_card, parent, false);
            NotificationViewHolder holder = new NotificationViewHolder(view);
            return holder;
        } else if (viewType == TYPE_HEADER) {
            view = inflater.inflate(R.layout.header, parent, false);
            NotificationRecyclerHeaderHolder headerHolder = new NotificationRecyclerHeaderHolder(view);
            return headerHolder;
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NotificationViewHolder) {
            NotificationRecyclerData current = data.get(position - 1);
            ((NotificationViewHolder) holder).notificationTime.setText(current.getNotificationTime());
            ((NotificationViewHolder) holder).notificationImage.setImageResource(current.getImageId());
            if (!current.isNew()) {
                ((NotificationViewHolder) holder).newText.setVisibility(View.GONE);
            }

            if (current.getNotificationtype() == NotificationsPage.TYPE_NOTIFICATION) {
                ((NotificationViewHolder) holder).layoutWithButton.setVisibility(View.GONE);
                ((NotificationViewHolder) holder).notificationContentWB.setText(current.getNotificationContent());
            } else {
                ((NotificationViewHolder) holder).layoutWithoutButton.setVisibility(View.GONE);
                ((NotificationViewHolder) holder).notificationContentWoB.setText(current.getNotificationContent());

                if (current.getNotificationtype() == NotificationsPage.TYPE_FOLLOW) {
                    // Change Drawable
                } else {
                    //Chnage Border Around the Button
                }

            }
        } else if (holder instanceof NotificationRecyclerHeaderHolder) {

        }


    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    class NotificationViewHolder extends RecyclerView.ViewHolder {
        ImageView notificationImage;
        TextView notificationContentWB, notificationContentWoB;
        TextView notificationTime;
        TextView newText;
        ImageButton follow;
        LinearLayout layoutWithButton, layoutWithoutButton;

        public NotificationViewHolder(View itemView) {
            super(itemView);
            notificationImage = (ImageView) itemView.findViewById(R.id.NotificationImage);
            notificationContentWB = (TextView) itemView.findViewById(R.id.NotificationContentWB);
            notificationContentWoB = (TextView) itemView.findViewById(R.id.NotificationContentWOB);
            notificationTime = (TextView) itemView.findViewById(R.id.Notificationtime);
            newText = (TextView) itemView.findViewById(R.id.TextViewNew);
            follow = (ImageButton) itemView.findViewById(R.id.followButton);
            layoutWithButton = (LinearLayout) itemView.findViewById(R.id.LinearLayoutWithButton);
            layoutWithoutButton = (LinearLayout) itemView.findViewById(R.id.LinearLayoutWithoutButton);

        }
    }

    class NotificationRecyclerHeaderHolder extends RecyclerView.ViewHolder {
        public NotificationRecyclerHeaderHolder(View itemView) {
            super(itemView);
        }
    }
}
