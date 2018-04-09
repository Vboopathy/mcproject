# Team 18. E-Book Club.

We created  a mobile application called “E-BookClub”. The key functionality of the app is to let
users lend and borrow books to each other using location. The borrower will be able to see the
approximate location of the user and then decide if he can borrow the book. We have built the aplpication
on the back of Firebase for its Database and oAuth. We have also implemented internet functionalities and
GPS/location services.

## Libraries
Provide a list of **ALL** the libraries you used for your project. Example:

**firebase database** Firebase was used to create store and update data.
**firebase oAuth** Used to implement login and registration features of the application
**firebase UI** Used to implement RecyclerView



## Installation Notes
Clone project into Android Studo. Sync files if needed, Build and Run.

Login details: email: mzimola@gmail.com, pass: useradmin


## Code Examples
You will encounter roadblocks and problems while developing your project. Share 2-3 'problems' that your team solved while developing your project. Write a few sentences that describe your solution and provide a code snippet/block that shows your solution. Example:

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

## Feature Section
- Firebase
- Location Services / Map View
- Internet


## Final Project Status
Write a description of the final status of the project. Did you achieve all your goals? What would be the next step for this project (if it were to continue)?

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
Use IEEE citation style.
What to include in your project sources:
- Stock images
- Design guides
- Programming tutorials
- Research material
- Android libraries
- Everything listed on the Dalhousie [*Plagiarism and Cheating*](https://www.dal.ca/dept/university_secretariat/academic-integrity/plagiarism-cheating.html)
- Remember AC/DC *Always Cite / Don't Cheat* (see Lecture 0 for more info)

[1] "Java (programming language)", En.wikipedia.org, 2018. [Online]. Available: https://en.wikipedia.org/wiki/Java_(programming_language).