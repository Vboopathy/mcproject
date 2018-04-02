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
        Button buttonromance = findViewById(R.id.buttonromance);
        Button buttonhorror = findViewById(R.id.buttonhorror);
        Button buttonselfhelp = findViewById(R.id.buttonselfhelp);

         buttonfiction.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(ActivityGenre.this,ActivityGenreDrama.class);
                 startActivity(intent);
             }
         });

         buttonromance.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(ActivityGenre.this,ActivityGenreRomance.class);
                 startActivity(intent);
             }
         });

         buttonhorror.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(ActivityGenre.this,ActivityGenreHorror.class);
                 startActivity(intent);
             }
         });

         buttonselfhelp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(ActivityGenre.this,ActivityGenreSelfhelp.class);
                 startActivity(intent);
             }
         });



    }
}
