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


    //List<Dataitemgenre> lstData;
    DatabaseReference mDatabaseReffiction;
    ArrayList<fiction> fictionlist;
    ListView listViewfiction;
    ArrayList<String> fictionClickedInfoList;


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

    //int[] Img = {R.drawable.hp,R.drawable.ad,R.drawable.pp};
    //String[] Name = {"Angels & Demons", "Harry Potter","Pride and Prejudice"};
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
}






    //lstData.add(new Dataitemgenre(R.drawable.hp1, "Harry Potter"));
        //lstData.add(new Dataitemgenre(R.drawable.ad, "Angels & Demons"));
        //lstData.add(new Dataitemgenre(R.drawable.pp, "Pride and Prejudice"));

        //mDatabaseReffiction = FirebaseDatabase.getInstance().getReference("fiction");

//        listView = findViewById(R.id.list_item);
//
//
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Please wait loading list image...");
//        progressDialog.show();

        //mDatabaseRef = FirebaseDatabase.getInstance().getReference("fiction");

//        mDatabaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                progressDialog.dismiss();
//
//
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//
//                    Dataitemgenre img = snapshot.getValue(Dataitemgenre.class);
//                    lstData.add(img);
//                }

   // }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        CustomAdaptergenre adaptergenre = new CustomAdaptergenre(ActivityGenreDrama.this, lstData);
//        listView.setAdapter(adaptergenre);
//        listView.setTextFilterEnabled(true);
//
//
//        mDatabaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                progressDialog.dismiss();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Dataitemgenre img = snapshot.getValue(Dataitemgenre.class);
//                    adapter.addElement(img);
//                }
//
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//                progressDialog.dismiss();
//            }
//        });
//    }
//}

//        CustomAdaptergenre adaptergenre = new CustomAdaptergenre(ActivityGenreDrama.this, lstData);
//
//        listView.setAdapter(adaptergenre);
//
//        listView.setTextFilterEnabled(true);






//        CustomAdaptergenre adaptergenre = new CustomAdaptergenre(this, R.layout.itemrowfiction, lstData);
//
//
//        listView.setAdapter(adaptergenre);
//        listView.setTextFilterEnabled(true);
//
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//                Intent intent = new Intent();
//                intent.putExtra("bookname", lstData.get(position).bookname);
//                intent.putExtra("bookphoto", lstData.get(position).resIdthumbnail);
//
//                intent.setClass(ActivityGenreDrama.this, ActivityRating.class);
//                startActivity(intent);
//
//
//            }
//        });


// }
//}

//    class customAdapter extends BaseAdapter{
//        @Override
//        public int getCount() {
//            return Img.length;
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            return null;
//        }
//    }




