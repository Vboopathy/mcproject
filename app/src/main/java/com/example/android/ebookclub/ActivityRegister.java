package com.example.android.ebookclub;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityRegister extends AppCompatActivity {

    private FirebaseAuth mAuth;

    //Layout Instances
    private EditText emailText;
    private EditText passwordText;
    private EditText passwordConfirmationText;
    private Button createAccount;

 //TODO: add logoout functionality

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



// todo password1 == password2  or password1 != password2
    public void registerUser(View view){
        String email= emailText.getText().toString();
        String password = passwordText.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(ActivityRegister.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(ActivityRegister.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            sendToMain();
                        }
                    }
                });


    }


}





