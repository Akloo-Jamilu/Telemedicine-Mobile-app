package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userName, password;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        userName = findViewById(R.id.editTextTextLoginUsername);
        password = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.buttonLogin);
        textView = findViewById(R.id.textViewNewUser);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUserName = userName.getText().toString();
                String newPasword = password.getText().toString();

                if (newUserName.length()==0 || newPasword.length()==0){
                    Toast.makeText(getApplicationContext(), "please key in your details", Toast.LENGTH_SHORT).show();

                }

                Toast.makeText(getApplicationContext(), "login Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}