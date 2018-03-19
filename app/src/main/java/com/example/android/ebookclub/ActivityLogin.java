package com.example.android.ebookclub;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityLogin extends AppCompatActivity {

    private EditText loginEmail;
    private EditText loginPassword;
    private Button signUpBtn;
    private Button loginBtn;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.email);
        loginPassword = findViewById(R.id.password);
        signUpBtn = findViewById(R.id.signup);
        loginBtn = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();

    }

    public void onClickLogin(View view){
        String textEmail = loginEmail.getText().toString();
        String textPassword = loginPassword.getText().toString();
        if (!TextUtils.isEmpty(textEmail) && !TextUtils.isEmpty(textPassword)) {
            mAuth.signInWithEmailAndPassword(textEmail, textPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        sendToMain();
                    } else {
                        String e = task.getException().getMessage();
                        Toast.makeText(ActivityLogin.this, "Error: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }

    void sendToMain() {
        Intent mainIntent = new Intent(ActivityLogin.this, ActivityBookclub.class);
        startActivity(mainIntent);
        finish();
    }

    public void sendToRegister(View view){
        Intent mainIntent = new Intent(ActivityLogin.this, ActivityRegister.class);
        startActivity(mainIntent);
        finish();
    }

    @Override
    protected void onStart(){
        super.onStart();
        //FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null){
            sendToMain();
        }

    }


}
