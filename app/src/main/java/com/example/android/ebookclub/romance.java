package com.example.android.ebookclub;

/**
 * Created by Sowmya Umesh on 3/29/2018.
 */

public class romance {

    String description,name,authorname;

    @Override
    public String toString(){

        return name + ","  + description + "," + authorname;

    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public romance(){

    }

    public romance(String description){
        this.name = name;
        this.description = description;
        this.authorname = authorname;

    }
}
