package com.snhu.inventorymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button loginButton, newUserButton;
    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.userName);
        password = findViewById(R.id.passWord);
        loginButton = findViewById(R.id.loginButton);
        newUserButton = findViewById(R.id.newUser);


        myDb = new DBHelper(this);

        newUserButton.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if(user.equals("")||pass.equals(""))
                Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            else
            {
                if(user.equals(user)) {
                    Boolean checkuser = myDb.checkUserName(user);
                    if(!checkuser) {
                        Boolean insert = myDb.insertData(user, pass);
                        if(insert){
                            Toast.makeText(MainActivity.this,"Registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                        }else
                        {
                            Toast.makeText(MainActivity.this,"Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else
                {
                    Toast.makeText(MainActivity.this, "User already exists!",Toast.LENGTH_SHORT).show();
                }
                if(user.equals(user) && pass.equals(pass)){
                    Boolean checkUserAndPass = myDb.checkUserNamePassWord(user,pass);
                    if(!checkUserAndPass) {


                    }
                }
            }



        });
        loginButton.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if(user.equals("")||pass.equals(""))
                Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            else {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}