package com.snhu.inventorymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button loginButton, newUserButton;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.userName);
        password = findViewById(R.id.passWord);

        loginButton = findViewById(R.id.loginButton);
        newUserButton = findViewById(R.id.newUser);


    newUserButton.setOnClickListener(new View.OnClickListener() {
        InventoryUser newUser;

        public void onClick(View v) {

            if (username.equals("") || password.equals(""))
                Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            else {
                //create user
                newUser = new InventoryUser(-1, username.getText().toString(),
                        password.getText().toString(), 8675309L, false);

                //check to see if username is in DB
                if(db.checkDBforUser(newUser, false)) {
                    Toast.makeText(LoginActivity.this, "User in database.", Toast.LENGTH_SHORT).show();
                }else
                {
                    boolean success = db.addUser(newUser);
                    if(success) {

                        Toast.makeText(LoginActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginActivity.this, "Registered", Toast.LENGTH_SHORT).show();Intent intent = new Intent(getApplicationContext(), AddItemActivity.class);
                        startActivity(intent);

                    }   else
                    {
                        Toast.makeText(LoginActivity.this, "Failed!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    });
        loginButton.setOnClickListener(view -> {

        if (username.equals("") || password.equals(""))
            Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        else {


            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), AddItemActivity.class);
            startActivity(intent);
        }
    });
}

    }


