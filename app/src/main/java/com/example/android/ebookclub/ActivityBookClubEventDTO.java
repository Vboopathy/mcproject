package com.example.android.ebookclub;

/**
 * Created by ramsu on 23-03-2018.
 */

public class ActivityBookClubEventDTO {
    String id;
    String eventName;
    String eventLocation;
    String eventDescription;

    public ActivityBookClubEventDTO(){}

    public ActivityBookClubEventDTO(String id, String eventName, String eventLocation, String eventDescription) {
        this.id = id;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
