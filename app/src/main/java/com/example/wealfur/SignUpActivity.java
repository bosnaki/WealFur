package com.example.wealfur;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordRepeatEditText;
    private UserInfo userInfo;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
    }

    public void saveNewUserEmailAndPassword(View view) {
        Toast.makeText(this, "Signed Up!", Toast.LENGTH_SHORT).show();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        userInfo.signInUser(email, password);
        //check if the email already exists
        //check if the passwords are the same
        //if non of these are true then save the user and move to the next page with the pets (no pets)
    }
}
