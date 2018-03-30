package com.example.android.ebookclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityGenreRomance extends AppCompatActivity {



    DatabaseReference mDatabaseRefromance;
    ArrayList<fiction> romancelist;
    ListView listViewromance;
    ArrayList<String> romanceClickedInfoList;


    @Override
    protected void onStart() {
        super.onStart();

        mDatabaseRefromance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                romancelist.clear();
                for (DataSnapshot courseSnapshot : dataSnapshot.getChildren()) {
                    fiction fic = courseSnapshot.getValue(fiction.class);
                    romancelist.add(fic);
                    Log.e("courseSnapshot: ", fic.toString());

                }
                FictionListAdapter adapter = new FictionListAdapter(ActivityGenreRomance.this, romancelist);
                listViewromance.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_romance);
    }
}
