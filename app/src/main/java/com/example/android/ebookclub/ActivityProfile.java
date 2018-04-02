package com.example.android.ebookclub;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ActivityProfile extends AppCompatActivity {

    private TextView name;
    private TextView city;
    private ImageView profilePic;
    private TextView bio;
    private String imageUrl;

    private DatabaseReference userTable;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.fNameTextView);
        bio = findViewById(R.id.bioTextView);
        city = findViewById(R.id.locationTextView);
        profilePic = findViewById(R.id.profilePicView);

        userTable = FirebaseDatabase.getInstance().getReference().child("users"); //child "users" for user table

        //mAuth = FirebaseAuth.getInstance();

        //run internet on UI thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        System.out.println("HELLLLLLO WORLD \n\n\n\n\n\n\n");
        System.out.println(currentUser.getEmail().toString());

        userTable.orderByChild("email").equalTo(currentUser.getEmail()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                //User person = dataSnapshot.getValue(User.class);
                //System.out.println(person);
                System.out.println(dataSnapshot.getValue().toString());
                System.out.println(dataSnapshot.child("email").getValue().toString());
                name.setText(dataSnapshot.child("name").getValue().toString());
                bio.setText(dataSnapshot.child("bio").getValue().toString());
                city.setText(dataSnapshot.child("city").getValue().toString());
                imageUrl = dataSnapshot.child("profileImg").getValue().toString();

                try {
                    Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageUrl).getContent());
                    profilePic.setImageBitmap(bitmap);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }
}
