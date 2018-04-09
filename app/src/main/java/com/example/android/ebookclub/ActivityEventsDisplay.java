package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityEventsDisplay extends AppCompatActivity {

    // variable declaration
    private ArrayList<ActivityBookClubEventDTO> displayEventList;
    private EventAdaptor adapter;
    ListView lvEvents;

    DatabaseReference eventsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_display);
        eventsList = FirebaseDatabase.getInstance().getReference("events");
        Intent intent= getIntent();

        lvEvents = findViewById(R.id.lvEvents);
        displayEventList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

        // fetch data from firebase
        eventsList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                displayEventList.clear();
                for(DataSnapshot eventSnapshot: dataSnapshot.getChildren()){
                    ActivityBookClubEventDTO event = eventSnapshot.getValue(ActivityBookClubEventDTO.class);
                    displayEventList.add(event);
                }

                adapter = new EventAdaptor(ActivityEventsDisplay.this, displayEventList);
                lvEvents.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
