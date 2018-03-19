package com.example.android.ebookclub;

/**
 * Created by Sampath on 19-03-2018.
 */
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import org.w3c.dom.Text;


public class ActivityPlacePicker extends AppCompatActivity {

    TextView PlaceName;
    TextView PlaceAddress;
    Button  PlaceButton;
    public static final int MY_PERMISSION_FINE_LOCATION = 101;
    int PLACE_PICKER_REQUEST = 1;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend);

        requestPermission();

        PlaceName = (TextView) findViewById(R.id.PlaceName);
        PlaceAddress = (TextView) findViewById(R.id.PlaceAddress);
        PlaceButton = (Button) findViewById(R.id.GetPlace);

        PlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(ActivityPlacePicker.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }


            }
        });

    }

    private void requestPermission()
    {
        //LOOK INTO MANIFEST AND CHECK IF THE PERMISSION IS GRANTED, IF IT IS NOT GRANTED IT THIS WILL BY PASS THE CODE
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
        }
    }


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(ActivityPlacePicker.this, data);
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
                PlaceName.setText(place.getName());
                PlaceAddress.setText(place.getAddress());

            }
        }
    }
}
