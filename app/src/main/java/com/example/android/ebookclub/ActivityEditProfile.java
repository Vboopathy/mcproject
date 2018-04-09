package com.example.android.ebookclub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class ActivityEditProfile extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private EditText name;
    private EditText city;
    private EditText bio;

    private ImageView profilePic;
    private String imageUrl;
    private Double rating;
    Context context;


    private DatabaseReference userTable;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name = findViewById(R.id.nameEditText);
        city = findViewById(R.id.cityEditText);
        bio = findViewById(R.id.bioEditText);
        profilePic = findViewById(R.id.editPicView);
        Context context = getApplicationContext();

        //get table from firebase
        userTable = FirebaseDatabase.getInstance().getReference().child("users");
    }



    public void toCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        userTable.orderByChild("email").equalTo(currentUser.getEmail()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Set values in Profile to those in database.
                name.setHint(dataSnapshot.child("name").getValue().toString());
                bio.setHint(dataSnapshot.child("bio").getValue().toString());
                city.setHint(dataSnapshot.child("city").getValue().toString());
                imageUrl = dataSnapshot.child("profileImg").getValue().toString();
                System.out.println(imageUrl);
                //get image from url location and set it to profile picture.
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

    public void saveProfile(View view){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


        userTable.orderByChild("email").equalTo(currentUser.getEmail()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Set values in Profile to those in database.

                if(!isEditTextEmpty(name)){
                    System.out.println(name.getText().toString());
                    dataSnapshot.getRef().child("name").setValue(name.getText().toString());}
                if(!isEditTextEmpty(bio)){
                    dataSnapshot.getRef().child("bio").setValue(bio.getText().toString());}
                if(!isEditTextEmpty(city)){
                    dataSnapshot.getRef().child("city").setValue(city.getText().toString());}
                //int duration = Toast.LENGTH_SHORT;
                //Toast toast = Toast.makeText(context, "Saved Profile.", duration);
                //toast.show();
                sendToMain();
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

    private void sendToMain(){
        Intent intent = new Intent(ActivityEditProfile.this, ActivityProfile.class);
        startActivity(intent);
        finish();
    }


    private boolean isEditTextEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }


}
