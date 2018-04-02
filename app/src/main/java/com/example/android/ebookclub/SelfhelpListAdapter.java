package com.example.android.ebookclub;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sowmya Umesh on 4/1/2018.
 */

public class SelfhelpListAdapter extends ArrayAdapter<selfhelp> {

    private Activity context;
    private List<selfhelp> selfhelpList;

    public SelfhelpListAdapter(Activity context, List<selfhelp> selfhelpList) {
        super(context, R.layout.genre_list, selfhelpList);
        this.context = context;
        this.selfhelpList = selfhelpList;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.genre_list, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.tvbookname);
        TextView textViewauthorname = listViewItem.findViewById(R.id.tvauthorname);

        selfhelp sh = selfhelpList.get(position);
        textViewName.setText(sh.getName());
        textViewauthorname.setText(sh.getAuthorname());
        return listViewItem;

    }
}
