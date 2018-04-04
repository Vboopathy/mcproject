package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityGenreRomance extends AppCompatActivity {



    DatabaseReference mDatabaseRefromance;
    ArrayList<romance> romancelist;
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
                    romance rom = courseSnapshot.getValue(romance.class);
                    romancelist.add(rom);
                    Log.e("romanceSnapshot: ", rom.toString());

                }
                RomanceListAdapter adapter = new RomanceListAdapter(ActivityGenreRomance.this, romancelist);
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

        romancelist = new ArrayList<>();
        mDatabaseRefromance = FirebaseDatabase.getInstance().getReference("romance");
        listViewromance = findViewById(R.id.list_item_romance);

        listViewromance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = "" + romancelist.get(i);
                Log.e("romanceList", romancelist + "");
                String[] courseClicked = s.split(",");
                Log.e("S", "" + courseClicked[0]);
                romanceClickedInfoList = new ArrayList<>();
                for (int index = 0; index < courseClicked.length; index++) {
                    romanceClickedInfoList.add("" + courseClicked[index]);
                }
                s = "" + romanceClickedInfoList;
                Log.e("romanceclicked", s);

                Intent intent = new Intent(getApplicationContext(), RomanceInfoActivity.class);
                intent.putExtra("ExtraMsg", romanceClickedInfoList);
                startActivity(intent);
            }
        });
    }
}
