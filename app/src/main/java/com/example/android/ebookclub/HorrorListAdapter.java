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

public class HorrorListAdapter extends ArrayAdapter<horror> {

    private Activity context;
    private List<horror> horrorList;

    public HorrorListAdapter(Activity context,List<horror> horrorList) {
        super(context, R.layout.genre_list, horrorList);
        this.context = context;
        this.horrorList = horrorList;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.genre_list, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.tvbookname);
        TextView textViewauthorname = listViewItem.findViewById(R.id.tvauthorname);

        horror hor = horrorList.get(position);
        textViewName.setText(hor.getName());
        textViewauthorname.setText(hor.getAuthorname());
        return listViewItem;

    }
}
