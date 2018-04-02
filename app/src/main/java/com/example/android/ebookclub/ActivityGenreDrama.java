package com.example.android.ebookclub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import java.util.List;

public class ActivityGenreDrama extends AppCompatActivity {

    DatabaseReference mDatabaseReffiction;
    ArrayList<fiction> fictionlist;
    ListView listViewfiction;
    ArrayList<String> fictionClickedInfoList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_drama);
        fictionlist = new ArrayList<>();
        mDatabaseReffiction = FirebaseDatabase.getInstance().getReference("fiction");
        listViewfiction = findViewById(R.id.list_item_fiction);


        listViewfiction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = "" + fictionlist.get(i);
                Log.e("fictionList", fictionlist + "");
                String[] courseClicked = s.split(",");
                Log.e("S", "" + courseClicked[0]);
                fictionClickedInfoList = new ArrayList<>();
                for (int index = 0; index < courseClicked.length; index++) {
                    fictionClickedInfoList.add("" + courseClicked[index]);
                }
                s = "" + fictionClickedInfoList;
                Log.e("fictionclicked", s);

               Intent intent = new Intent(getApplicationContext(), FictionInfoActivity.class);
                intent.putExtra("ExtraMsg", fictionClickedInfoList);
               startActivity(intent);
            }
        });





    }

    @Override
    protected void onStart() {
        super.onStart();

        mDatabaseReffiction.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fictionlist.clear();
                for (DataSnapshot courseSnapshot : dataSnapshot.getChildren()) {
                    fiction fic = courseSnapshot.getValue(fiction.class);
                    fictionlist.add(fic);
                    Log.e("fictionSnapshot: ", fic.toString());

                }
                FictionListAdapter adapter = new FictionListAdapter(ActivityGenreDrama.this, fictionlist);
                listViewfiction.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}




