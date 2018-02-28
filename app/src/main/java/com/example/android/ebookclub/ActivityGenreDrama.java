package com.example.android.ebookclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ActivityGenreDrama extends AppCompatActivity {

    int[] Img = {R.drawable.hp,R.drawable.ad,R.drawable.pp};
    String[] Name = {"Angels & Demons", "Harry Potter","Pride and Prejudice"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_drama);

        ListView listView=(ListView)findViewById(R.id.list_item);
    }
    class customAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return Img.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}
