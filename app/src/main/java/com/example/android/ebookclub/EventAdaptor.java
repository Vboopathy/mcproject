package com.example.android.ebookclub;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ramsu on 23-03-2018.
 */

public class EventAdaptor extends ArrayAdapter<ActivityBookClubEventDTO> {

    private Activity context;
    private ArrayList<ActivityBookClubEventDTO> eventList;

    public EventAdaptor(Activity context, ArrayList<ActivityBookClubEventDTO> eventList)
    {
        super(context,R.layout.list_view, eventList);
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
            LayoutInflater inflater = context.getLayoutInflater();
            View viewList = inflater.inflate(R.layout.list_view, null, true);

            TextView tvName = viewList.findViewById(R.id.tvName);
            TextView tvLocation = viewList.findViewById(R.id.tvLocation);
            TextView tvDescription = viewList.findViewById(R.id.tvDescription);

            ActivityBookClubEventDTO event = eventList.get(position);
            tvName.setText(event.getEventName());
            tvLocation.setText(event.getEventLocation());
            tvDescription.setText(event.getEventDescription());

        return viewList;
    }

}
