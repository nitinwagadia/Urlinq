package com.example.adapters;

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

import com.example.model.HomeRecyclerViewData;
import com.example.urlinq.R;

import java.util.Collections;
import java.util.List;

public class HomeRecyclerDataAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    List<HomeRecyclerViewData> data = Collections.emptyList();
    Context context;
    LayoutInflater inflater;

    public HomeRecyclerDataAdapter(Context context,
                                   List<HomeRecyclerViewData> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        inflater = LayoutInflater.from(parent.getContext());

        if (i == TYPE_ITEM) {
            View view = inflater.inflate(R.layout.card_layout, parent, false);
            HomeRecyclerViewHolder holder = new HomeRecyclerViewHolder(view);
            return holder;
        } else if (i == TYPE_HEADER) {
            View view = inflater.inflate(R.layout.header, parent, false);
            HomeRecyclerViewHeaderHolder headerHolder = new HomeRecyclerViewHeaderHolder(view);
            return headerHolder;

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
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
        if (holder instanceof HomeRecyclerViewHolder) {
            HomeRecyclerViewData current = data.get(position - 1);
            ((HomeRecyclerViewHolder) holder).image.setImageResource(current.getImageId());
            ((HomeRecyclerViewHolder) holder).title1.setText(current.getTextTitle1());
            ((HomeRecyclerViewHolder) holder).title2.setText(current.getTextTitle2());
            ((HomeRecyclerViewHolder) holder).title3.setText(current.getTextTitle3());
            ((HomeRecyclerViewHolder) holder).title4.setText(current.getTextTitle4());
            ((HomeRecyclerViewHolder) holder).contents.setText(current.getContents());
        } else if (holder instanceof HomeRecyclerViewHeaderHolder) {

        }
    }

    class HomeRecyclerViewHeaderHolder extends RecyclerView.ViewHolder {

        public HomeRecyclerViewHeaderHolder(View itemView) {
            super(itemView);
        }
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
                        "Data is " + data.get(getPosition() - 1).getContents(),
                        Toast.LENGTH_SHORT).show();
            }

        }


    }

}
