package com.example.android.ebookclub;

/**
 * Created by ramsu on 23-03-2018.
 */

public class EventItem {
    public EventItem(String base, String value) {

        this.base = base;
        this.value = value;

    }

    private String base;
    private String value;

    public String getBase()
    {

        return this.base;

    }

    public String getValue()
    {

        return this.value;

    }
}
