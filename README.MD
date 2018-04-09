# Team 18. E-Book Club.

We created  a mobile application called “E-BookClub”. The key functionality of the app is to let
users lend and borrow books to each other using location. The borrower will be able to see the
approximate location of the user and then decide if he can borrow the book. We have built the aplpication
on the back of Firebase for its Database and oAuth. We have also implemented internet functionalities and
GPS/location services.

## Libraries

**firebase database** Firebase was used to create store and update data.

**firebase oAuth** Used to implement login and registration features of the application

**firebase UI** Used to implement RecyclerView

**Google Places API** Used to get the lending location from the user. 

## Installation Notes
Clone project into Android Studo. Sync files if needed, Build and Run.

Login details: email: mzimola@gmail.com, pass: useradmin.

You can also create a profile, however, the You will not have a user image.

## Code Examples
**Problem 1: Updating Profile**

Updating the profile was tricky. Because the textfields in the update view are filled in through hints, the
text values are not null, they are just an empty string "". After trial and error we were able to figure out
how to let the user update their profile and send the data to firebase properly. The key was creating the isEditTextEmpty() method.

A short description.
```
    public void saveProfile(View view){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


        userTable.orderByChild("email").equalTo(currentUser.getEmail()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Set values in Profile to those in database.

                if(!isEditTextEmpty(name)){
                    System.out.println(name.getText().toString());
                    dataSnapshot.getRef().child("name").setValue(name.getText().toString());}
                if(!isEditTextEmpty(bio)){
                    dataSnapshot.getRef().child("bio").setValue(bio.getText().toString());}
                if(!isEditTextEmpty(city)){
                    dataSnapshot.getRef().child("city").setValue(city.getText().toString());}
                //int duration = Toast.LENGTH_SHORT;
                //Toast toast = Toast.makeText(context, "Saved Profile.", duration);
                //toast.show();
                sendToMain();
            }
}

    private boolean isEditTextEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }
```

**Problem 2 - Google Place picker**
We faced problems with connecting to Google API and getting the lend location. The following snippet deals with the location permissions.

```
     private void requestPermission()
    {
        //LOOK INTO MANIFEST AND CHECK IF THE PERMISSION IS GRANTED, IF IT IS NOT GRANTED IT THIS WILL BY PASS THE CODE
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
        }
    }

    //Requesting permission to location
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch ( requestCode )
        {
            case MY_PERMISSION_FINE_LOCATION :
                if(grantResults[0] !=PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(getApplicationContext(), "This App requires location permission to be granted!", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;

        }

    }
```

## Feature Section
- Firebase
- Location Services / Map View
- Internet


## Final Project Status

We ended up reaching all of our goals. As a team with 5 members who did not have any experience with MVC / framework development
we learned a lot, and accomplished a significant amount. As you will see below, all of our features have been implemented. The next step for the application would to give the UI an overhaul as it is still clunky and not modern.

#### Minimum Functionality
- Feature 1 Create UI Prototype (Completed)
- Feature 2 Database setup (Completed)
- Feature 3 Login and Registration (Completed)

#### Expected Functionality
- Feature 1 Borrow book ability (Completed)
- Feature 2 Lend book ability (Completed)
- Feature 3 Set time to meet (Completed)
- Feature 4 Map view to let user select location (Completed)
- Feature 5 User profile page (Completed)

#### Bonus Functionality
- Feature 1 Trusted user (Completed)
- Feature 2 User ratings (Completed)
- Feature 3 Book club events (Completed)

## Sources
[1] "Java (programming language)", En.wikipedia.org, 2018. [Online]. Available: https://en.wikipedia.org/wiki/Java_(programming_language).
[2] "Android Firebase Tutorials", TVAC Studio, 2018. [Online]. Available: https://www.youtube.com/user/akshayejh/videos
[3] "Time picker code", https://stackoverflow.com/questions/17901946/timepicker-dialog-from-clicking-edittext
