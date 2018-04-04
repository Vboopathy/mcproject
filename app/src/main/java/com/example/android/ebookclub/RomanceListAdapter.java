package com.example.android.ebookclub;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sowmya Umesh on 3/29/2018.
 */

public class RomanceListAdapter extends ArrayAdapter{

    private Activity context;
    private List<romance> romanceList;

    public RomanceListAdapter(Activity context, ArrayList<romance> romanceList){
        super(context, R.layout.genre_list, romanceList);
        this.context = context;
        this.romanceList = romanceList;




    }
    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.genre_list, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.tvbookname);
        TextView textViewauthorname = listViewItem.findViewById(R.id.tvauthorname);

        romance rom = romanceList.get(position);
        textViewName.setText(rom.getName());
        textViewauthorname.setText(rom.getAuthorname());
        return listViewItem;
    }
}
