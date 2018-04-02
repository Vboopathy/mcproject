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
 * Created by Sowmya Umesh on 3/29/2018.
 */

public class FictionListAdapter extends ArrayAdapter<fiction> {

    private Activity context;
    private List<fiction> fictionList;

    public FictionListAdapter(Activity context,List<fiction> fictionList){
        super(context, R.layout.activity_fiction_info, fictionList);
        this.context = context;
        this.fictionList = fictionList;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_fiction_info, null, true);

        TextView textViewDesc = listViewItem.findViewById(R.id.description);

        fiction fic = fictionList.get(position);
        textViewDesc.setText(fic.getName().toString());
        textViewDesc.setText(fic.getDescription().toString());
        return listViewItem;
    }
}
