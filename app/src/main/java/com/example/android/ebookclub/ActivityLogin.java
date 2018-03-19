package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
/*

    public void toMain(View view){

        String name = username.getText().toString();
        String pword = password.getText().toString();
        String slug = "";
        if (name == slug || pword == slug){
            //create intetn
            System.out.println(name);
            System.out.println(pword);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            // create path to signup -> activity_signup
            System.out.println("Signup button clicked");
            startActivity(intent);
        }

        else{System.out.println("Invalid!");


        }


    }
    */
}
