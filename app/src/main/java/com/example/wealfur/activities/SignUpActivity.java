package com.example.wealfur.activities;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.wealfur.R;
import com.example.wealfur.User;
import com.example.wealfur.UserInfo;
import com.example.wealfur.ViewModel.ViewModel;

/**
 * This activity contains the necessary code for the Sign-Up activity. Use of MVVM, Room database and LiveData.
 */
public class SignUpActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordRepeatEditText;
    private TextView emailIsInUseTextView;
    private TextView falseRepeatedPasswordTextView;
    private UserInfo userInfo;
    private ViewModel viewModel;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        userInfo = new UserInfo(this.getApplicationContext());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(ViewModel.class);
        emailIsInUseTextView = findViewById(R.id.email_already_used);
        falseRepeatedPasswordTextView = findViewById(R.id.falseRepeatedPasswordTextView);
        emailEditText = findViewById(R.id.emailAddressEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordRepeatEditText = findViewById(R.id.passwordRepeatEditText);
        final Observer<Boolean> falseRepeatedPasswordObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showWrongRepeatedPassword(aBoolean);
            }
        };

        final Observer<Boolean> emailAlreadyInUseObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showEmailIsAlreadyInUseTextView(aBoolean);
            }
        };

        final Observer<Boolean> signUpSuccessfulObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                navigateToNextPage(aBoolean);
            }
        };

        viewModel.getIfPasswordRepeatIsWrong().observe(this, falseRepeatedPasswordObserver);
        viewModel.getIfEmailIsAlreadyInUse().observe(this, emailAlreadyInUseObserver);
        viewModel.getIfSignUpIsSuccessful().observe(this, signUpSuccessfulObserver);

    }

    public void saveNewUserEmailAndPassword(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String passwordRepeated = passwordRepeatEditText.getText().toString();
        viewModel.addNewUser(email, password, passwordRepeated);
    }

    private void showEmailIsAlreadyInUseTextView(boolean emailInUse){
        if (emailInUse){
            emailIsInUseTextView.setVisibility(View.VISIBLE);
        }
        else{
            emailIsInUseTextView.setVisibility(View.INVISIBLE);
        }
    }

    private void showWrongRepeatedPassword(boolean falsePassword){
        if (falsePassword){
            falseRepeatedPasswordTextView.setVisibility(View.VISIBLE);
        }
        else{
            falseRepeatedPasswordTextView.setVisibility(View.INVISIBLE);
        }
    }

    private void navigateToNextPage(boolean signUpSuccess){
        if (signUpSuccess){
            Toast.makeText(this, "Signed Up!", Toast.LENGTH_SHORT).show();
            Intent mainPageIntent = new Intent(this, MainActivity.class);
            startActivity(mainPageIntent);
        }
    }
}
