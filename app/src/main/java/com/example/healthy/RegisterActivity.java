package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText newUser, newEmail, newPassword, newConfirmPassword;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        newUser = findViewById(R.id.editTextTextNewUsername);
        newEmail = findViewById(R.id.textEmail);
        newPassword = findViewById(R.id.texPassword);
        newConfirmPassword = findViewById(R.id.editTextRegConfirmPassword);
        button = findViewById(R.id.buttonRegister);
        textView = findViewById(R.id.textViewExistingUser);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = newUser.getText().toString();
                String email = newEmail.getText().toString();
                String password = newPassword.getText().toString();
                String confirmPassword = newConfirmPassword.getText().toString();
                DBConnection db = new DBConnection(getApplicationContext(), "telemedicine", null, 1);

                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirmPassword.length() == 0){
                    Toast.makeText(getApplicationContext(), "please fill All details", Toast.LENGTH_SHORT).show();
                }else {
                    if (password.compareTo(confirmPassword) == 0){
                        if (isValid(password)){
                            db.register(username, email, password);
                            Toast.makeText(getApplicationContext(), "Record Inserted successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(), "password must contain at least 8 character, having letter, digit and special character", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "password and confirm password don't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public static boolean isValid(String passwordHere){
        int f1=0,f2=0,f3=0;
        if (passwordHere.length() < 8){
            return false;
        }else {
            for (int p = 0; p < passwordHere.length(); p++){
                if (Character.isLetter(passwordHere.charAt(p))){
                    f1=1;
                }
            }
            for (int r = 0; r < passwordHere.length(); r++){
                if (Character.isDigit(passwordHere.charAt(r))){
                    f2=1;
                }
            }
            for (int s = 0; s < passwordHere.length(); s++){
                char c = passwordHere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64){
                    f3=1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}