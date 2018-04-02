package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    TextView mdescription;
    EditText review;
    Button btn_review;

    FirebaseDatabase database;
    DatabaseReference ref_review;
    DatabaseReference ref_description;


    Map<String, String> bookInfoMap = new HashMap<>();


    fiction  fic_tion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction_info);

        review = findViewById(R.id.edt_review);
        mdescription = findViewById(R.id.description);

        Intent intent = getIntent();
        ArrayList<String> message = intent.getStringArrayListExtra("ExtraMsg");
        if(message!=null) {

            mdescription.setText(getString(Integer.parseInt(R.id.description + message.get(1))));

        }

        ref_review = database.getReference( "review");
        ref_description = database.getReference("fiction");

        fic_tion = new fiction();

    }


    @Override
    protected void onStart() {
        super.onStart();
        ref_description.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bookInfoMap.clear();
                for (DataSnapshot courseSnapshot : dataSnapshot.getChildren()){
                    String descripInfo= String.valueOf(courseSnapshot.child("description").getValue());
                    String authorname = String.valueOf(courseSnapshot.child("author").getValue());
                    bookInfoMap.put(descripInfo, authorname);

                }
                Log.e("courses", "" +bookInfoMap);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void getValues()
    {
        fic_tion.setReview(review.getText().toString());
    }

    public void btn_review(View view)  {
        ref_review.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getValues();
                ref_review.child("review01").setValue(fic_tion);
                Toast.makeText(FictionInfoActivity.this, "Review added", Toast.LENGTH_SHORT);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
