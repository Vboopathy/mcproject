package com.example.android.ebookclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BorrowBookActivity extends AppCompatActivity {

    // variable declaration
    EditText searchBook;
    RecyclerView displayBooks;
    DatabaseReference databaseReference;
    ArrayList<String> bookName;
    ArrayList<String> bookDesc;
    ArrayList<String> bookLendDate;
    ArrayList<String> userEmail;
    ArrayList<String> fromTime;
    ArrayList<String> userName;
    ArrayList<String> userPhoneNumber;
    ArrayList<String> placeAddress;
    ArrayList<String> placeName;

    SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_book);
        searchBook = findViewById(R.id.searchBook);
        displayBooks = findViewById(R.id.displayBooks);
        databaseReference = FirebaseDatabase.getInstance().getReference("lend");
        bookName = new ArrayList<>();
        bookDesc = new ArrayList<>();
        bookLendDate = new ArrayList<>();
        userEmail = new ArrayList<>();
        fromTime = new ArrayList<>();
        userName = new ArrayList<>();
        userPhoneNumber = new ArrayList<>();
        placeAddress = new ArrayList<>();
        placeName = new ArrayList<>();

        displayBooks.setHasFixedSize(true);
        displayBooks.setLayoutManager(new LinearLayoutManager(this));
        displayBooks.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // text change listener for search of every text
        searchBook.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty()){
                    // method call if search string is not empty
                    SetAdapter(editable.toString());
                } else {
                    bookName.clear();
                    bookDesc.clear();
                    bookLendDate.clear();
                    userEmail.clear();
                    fromTime.clear();
                    userName.clear();
                    userPhoneNumber.clear();
                    placeAddress.clear();
                    placeName.clear();
                    displayBooks.removeAllViews();
                }

            }
        });

    }
    private void SetAdapter(final String searchString){

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // clear the list
                bookName.clear();
                bookDesc.clear();
                bookLendDate.clear();
                userEmail.clear();
                fromTime.clear();
                userName.clear();
                userPhoneNumber.clear();
                placeAddress.clear();
                placeName.clear();
                displayBooks.removeAllViews();

                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    // retrieve data from firebase
                    String bookID = snapshot.getKey();
                    String bookNameDb = "Book Name :  " + snapshot.child("book").getValue(String.class);
                    String bookPlaceAddress =  snapshot.child("placeAddress").getValue(String.class);
                    String bookPlaceName = "Place :  " + snapshot.child("placeName").getValue(String.class);
                    String bookDescription = "Comments :  " + snapshot.child("description").getValue(String.class);
                    String bookLendingDate = "Date :  " + snapshot.child("date").getValue(String.class);
                    String userEmailDb = "Lender Email ID :  " + snapshot.child("email").getValue(String.class);
                    String fromTimeDb = "Time :  " + snapshot.child("fromTime").getValue(String.class)+" - "+snapshot.child("toTime").getValue(String.class);
                    String UserNameDb = "Lender Name :  " + snapshot.child("name").getValue(String.class);
                    String UserPhoneNum = "Lender Phone Number :  " + snapshot.child("phoneNumber").getValue(String.class);

                    // perform comparison for search string and store related data
                    if(bookNameDb.toLowerCase().contains(searchString.toLowerCase()) || bookPlaceAddress.toLowerCase().contains(searchString.toLowerCase())){
                        bookName.add(bookNameDb);
                        bookDesc.add(bookDescription);
                        bookLendDate.add(bookLendingDate);
                        userEmail.add(userEmailDb);
                        fromTime.add(fromTimeDb);
                        userName.add(UserNameDb);
                        userPhoneNumber.add(UserPhoneNum);
                        placeAddress.add(bookPlaceAddress);
                        placeName.add(bookPlaceName);
                    }
                }

                // set value to the adapter
                searchAdapter = new SearchAdapter(BorrowBookActivity.this, bookName, bookDesc, bookLendDate, userEmail, fromTime, userName, userPhoneNumber, placeAddress, placeName);
                displayBooks.setAdapter(searchAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
