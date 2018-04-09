package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ActivityBookclub extends AppCompatActivity {

    // variable declaration
    public Button createEvent;
    public Button done;
    public Button displayEvents;
    public LinearLayout createEventLayout;

    public EditText editTextName, editTextLocation, editTextDesc;

    String eventName = "";
    String eventLocation = "";
    String eventDescription = "";

    DatabaseReference eventsList;
    //FOR MAIN
    private FirebaseAuth mAuth;
    public Button btnSignout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookclub);

        createEvent=findViewById(R.id.createBtn);
        editTextName = findViewById(R.id.editText);
        editTextLocation = findViewById(R.id.editText1);
        editTextDesc = findViewById(R.id.editText2);
        displayEvents = findViewById(R.id.displayBtn);


        done=findViewById(R.id.btnDone);
        createEventLayout=findViewById(R.id.createEventLayout);

        // firebase connection
        eventsList = FirebaseDatabase.getInstance().getReference("events");
        createEventLayout.setVisibility(createEventLayout.INVISIBLE);
        done.setVisibility(done.INVISIBLE);

        //FOR MAIN
        mAuth = FirebaseAuth.getInstance();

        // visibility functionality
        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEventLayout.setVisibility(createEventLayout.VISIBLE);
                createEvent.setVisibility(createEvent.INVISIBLE);
                displayEvents.setVisibility(displayEvents.INVISIBLE);
                done.setVisibility(done.VISIBLE);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eventName = editTextName.getText().toString();
                eventLocation = editTextLocation.getText().toString();
                eventDescription = editTextDesc.getText().toString();

                // error check logic
                if(eventName.equals(null) || eventName.equals("")){

                    editTextName.setError("Please enter the event name");

                } else if(eventLocation.equals(null) || eventLocation.equals("")){

                    editTextLocation.setError("Please enter the event location");

                } else if(eventDescription.equals(null) || eventDescription.equals("")){

                    editTextDesc.setError("Please enter the event description");

                } else {

                createEventLayout.setVisibility(createEventLayout.INVISIBLE);
                createEvent.setVisibility(createEvent.VISIBLE);
                displayEvents.setVisibility(displayEvents.VISIBLE);
                done.setVisibility(done.INVISIBLE);

                    // function call to add event to firebase
                    addEvent();

                }
            }
        });

        displayEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplicationContext(), ActivityEventsDisplay.class);
                intent.putExtra("name",eventName);
                intent.putExtra("location", eventLocation);
                intent.putExtra("description", eventDescription);
                startActivity(intent);

            }
        });
    }

    public void addEvent(){

        String id = eventsList.push().getKey();
        ActivityBookClubEventDTO clubEventDTO = new ActivityBookClubEventDTO(id, eventName, eventLocation, eventDescription);
        eventsList.child(id).setValue(clubEventDTO);
        Toast.makeText(this, "Event Created", Toast.LENGTH_SHORT).show();

    }

    //FOR MAIN
    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser == null){
            sendToLogin();
        }
    }

    //FOR MAIN
    private void logout(){
        //mAuth.signOut();
        sendToLogin();
    }

    //FOR MAIN
    private void sendToLogin(){
        Intent intent = new Intent(ActivityBookclub.this, ActivityLogin.class);
        startActivity(intent);
        finish();
    }

    public void signOut(View view){
        mAuth.signOut();
        sendToLogin();
    }

    public void sendToProfile(View view){
        Intent intent = new Intent(ActivityBookclub.this, ActivityProfile.class);
        startActivity(intent);
        finish();

    }


}
