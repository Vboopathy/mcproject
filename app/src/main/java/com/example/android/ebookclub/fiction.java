package com.example.android.ebookclub;

/**
 * Created by Sowmya Umesh on 3/29/2018.
 */

public class fiction {

    String description,name, review, authorname;


    @Override
    public String toString(){


        return name + ","  + description + "," + review + "," + authorname + ",";


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

    public String getReview() {
        return review;
    }



    public void setReview(String review) {
        this.review = review;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public fiction(){

    }

    public fiction(String description){
        this.name = name;
        this.description = description;
        this.review = review;
        this.authorname = authorname;

    }
}
