package com.example.wealfur;

import android.content.Context;

public class UserInfo {
    private AppDatabase appDatabase;

    public UserInfo(Context context){
        appDatabase = AppDatabase.getInstance(context.getApplicationContext());
    }

    private boolean checkIfEmailExists(String email){
       int userId= appDatabase.userDAO().getAccountWithEmail(email);
       if (userId == 0 ){
           return false;
       }
       else {
           return true;
       }
    }

    private boolean checkIfPasswordIsTheSame(String email, String password){
        String pw = appDatabase.userDAO().getPasswordFromEmail(email);

        return password.equals(pw);
    }

    private void createNewUser(String email, String password){
        User user = new User();
        user.email = email;
        user.password = password;
        appDatabase.userDAO().insertUser(user);
    }

    public void signInUser(String email, String password){
        if (checkIfEmailExists(email)){
            //the user already exists with this email
        }
        else {
            createNewUser(email, password);
        }
    }

    public void checkForUserCredentials(String email, String password){
        if (checkIfEmailExists(email)){
            if (checkIfPasswordIsTheSame(email, password)){
                //LogIn
            }
            else {
                //Wrong password
            }
        }
        else {
            //The user doesnt exist
        }
    }
}
