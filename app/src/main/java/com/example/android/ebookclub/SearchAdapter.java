package com.example.android.ebookclub;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ramsu on 02-04-2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    Context context;
    ArrayList<String> bookName;
    ArrayList<String> bookDesc;
    ArrayList<String> bookLendDate;
    ArrayList<String> userEmail;
    ArrayList<String> fromTime;
    ArrayList<String> userName;
    ArrayList<String> userPhoneNumber;
    ArrayList<String> placeAddress;
    ArrayList<String> placeName;

    class SearchViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvDesc, tvPlaceAddress, tvUserName, tvUserPhoneNumber, tvUserEmail, tvBookLendDate, tvFromTime;
        public SearchViewHolder(View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tvBookName);
            tvDesc = itemView.findViewById(R.id.tvBookDesc);
            tvPlaceAddress = itemView.findViewById(R.id.tvPlaceAddress);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvUserPhoneNumber = itemView.findViewById(R.id.tvUserPhoneNumber);
            tvUserEmail = itemView.findViewById(R.id.tvUserEmail);
            tvBookLendDate = itemView.findViewById(R.id.tvBookLendDate);
            tvFromTime = itemView.findViewById(R.id.tvFromTime);
        }
    }

    public SearchAdapter(Context context, ArrayList<String> bookName, ArrayList<String> bookDesc, ArrayList<String> bookLendDate, ArrayList<String> userEmail, ArrayList<String> fromTime, ArrayList<String> userName, ArrayList<String> userPhoneNumber, ArrayList<String> placeAddress, ArrayList<String> placeName) {
        this.context = context;
        this.bookName = bookName;
        this.bookDesc = bookDesc;
        this.bookLendDate = bookLendDate;
        this.userEmail= userEmail;
        this.fromTime = fromTime;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.placeAddress = placeAddress;
        this.placeName = placeName;
    }

    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_list_view, parent, false);
        return new SearchAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.tvName.setText(bookName.get(position));
        holder.tvDesc.setText(bookDesc.get(position));
        holder.tvPlaceAddress.setText(placeAddress.get(position));
        holder.tvUserName.setText(userName.get(position));
        holder.tvUserPhoneNumber.setText(userPhoneNumber.get(position));
        holder.tvUserEmail.setText(userEmail.get(position));
        holder.tvBookLendDate.setText(bookLendDate.get(position));
        holder.tvFromTime.setText(fromTime.get(position));

    }

    @Override
    public int getItemCount() {
        return bookName.size();
    }
}
