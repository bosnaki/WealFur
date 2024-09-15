package com.example.wealfur;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.wealfur.ViewModel.ViewModel;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordRepeatEditText;
    private UserInfo userInfo;
    private ViewModel viewModel;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModel.class);
    }

    public void saveNewUserEmailAndPassword(View view) {
        Toast.makeText(this, "Signed Up!", Toast.LENGTH_SHORT).show();
        emailEditText = findViewById(R.id.emailAddressEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        User user = new User();
        user.password = password;
        user.email = email;
        Log.d("EMAIL", email);
        viewModel.insertNewUserInfo(user);
        Log.d("VIEWMODEL", "success");
        Intent mainPageIntent = new Intent(this, MainActivity.class);
        startActivity(mainPageIntent);
        //Log.d("USERID", String.valueOf(userid));
        //check if the email already exists
        //check if the passwords are the same
        //if non of these are true then save the user and move to the next page with the pets (no pets)
    }
}
