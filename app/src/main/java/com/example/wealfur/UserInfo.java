package com.example.wealfur;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.ViewModelProvider;

import com.example.wealfur.ViewModel.ViewModel;

public class UserInfo {
    private AppDatabase appDatabase;
    private ViewModel viewModel;

    public UserInfo(Context context){
        appDatabase = AppDatabase.getInstance(context.getApplicationContext());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance((Application) context).create(ViewModel.class);
    }

    /*
     *

    public void addNewUser(String email, String password, String passwordRepeated){
        emailIsAlreadyUsed = false;
        falseRepeatedPassword = false;
        if (password.equals(passwordRepeated) && !viewModel.getIfAccountExistsWithEmail(email)){
            User user = new User();
            user.password = password;
            user.email = email;
            Log.d("EMAIL", email);
            viewModel.insertNewUserInfo(user);
            Log.d("VIEWMODEL", "success");
        }
        else if (!password.equals(passwordRepeated)){
            falseRepeatedPassword = true;
        }
        else if(viewModel.getIfAccountExistsWithEmail(email)){
            emailIsAlreadyUsed = true;
        }

    }
*/

}
