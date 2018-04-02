package com.example.android.ebookclub;

/**
 * Created by Sampath on 02-04-2018.
 */

public class LendInformation {

    public String Name;
    public String BookName;
    public String Description;
    public String Email;
    public String PhoneNumber;
    public String PlaceName;
    public String PlaceAddress;
    public String FromTime;
    public String ToTime;
    public String Date;

    public LendInformation(){

    }

    public LendInformation(String name, String bookName, String description, String email, String phoneNumber, String placeName, String placeAddress, String fromTime, String toTime, String date) {
        this.Name = name;
        this.BookName = bookName;
        this.Description = description;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.PlaceName = placeName;
        this.PlaceAddress = placeAddress;
        this.FromTime = fromTime;
        this.ToTime = toTime;
        this.Date = date;
    }
}
