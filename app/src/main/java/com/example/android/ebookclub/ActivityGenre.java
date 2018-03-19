package com.example.android.ebookclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ActivityGenre extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    FirebaseAuth AuthRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        AuthRef = FirebaseAuth.getInstance();

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

//                        switch(menuItem.getItemId()){
//
//                            case R.id.nav_lend:
//                                callIntent(MainActivity.class);
//                                break;
//
//                            case R.id.nav_borrow:
//                                callIntent(CourseList.class);
//                                break;
//
//                            case R.id.nav_events:
//                                callIntent(StudentCoursesActivity.class);
//                                break;


//                            case R.id.nav_logout:
//                                AuthRef.signOut();
//                                if(FirebaseAuth.getInstance().getCurrentUser() == null) {
//                                    System.out.println("Sign out successful");
//                                }
////                                callIntent(MainActivity.class);
//                                break;
//
//                        }
//
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });




        Button buttonfiction = findViewById(R.id.buttonfiction);

        buttonfiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityGenre.this, ActivityGenreDrama.class);
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
    }

