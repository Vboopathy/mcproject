package com.example.android.ebookclub;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sowmya Umesh on 3/18/2018.
 */

public class GenremenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    public TextView tvname;
    public ImageView imphoto;
    private GenreitemClickListener genreitemClickListener;

    public GenremenuViewHolder(View itemView) {
        super(itemView);


        tvname = (TextView)itemView.findViewById(R.id.genrename);
        imphoto = (ImageView)itemView.findViewById(R.id.genreimage);

        itemView.setOnClickListener(this);
    }

    public void setGenreitemClickListener(com.example.android.ebookclub.GenreitemClickListener genreitemClickListener) {
        this.genreitemClickListener = genreitemClickListener;
    }

    @Override
    public void onClick(View view){

        genreitemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
