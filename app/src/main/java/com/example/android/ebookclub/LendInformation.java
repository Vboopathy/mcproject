package com.example.android.ebookclub;

import com.google.android.gms.location.places.ui.PlacePicker;

/**
 * Created by Sampath on 02-04-2018.
 */

public class LendInformation {

    private String Name;
    private String Book;
    private String Description;
    private String Email;
    private String PhoneNumber;
    private String PlaceName;
    private String PlaceAddress;
    private String FromTime;
    private String ToTime;
    private String Date;
    private String id;

    public LendInformation(){

    }

    public LendInformation(String id, String name, String Book, String description, String email, String phoneNumber, String placeName, String placeAddress, String fromTime, String toTime, String date) {
        this.id = id;
        this.Name = name;
        this.Book = Book;
        this.Description = description;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.PlaceName = placeName;
        this.PlaceAddress = placeAddress;
        this.FromTime = fromTime;
        this.ToTime = toTime;
        this.Date = date;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBook() {
        return Book;
    }

    public void setBook(String Book) {
        this.Book = Book;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String PlaceName) {
        this.PlaceName = PlaceName;
    }

    public String getPlaceAddress() {
        return PlaceAddress;
    }

    public void setPlaceAddress(String PlaceAddress) {
        this.PlaceAddress = PlaceAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getFromTime() {
        return FromTime;
    }

    public void setFromTime(String FromTime) {
        this.FromTime = FromTime;
    }

    public String getToTime() {
        return ToTime;
    }

    public void setToTime(String ToTime) {
        this.ToTime = ToTime;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

}
