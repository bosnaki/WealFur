package com.example.wealfur.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.wealfur.AppDatabase;
import com.example.wealfur.R;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    String email;
    String password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Database").build();
    }

    public void verifyLoginCredentials(View view) {
        emailEditText = findViewById(R.id.emailAddressEditText);
        if (emailEditText.getText() != null){
            email = String.valueOf(emailEditText.getText());
        }
        passwordEditText = findViewById(R.id.passwordEditText);
        if (passwordEditText.getText() != null){
            password = String.valueOf(passwordEditText.getText());
        }
        checkLoginCredentials(email, password);

    }
    private void checkLoginCredentials(String email, String password){
        if (!email.equals("aa") && !password.equals("bb")){
            showWrongCredentialsMessage();
        }
        else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }
    private void showWrongCredentialsMessage() {
        Toast.makeText(this, "Wrong email or password", Toast.LENGTH_LONG).show();
    }

    public void signUp(View view) {
        Intent signUpIntent = new Intent(this, SignUpActivity.class);
        startActivity(signUpIntent);
    }
}
