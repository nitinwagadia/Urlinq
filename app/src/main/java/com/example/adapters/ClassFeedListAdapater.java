package com.example.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.ClassFeedRecyclerData;
import com.example.urlinq.R;

import java.util.List;


public class ClassFeedListAdapater extends BaseAdapter {

    Context context;
    List<ClassFeedRecyclerData> data;
    LayoutInflater inflater;

    public ClassFeedListAdapater(Context context, List<ClassFeedRecyclerData> objects) {
        this.data = objects;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ClassFeedViewHolder holder;

        if (row == null) {
            row = inflater.inflate(R.layout.class_feed_card, null);
            holder = new ClassFeedViewHolder();
            holder.title1 = (TextView) row.findViewById(R.id.title1);
            holder.title2 = (TextView) row.findViewById(R.id.title2);
            holder.title3 = (TextView) row.findViewById(R.id.title3);
            holder.title4 = (TextView) row.findViewById(R.id.title4);
            holder.contents = (TextView) row.findViewById(R.id.contents);
            holder.image = (ImageView) row.findViewById(R.id.image);
            holder.addButton = (Button) row.findViewById(R.id.add);
            holder.CommentButton = (Button) row.findViewById(R.id.comment);
            holder.card = (CardView) row.findViewById(R.id.card_view);
            row.setTag(holder);
        } else {
            holder = (ClassFeedViewHolder) row.getTag();
        }

        ClassFeedRecyclerData current = data.get(position);
        holder.image.setImageResource(current.getImageId());
        holder.title1.setText(current.getTextTitle1());
        holder.title2.setText(current.getTextTitle2());
        holder.title3.setText(current.getTextTitle3());
        holder.title4.setText(current.getTextTitle4());
        holder.contents.setText(current.getContents());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).getContents(), Toast.LENGTH_SHORT).show();
            }
        });
        //row.setTag(holder);
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked on Add", Toast.LENGTH_SHORT).show();
            }
        });
        holder.CommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked on Comment", Toast.LENGTH_SHORT).show();
            }
        });

        return row;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}

class ClassFeedViewHolder {
    TextView title1, title2, title3, title4, contents;
    ImageView image;
    CardView card;
    Button addButton, CommentButton;
}