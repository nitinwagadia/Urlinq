package com.example.urlinq;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.urlinq.HomeRecyclerDataAdapter.HomeRecyclerViewHolder;
import com.example.urlinq.model.HomeRecyclerViewData;

import java.util.Collections;
import java.util.List;

public class HomeRecyclerDataAdapter extends
        RecyclerView.Adapter<HomeRecyclerViewHolder> {
    List<HomeRecyclerViewData> data = Collections.emptyList();
    Context context;
    LayoutInflater inflater;

    public HomeRecyclerDataAdapter(Context context,
                                   List<HomeRecyclerViewData> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public HomeRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_layout, parent, false);
        HomeRecyclerViewHolder holder = new HomeRecyclerViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(HomeRecyclerViewHolder holder, int position) {
        HomeRecyclerViewData current = data.get(position);
        holder.image.setImageResource(current.getImageId());
        holder.title1.setText(current.getTextTitle1());
        holder.title2.setText(current.getTextTitle2());
        holder.title3.setText(current.getTextTitle3());
        holder.title4.setText(current.getTextTitle4());
        holder.contents.setText(current.getContents());

    }

    class HomeRecyclerViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        TextView title1, title2, title3, title4, contents;
        ImageView image;
        CardView card;
        Button addButton, CommentButton;

        public HomeRecyclerViewHolder(View itemView) {
            super(itemView);
            title1 = (TextView) itemView.findViewById(R.id.title1);
            title2 = (TextView) itemView.findViewById(R.id.title2);
            title3 = (TextView) itemView.findViewById(R.id.title3);
            title4 = (TextView) itemView.findViewById(R.id.title4);
            contents = (TextView) itemView.findViewById(R.id.contents);
            image = (ImageView) itemView.findViewById(R.id.image);
            addButton = (Button) itemView.findViewById(R.id.add);
            CommentButton = (Button) itemView.findViewById(R.id.comment);
            card = (CardView) itemView.findViewById(R.id.card_view);
            card.setOnClickListener(this);
            addButton.setOnClickListener(this);
            CommentButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.add) {
                Toast.makeText(context, "ADD Clicked", Toast.LENGTH_SHORT)
                        .show();
            } else if (id == R.id.comment) {

                Toast.makeText(context, "Comment Clicked", Toast.LENGTH_SHORT)
                        .show();
            } else {
                Toast.makeText(context,
                        "Data is " + data.get(getPosition()).getContents(),
                        Toast.LENGTH_SHORT).show();
            }

        }

    }

}
