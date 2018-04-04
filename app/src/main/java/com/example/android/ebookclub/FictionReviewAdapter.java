package com.example.android.ebookclub;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Manojha on 2018-04-03.
 */


    public class FictionReviewAdapter extends ArrayAdapter<String> {
        private Activity context;
        private ArrayList<String> fictionReviewList;


//        CourseRegistration courseRegistration;

        public FictionReviewAdapter(Activity context, ArrayList<String> fictionReviewList){
            super(context, R.layout.review_list, fictionReviewList);
            this.context = context;
            this.fictionReviewList = fictionReviewList;

//            courseRegistration = new CourseRegistration();
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.e("Msg", "Inside getView of ListViewAdapter");
            LayoutInflater inflater = context.getLayoutInflater();
            View listViewItem = inflater.inflate(R.layout.review_list, null, true);
            TextView ficReview = listViewItem.findViewById(R.id.txt_Listreview);
            String review = fictionReviewList.get(position);
            Log.e("review", review);
            ficReview.setText(review);

//            Button b = listViewItem.findViewById(R.id.btnStuCourseDel);
//            b.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.e("Del", position + "'");
//                    studentCourseList.remove(position);
//                    courseRegistration.pushCourseRegistration(studentCourseList, "", "3");
//                    notifyDataSetChanged();
//                    studentCourseList.clear();
//                }
//            });
            return listViewItem;

        }
    }


