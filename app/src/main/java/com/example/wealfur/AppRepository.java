package com.example.wealfur;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {

    private AppDatabase appDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();
    private int userId;
    private int petId;

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


}
