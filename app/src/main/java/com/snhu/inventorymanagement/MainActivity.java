package com.snhu.inventorymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userName = findViewById(R.id.userName);
        TextView passWord = findViewById(R.id.passWord);
        MaterialButton loginButton = findViewById(R.id.loginButton);


        loginButton.setOnClickListener(view -> {
            if (userName.getText().toString().equals("admin") && passWord.getText().toString().equals("admin")) {

                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            } else

                Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
        });
    }
}