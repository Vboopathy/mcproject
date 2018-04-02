package com.example.android.ebookclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class FictionInfoActivity extends AppCompatActivity {

    TextView mdescription;
    DatabaseReference databasereview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction_info);
    }
}
