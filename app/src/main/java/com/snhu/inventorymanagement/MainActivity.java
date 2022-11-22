package com.snhu.inventorymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    EditText userName = findViewById(R.id.userName);
    EditText passWord = findViewById(R.id.passWord);
    MaterialButton loginButton = findViewById(R.id.loginButton);
    MaterialButton  newUserButton = findViewById(R.id.newUser);
    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DBHelper(this);

        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String pass = passWord.getText().toString();
                if(user.equals("") || pass.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Fill in all fields",
                                    Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });


        loginButton.setOnClickListener(view -> {
            if (userName.getText().toString().equals("admin") && passWord.getText().toString().equals("admin")) {

                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            } else

                Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
        });
    }
}