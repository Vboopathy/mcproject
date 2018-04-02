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

public class ActivityGenreHorror extends AppCompatActivity {


    DatabaseReference mDatabaseRefhorror;
    ArrayList<horror> horrorlist;
    ListView listViewhorror;
    ArrayList<String> horrorClickedInfoList;




    @Override
    protected void onStart() {
        super.onStart();

        mDatabaseRefhorror.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                horrorlist.clear();
                for (DataSnapshot courseSnapshot : dataSnapshot.getChildren()) {
                    horror hor = courseSnapshot.getValue(horror.class);
                    horrorlist.add(hor);
                    Log.e("horrorSnapshot: ", hor.toString());

                }
                HorrorListAdapter adapter = new HorrorListAdapter(ActivityGenreHorror.this, horrorlist);
                listViewhorror.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_horror);

        horrorlist = new ArrayList<>();
        mDatabaseRefhorror = FirebaseDatabase.getInstance().getReference("horror");
        listViewhorror = findViewById(R.id.list_item_horror);


        listViewhorror.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = "" + horrorlist.get(i);
                Log.e("horrorList", horrorlist + "");
                String[] courseClicked = s.split(",");
                Log.e("S", "" + courseClicked[0]);
                horrorClickedInfoList = new ArrayList<>();
                for (int index = 0; index < courseClicked.length; index++) {
                    horrorClickedInfoList.add("" + courseClicked[index]);
                }
                s = "" + horrorClickedInfoList;
                Log.e("horrorclicked", s);

                Intent intent = new Intent(getApplicationContext(), FictionInfoActivity.class);
                intent.putExtra("ExtraMsg", horrorClickedInfoList);
                startActivity(intent);
            }
        });
    }
}
