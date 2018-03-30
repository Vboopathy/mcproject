package com.example.android.ebookclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityGenre extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        Button buttonfiction = findViewById(R.id.buttonfiction);

         buttonfiction.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(ActivityGenre.this,ActivityGenreDrama.class);
                 startActivity(intent);
             }
         });




    }
}
