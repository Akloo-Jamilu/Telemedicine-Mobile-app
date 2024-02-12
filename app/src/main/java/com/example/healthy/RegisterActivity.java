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
                String user = newUser.getText().toString();
                String email = newEmail.getText().toString();
                String password = newPassword.getText().toString();
                String confirmPassword = newConfirmPassword.getText().toString();

                if (user.length() == 0 || email.length() == 0 || password.length() == 0 || confirmPassword.length() == 0){
                    Toast.makeText(getApplicationContext(), "please fill All details", Toast.LENGTH_SHORT).show();
                }else {
                    if (password.compareTo(confirmPassword) == 0){

                    }else {
                        Toast.makeText(getApplicationContext(), "password and confirm password don't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}