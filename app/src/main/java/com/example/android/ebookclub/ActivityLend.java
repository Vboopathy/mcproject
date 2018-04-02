package com.example.android.ebookclub;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Sampath on 02-04-2018.
 */

public class ActivityLend extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private EditText Name;
    private EditText bookName;
    private EditText Description;
    private EditText email;
    private EditText PhoneNumber;
    private TextView PlaceName;
    private TextView PlaceAddress;
    private EditText FromTime;
    private EditText toTime;
    private Button GetPlace;
    private Button SaveDetails;
    private EditText Date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_new);

        mDatabase = FirebaseDatabase.getInstance().getReference("lend");

        PlaceName = (TextView) findViewById(R.id.PlaceName);
        PlaceAddress = (TextView) findViewById(R.id.PlaceAddress);
        GetPlace = (Button) findViewById(R.id.GetPlace);
        SaveDetails = (Button) findViewById(R.id.SaveDetails);
        Name = (EditText) findViewById(R.id.Name);
        bookName = (EditText) findViewById(R.id.bookName);
        Description = (EditText) findViewById(R.id.Description);
        email = (EditText) findViewById(R.id.email);
        PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        FromTime = (EditText) findViewById(R.id.fromTime);
        toTime = (EditText) findViewById(R.id.toTime);
        Date = (EditText) findViewById(R.id.Date);

        SaveDetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                saveInfo();
            }


            private void saveInfo() {
                String PlaceAddressText = PlaceAddress.getText().toString().trim();
                String PlaceNameText = PlaceName.getText().toString().trim();
                String NameText = Name.getText().toString().trim();
                String bookNameText = bookName.getText().toString().trim();
                String DescriptionText = Description.getText().toString().trim();
                String PhoneNumberText = PhoneNumber.getText().toString().trim();
                String FromTimeText = FromTime.getText().toString().trim();
                String toTimeText = toTime.getText().toString().trim();
                String DateText = Date.getText().toString().trim();
                String EmailText = email.getText().toString().trim();

                LendInformation Lend = new LendInformation(NameText, bookNameText, DescriptionText, EmailText, PhoneNumberText, PlaceNameText, PlaceAddressText, FromTimeText, toTimeText, DateText );
                String id = mDatabase.push().getKey();
                mDatabase.child(id).setValue(Lend);

                Toast.makeText(getApplicationContext(), "Information Saved", Toast.LENGTH_LONG).show();

            }
        });

        GetPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ActivityPlacePicker.class);
                startActivity(intent);
            }
        });

    }
}

