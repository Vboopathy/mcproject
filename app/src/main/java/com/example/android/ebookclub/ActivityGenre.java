package com.example.android.ebookclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityGenre extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    FirebaseAuth AuthRef;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        AuthRef = FirebaseAuth.getInstance();
        mAuth = FirebaseAuth.getInstance();

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {

                            case R.id.nav_lend:
                                callIntent(ActivityLend.class);
                                break;

                            case R.id.nav_borrow:
                                callIntent(BorrowBookActivity.class);
                                break;

                            case R.id.nav_events:
                                callIntent(ActivityBookclub.class);
                                break;

                            case R.id.nav_profile:
                                callIntent(ActivityProfile.class);
                                break;

                            case R.id.nav_logout:
                                  signOut();
                                  break;
//                                if(FirebaseAuth.getInstance().getCurrentUser() == null) {
//                                    System.out.println("Sign out successful");
//                                }

//
                        }
//
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });


        Button buttonfiction = findViewById(R.id.buttonfiction);
        Button buttonromance = findViewById(R.id.buttonromance);
        Button buttonhorror = findViewById(R.id.buttonhorror);
        Button buttonselfhelp = findViewById(R.id.buttonselfhelp);

        buttonfiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityGenre.this, ActivityGenreDrama.class);
                startActivity(intent);
            }
        });


        buttonromance.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityGenre.this, ActivityGenreRomance.class);
                startActivity(intent);
            }
        });


        buttonhorror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityGenre.this, ActivityGenreHorror.class);
                startActivity(intent);
            }
        });

        buttonselfhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityGenre.this, ActivityGenreSelfhelp.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


    public void bookclub(View view) {
        callIntent(ActivityBookclub.class);
    }

    public void callIntent(Class className){
        Intent intent = new Intent(getApplicationContext(), className);
        startActivity(intent);
    }


    private void sendToLogin(){
        Intent intent = new Intent(ActivityGenre.this, ActivityLogin.class);
        startActivity(intent);
        finish();
    }

    public void signOut(){
        AuthRef.signOut();
        sendToLogin();
    }


    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser == null){
            sendToLogin();
        }
    }

}

