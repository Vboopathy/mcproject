package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayEventActivity extends AppCompatActivity {

    public TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_event);
        textView1 = findViewById(R.id.textViewName);
        textView2 = findViewById(R.id.textViewLocation);
        textView3 = findViewById(R.id.textViewDescription);
        Intent intent= getIntent();

        textView1.setText(intent.getStringExtra("name"));
        textView2.setText(intent.getStringExtra("location"));
        textView3.setText(intent.getStringExtra("description"));
    }
}
