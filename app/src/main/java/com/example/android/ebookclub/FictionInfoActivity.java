package com.example.android.ebookclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FictionInfoActivity extends AppCompatActivity {

    EditText editText;
    Button submit;
    DatabaseReference rootRef, demoRef_ad, demoRef_hp;
    ArrayList<String> reviews;
    FictionReviewAdapter adapter;
    ListView listViewficreviews;
    String builder = "";
    final String[] review = {""};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction_info);

        editText = (EditText) findViewById(R.id.edt_review);
        submit = (Button) findViewById(R.id.btn_review);
        listViewficreviews = findViewById(R.id.listViewfic_review);
        rootRef = FirebaseDatabase.getInstance().getReference("fiction").child("Angles and Demons");

        //database reference pointing to root of database

        reviews = new ArrayList<>();

        //database reference pointing to demo node

//                demoRef_hp = rootRef.child("Harry Potter").child("review");


        // vidhya


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Map<String, Object> update = new HashMap<>();


                rootRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // reviews.clear();
                        builder = String.valueOf(dataSnapshot.child("review").getValue());
//                for (DataSnapshot reviewSnapshot : dataSnapshot.getChildren()) {
//                        builder = String.valueOf(reviewSnapshot.child("review").getValue());
//                }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                String value = editText.getText().toString();
                // update.put("review", value);
                //push creates a unique id in database
                // rootRef.updateChildren(update);
                if (builder.equals(""))
                    builder = value;
                else
                    builder += "," + value;
                Map<String, Object> check = new HashMap<>();
                check.put("review", builder);

                // ReviewDTO reviewDTO = new ReviewDTO(builder);
                rootRef.updateChildren(check);
                builder = "";
                Toast.makeText(getApplicationContext(), "Reviewed!",
                        Toast.LENGTH_LONG).show();
            }
        });

        //vidhya
    }

        @Override
        /**
         * Dictates what's to occur when the activity starts
         */
        protected void onStart() {
            super.onStart();

            rootRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // reviews.clear();
                    for (DataSnapshot reviewSnapshot : dataSnapshot.getChildren()) {
                        review[0] = String.valueOf(reviewSnapshot.child("review").getValue());
                    }

                    String[] value = review[0].split(",");
                    for (int j = 0; j < value.length; j++) {
                        reviews.add(value[j]);

                    }

                    if (!reviews.isEmpty()) {
                        Log.e("Msg", "Inside if");
                        adapter = new FictionReviewAdapter(FictionInfoActivity.this, reviews);
                        listViewficreviews.setAdapter(adapter);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
}






