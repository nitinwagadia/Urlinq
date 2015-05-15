package com.example.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.ClassMemberData;
import com.example.urlinq.ClassMembers;
import com.example.urlinq.R;

import java.util.List;

/**
 * Created by nitin on 3/13/15.
 */
public class ClassMembersListAdapater extends BaseAdapter {

    Context context;
    List<ClassMemberData> data;

    LayoutInflater inflater;

    public ClassMembersListAdapater(Context context, List data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (isMemberView(position)) {
            Log.i("I am of Member", data.get(position).getViewtype() + " " + position);
            row = inflater.inflate(R.layout.class_member_card, null);
            ((TextView) row.findViewById(R.id.classMemberName)).setText(data.get(position).getMemberName());
            ((ImageView) row.findViewById(R.id.classMemberImage)).setImageResource(data.get(position).getMemberImageID());
            ;
            (row.findViewById(R.id.card_view_member)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, data.get(position).getMemberName() + "", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Log.i("I am Separator", data.get(position).getViewtype() + " " + position);
            row = inflater.inflate(R.layout.layout_class_member_separator, null);
            if (isAdminSeparator(position)) {
                ((TextView) row.findViewById(R.id.classMemberSeparator)).setText("Admin");
                (row.findViewById(R.id.MemberLinearLayout)).setVisibility(View.GONE);
            } else {
                ((TextView) row.findViewById(R.id.classMemberSeparator)).setText("Members");
                (row.findViewById(R.id.MemberLinearLayout)).setVisibility(View.VISIBLE);

            }

        }


        return row;
    }

    private boolean isAdminSeparator(int position) {
        if (data.get(position).getViewtype() == ClassMembers.ADMIN_VALUE)
            return true;
        return false;
    }

    private boolean isMemberView(int position) {

        if (data.get(position).getViewtype() == ClassMembers.MEMBER_VIEW)
            return true;
        return false;
    }
}
