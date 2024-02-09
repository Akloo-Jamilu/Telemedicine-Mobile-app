package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        username = findViewById(R.id.editTextTextLoginUsername);
        password = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.buttonLogin);
        textView = findViewById(R.id.textView);
    }
}