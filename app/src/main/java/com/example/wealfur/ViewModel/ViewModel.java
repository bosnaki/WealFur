package com.example.wealfur.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.wealfur.repository.AppRepository;
import com.example.wealfur.User;

/**
 * Implementing MVVM. This class checks if the password repeat is wrong and if the
 * email is already used and shows the appropriate message, otherwise it takes the user into
 * the next page.
 */
public class ViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    private MutableLiveData<Boolean> wrongPasswordRepeat = new MutableLiveData<>();
    private MutableLiveData<Boolean> emailAlreadyInUse = new MutableLiveData<>();
    private MutableLiveData<Boolean> signUpSuccessful = new MutableLiveData<>();
    private boolean accountExists;

    public ViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
        wrongPasswordRepeat.setValue(false);
        emailAlreadyInUse.setValue(false);
        signUpSuccessful.setValue(false);
    }


    public MutableLiveData<Boolean> getIfPasswordRepeatIsWrong(){
        return wrongPasswordRepeat;
    }

    public MutableLiveData<Boolean> getIfEmailIsAlreadyInUse(){
        return emailAlreadyInUse;
    }

    public MutableLiveData<Boolean> getIfSignUpIsSuccessful(){
        return signUpSuccessful;
    }

    /**
     * Adds the new user.
     * @param email user's email. Checks if the email is used
     * @param password user's password.
     * @param passwordRepeat user's password repeat. If this one is different than the above
     *                       the user gets an error.
     */
    public void addNewUser (String email, String password, String passwordRepeat){
        boolean samePasswords = checkIfPasswordAreTheSame(password, passwordRepeat);
        if (!password.equals(passwordRepeat)){
            wrongPasswordRepeat.setValue(true);
            return;
        }
        Log.d("ACCOUNT EXISTS IN VIEWMODEL IS", String.valueOf(accountExists));
        appRepository.checkIfAccountExistsWithEmail(email, new AppRepository.UserCallback() {
            @Override
            public void onUserFetched(User user) {
                if (user != null) {
                    // User already exists, notify the UI
                    emailAlreadyInUse.postValue(true);
                } else {
                    // User does not exist, proceed to add the user to the database
                    emailAlreadyInUse.postValue(false);
                    signUpSuccessful.postValue(true);
                    createUser(email, password); // Add user to database
                }
            }
        });
    }

    private void createUser(String email, String password){
        User user = new User();
        user.email = email;
        user.password = password;
        appRepository.insertNewUserInfo(user);
    }
    /**
     *     public LiveData<User> getIfAccountExistsWithEmail(String email){
     *         return appRepository.checkIfAccountExistsWithEmail(email);
     *     }
     */

    private boolean checkIfPasswordAreTheSame(String password, String passwordRepeat){
        return password.equals(passwordRepeat);
    }

    public void setAccountExists(boolean accountExists){
        Log.d("Account exists is", String.valueOf(accountExists));
        this.accountExists = accountExists;
    }

}
