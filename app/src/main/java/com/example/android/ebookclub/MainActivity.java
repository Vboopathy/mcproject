package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

/*


    public void toLogin(View view){
        //create path to login -> activity__login
        Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
        System.out.println("Login button clicked");
        startActivity(intent);
    }


    public void toSignup(View view){
        Intent intent = new Intent(getApplicationContext(), ActivityRegistration.class);
        // create path to signup -> activity_signup
        System.out.println("Signup button clicked");
        startActivity(intent);

    }

    public void  toMaps(View view)
    {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
*/
}
