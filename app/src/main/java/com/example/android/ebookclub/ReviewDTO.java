package com.example.android.ebookclub;

/**
 * Created by Manojha on 2018-04-04.
 */

public class ReviewDTO {

    String review;

    public ReviewDTO() {}

    public ReviewDTO(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
