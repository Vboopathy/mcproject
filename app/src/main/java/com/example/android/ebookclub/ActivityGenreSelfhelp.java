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

public class ActivityGenreSelfhelp extends AppCompatActivity {


    DatabaseReference mDatabaseRefselfhelp;
    ArrayList<selfhelp> selfhelplist;
    ListView listViewselfhelp;
    ArrayList<String> selfhelpClickedInfoList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_selfhelp);


        selfhelplist = new ArrayList<>();
        mDatabaseRefselfhelp = FirebaseDatabase.getInstance().getReference("selfhelp");
        listViewselfhelp = findViewById(R.id.list_item_selfhelp);


        listViewselfhelp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = "" + selfhelplist.get(i);
                Log.e("selfhelpList", selfhelplist + "");
                String[] courseClicked = s.split(",");
                Log.e("S", "" + courseClicked[0]);
                selfhelpClickedInfoList = new ArrayList<>();
                for (int index = 0; index < courseClicked.length; index++) {
                    selfhelpClickedInfoList.add("" + courseClicked[index]);
                }
                s = "" + selfhelpClickedInfoList;
                Log.e("selfhelpclicked", s);

                Intent intent = new Intent(getApplicationContext(), SelfHelpInfoActivity.class);
                intent.putExtra("ExtraMsg", selfhelpClickedInfoList);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mDatabaseRefselfhelp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                selfhelplist.clear();
                for (DataSnapshot courseSnapshot : dataSnapshot.getChildren()) {
                    selfhelp sh = courseSnapshot.getValue(selfhelp.class);
                    selfhelplist.add(sh);
                    Log.e("selfhelpSnapshot: ", sh.toString());

                }
                SelfhelpListAdapter adapter = new SelfhelpListAdapter(ActivityGenreSelfhelp.this, selfhelplist);
                listViewselfhelp.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
