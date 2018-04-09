package com.example.android.ebookclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class SelfHelpInfoActivity extends AppCompatActivity {

    RatingBar mRatingBar;
    TextView mRatingScale;
    EditText mReview;
    Button mSendFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_help_info);

        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        mRatingScale = (TextView) findViewById(R.id.txt_RatingScale);
        mReview = (EditText) findViewById(R.id.edt_review);
        mSendFeedback = (Button) findViewById(R.id.btn_Reviewd);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mRatingScale.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        mRatingScale.setText("Very bad");
                        break;
                    case 2:
                        mRatingScale.setText("Not satisfied");
                        break;
                    case 3:
                        mRatingScale.setText("Good");
                        break;
                    case 4:
                        mRatingScale.setText("Great, worth reading");
                        break;
                    case 5:
                        mRatingScale.setText("Awesome! I love it");
                        break;
                    default:
                        mRatingScale.setText("");
                }
            }
        });

        mSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mReview.getText().toString().isEmpty()) {
                    Toast.makeText(SelfHelpInfoActivity.this, "Please review the book", Toast.LENGTH_LONG).show();
                } else {
                    mReview.setText("");
                    mRatingBar.setRating(0);
                    Toast.makeText(SelfHelpInfoActivity.this, "Thank you for feedback", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}