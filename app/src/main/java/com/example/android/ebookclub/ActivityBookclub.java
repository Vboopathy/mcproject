package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityBookclub extends AppCompatActivity {

    public Button createEvent;
    public Button done;
    public LinearLayout createEventLayout;
    public Button btnSignout;

    //FOR MAIN
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookclub);
        createEvent=findViewById(R.id.createBtn);
        done=findViewById(R.id.btnDone);
        createEventLayout=findViewById(R.id.createEventLayout);
        createEventLayout.setVisibility(createEventLayout.INVISIBLE);
        done.setVisibility(done.INVISIBLE);


        //FOR MAIN
        mAuth = FirebaseAuth.getInstance();

        btnSignout= findViewById(R.id.btnSignout);

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEventLayout.setVisibility(createEventLayout.VISIBLE);
                createEvent.setVisibility(createEvent.INVISIBLE);
                done.setVisibility(done.VISIBLE);
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEventLayout.setVisibility(createEventLayout.INVISIBLE);
                createEvent.setVisibility(createEvent.VISIBLE);
                done.setVisibility(done.INVISIBLE);
            }
        });

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

}
