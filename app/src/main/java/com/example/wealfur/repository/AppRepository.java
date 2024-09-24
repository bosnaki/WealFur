package com.example.wealfur.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.wealfur.AppDatabase;
import com.example.wealfur.User;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 */
public class AppRepository {

    private AppDatabase appDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();
    private int userId;
    private int petId;
    private User user;
    private boolean accountExists;

    public AppRepository(Context context){
        appDatabase = AppDatabase.getInstance(context.getApplicationContext());
    }

    public void insertNewUserInfo(User user){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.userDAO().insertUser(user);
            }
        });
    }

    public void checkUserInfo(String email, String password){
        executor.execute((new Runnable() {
            @Override
            public void run() {
                userId= appDatabase.userDAO().getAccountWithCredentials(email, password);
            }
        }));
    }

    public void retrievePetIdFromOwnerId(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                petId = appDatabase.petDAO().getPetIdFRomOwnerId(userId);
            }
        });
    }


    public int getPetId(){
        return petId;
    }

    /**
     *   public LiveData<User> checkIfAccountExistsWithEmail(String email){
     *         return appDatabase.userDAO().getUserFromEmail(email);
     *     }
     *     public boolean getIfAccountExistsWithEmail(String email){
     *        checkIfAccountExistsWithEmail(email);
     *
     *         accountExists = user != null;
     *         return accountExists;
     *     }
     * @param
     * @return
     */



    public interface UserCallback {
        void onUserFetched(User user);
    }

    public void checkIfAccountExistsWithEmail(String email, UserCallback callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                User user = appDatabase.userDAO().getUserFromEmail(email);
                callback.onUserFetched(user); // Call the callback with the fetched user
            }
        });
    }

    public int getUserId(String email, String password){
        checkUserInfo(email, password);
        return userId;
    }
}
