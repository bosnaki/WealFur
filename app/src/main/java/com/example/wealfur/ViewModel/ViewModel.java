package com.example.wealfur.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.wealfur.AppRepository;
import com.example.wealfur.User;

public class ViewModel extends AndroidViewModel {

    private AppRepository appRepository;

    public ViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
    }


    public int getUserId(String email, String password){
       return appRepository.getUserId(email, password);
    }

    public void insertNewUserInfo(User user){
        appRepository.insertNewUserInfo(user);
    }


}
