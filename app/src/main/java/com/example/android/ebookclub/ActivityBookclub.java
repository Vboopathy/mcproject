package com.example.android.ebookclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ActivityBookclub extends AppCompatActivity {

    public Button createEvent;
    public Button done;
    public LinearLayout createEventLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookclub);
        createEvent=findViewById(R.id.createBtn);
        done=findViewById(R.id.btnDone);
        createEventLayout=findViewById(R.id.createEventLayout);
        createEventLayout.setVisibility(createEventLayout.INVISIBLE);
        done.setVisibility(done.INVISIBLE);

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEventLayout.setVisibility(createEventLayout.VISIBLE);
                createEvent.setVisibility(createEvent.INVISIBLE);
                done.setVisibility(done.VISIBLE);
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEventLayout.setVisibility(createEventLayout.INVISIBLE);
                createEvent.setVisibility(createEvent.VISIBLE);
                done.setVisibility(done.INVISIBLE);
            }
        });
    }
}
