package com.example.android.ebookclub;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Sampath on 02-04-2018.
 */

public class ActivityLend extends AppCompatActivity {

    //Database reference to connect to firebase
    private DatabaseReference mDatabase;

    //Creating Variables
    private EditText Name;
    private EditText book;
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
    public static final int MY_PERMISSION_FINE_LOCATION = 101;
    int PLACE_PICKER_REQUEST = 1;
    final Calendar myCalendar = Calendar.getInstance();


    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_new);

        //Adding the reference to "lend" node in firebase
        mDatabase = FirebaseDatabase.getInstance().getReference("lend");

        //Initializing the element variables
        PlaceName = (TextView) findViewById(R.id.PlaceName);
        PlaceAddress = (TextView) findViewById(R.id.PlaceAddress);
        GetPlace = (Button) findViewById(R.id.GetPlace);
        SaveDetails = (Button) findViewById(R.id.SaveDetails);
        Name = (EditText) findViewById(R.id.Name);
        book = (EditText) findViewById(R.id.bookName);
        Description = (EditText) findViewById(R.id.Description);
        email = (EditText) findViewById(R.id.email);
        PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        FromTime = (EditText) findViewById(R.id.fromTime);
        toTime = (EditText) findViewById(R.id.toTime);
        Date = (EditText) findViewById(R.id.Date);

        //For the lend details to be saved
        SaveDetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                saveInfo();
            }
        });

        //Button Action to get Lending location
        GetPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(ActivityLend.this), PLACE_PICKER_REQUEST);

                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        //Time picker for from time
        FromTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
                        int minute = myCalendar.get(Calendar.MINUTE);

                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(ActivityLend.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                FromTime.setText(selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);
                        mTimePicker.setTitle("Select Time");
                        mTimePicker.show();
                }
                return false;
            }
        });

        //Time picker for to Time
        toTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
                        int minute = myCalendar.get(Calendar.MINUTE);

                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(ActivityLend.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                toTime.setText(selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);
                        mTimePicker.setTitle("Select Time");
                        mTimePicker.show();

                }
                return false;
            }
        });

        //Date picker variables
        final DatePickerDialog.OnDateSetListener date = new
                DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateLabel();
                    }

                };

        //Date picker actions
        Date.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    new DatePickerDialog(ActivityLend.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
                return false;
            }
        });
    }

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        Date.setText(sdf.format(myCalendar.getTime()));
    }

    //Saving info to firebase
    private void saveInfo() {

        String PlaceAddressText = PlaceAddress.getText().toString();
        String PlaceNameText = PlaceName.getText().toString();
        String NameText = Name.getText().toString();
        String bookText = book.getText().toString();
        String DescriptionText = Description.getText().toString();
        String PhoneNumberText = PhoneNumber.getText().toString();
        String FromTimeText = FromTime.getText().toString();
        String toTimeText = toTime.getText().toString();
        String DateText = Date.getText().toString();
        String EmailText = email.getText().toString();

        String id = mDatabase.push().getKey();
        LendInformation Lend = new LendInformation(id, NameText, bookText, DescriptionText, EmailText, PhoneNumberText, PlaceNameText, PlaceAddressText, FromTimeText, toTimeText, DateText );
        mDatabase.child(id).setValue(Lend);
        Toast.makeText(getApplicationContext(), "Information Saved", Toast.LENGTH_LONG).show();

    }

    private void requestPermission()
    {
        //LOOK INTO MANIFEST AND CHECK IF THE PERMISSION IS GRANTED, IF IT IS NOT GRANTED IT THIS WILL BY PASS THE CODE
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
        }
    }

    //Requesting permission to location
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch ( requestCode )
        {
            case MY_PERMISSION_FINE_LOCATION :
                if(grantResults[0] !=PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(getApplicationContext(), "This App requires location permission to be granted!", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;

        }

    }

    //Place picker code for lending location
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(ActivityLend.this, data);
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
                PlaceName.setText("Place Name : "+place.getName());
                PlaceAddress.setText("Place Address : "+place.getAddress());
                SaveDetails.setVisibility(View.VISIBLE);
            }
        }
    }
}
