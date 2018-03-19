package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityRegister extends AppCompatActivity {

    private FirebaseAuth mAuth;

    //Layout Instances
    private EditText emailText;
    private EditText passwordText;
    private EditText passwordConfirmationText;
    private Button createAccount;
    private Button toLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        //Create objects
        emailText = findViewById(R.id.emailRegister);
        passwordText = findViewById(R.id.passwordRegister);
        passwordConfirmationText = findViewById(R.id.passwordRegister2);
        createAccount = findViewById(R.id.createAccountBtn);


    }


    public void sendToLogin(View view){
        Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);
        startActivity(intent);
        finish();
    }

    //ActivityBookclub.class is the main activity
    void sendToMain() {
        Intent mainIntent = new Intent(ActivityRegister.this, ActivityBookclub.class);
        startActivity(mainIntent);
        finish();
    }

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser currentUser  = mAuth.getCurrentUser();
        if(currentUser != null){
            sendToMain();
        }

    }


}
