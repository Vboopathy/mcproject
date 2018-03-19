package com.example.android.ebookclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityBookclub extends AppCompatActivity {

    public Button createEvent;
    public Button done;
    public Button displayEvents;
    public LinearLayout createEventLayout;
    public EditText editTextName, editTextLocation, editTextDesc;

    String name1 = "Event Name :  ";
    String location1 = "Event Location :  ";
    String description1 = "Event Description :  ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookclub);
        createEvent=findViewById(R.id.createBtn);
        editTextName = findViewById(R.id.editText);
        editTextLocation = findViewById(R.id.editText1);
        editTextDesc = findViewById(R.id.editText2);
        displayEvents = findViewById(R.id.displayBtn);

        done=findViewById(R.id.btnDone);
        createEventLayout=findViewById(R.id.createEventLayout);
        createEventLayout.setVisibility(createEventLayout.INVISIBLE);
        done.setVisibility(done.INVISIBLE);


        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEventLayout.setVisibility(createEventLayout.VISIBLE);
                createEvent.setVisibility(createEvent.INVISIBLE);
                displayEvents.setVisibility(displayEvents.INVISIBLE);
                done.setVisibility(done.VISIBLE);
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEventLayout.setVisibility(createEventLayout.INVISIBLE);
                createEvent.setVisibility(createEvent.VISIBLE);
                displayEvents.setVisibility(displayEvents.VISIBLE);
                done.setVisibility(done.INVISIBLE);

            }
        });
        displayEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 += editTextName.getText().toString();
                location1 += editTextLocation.getText().toString();
                description1 += editTextDesc.getText().toString();
                Intent intent= new Intent(getApplicationContext(), DisplayEventActivity.class);
                intent.putExtra("name",name1);
                intent.putExtra("location", location1);
                intent.putExtra("description", description1);
                startActivity(intent);
            }
        });
    }
}
