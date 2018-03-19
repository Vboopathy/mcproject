package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayEventActivity extends AppCompatActivity {

    public TextView textViewName, textViewLocation, textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_event);
        textViewName = findViewById(R.id.textViewName);
        textViewLocation = findViewById(R.id.textViewLocation);
        textViewDescription = findViewById(R.id.textViewDescription);
        Intent intent= getIntent();

        textViewName.setText(intent.getStringExtra("name"));
        textViewLocation.setText(intent.getStringExtra("location"));
        textViewDescription.setText(intent.getStringExtra("description"));
    }
}
