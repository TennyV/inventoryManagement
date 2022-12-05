package com.snhu.inventorymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    Button addButton, subtractButton, settingsButton;
    EditText inventoryAdd, addQuantity;
    Switch toggleSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Edit Text
        inventoryAdd = findViewById(R.id.inventoryAdd);
        addQuantity = findViewById(R.id.addQuantity);
        //Buttons for program
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        settingsButton = findViewById(R.id.settingsButton);

        //button listeners for add and view buttons
        addButton.setOnClickListener(v -> {

            try {ItemAtttributes itemAtttributes = new ItemAtttributes(-1, inventoryAdd.getText().toString(),
                    Integer.parseInt(addQuantity.getText().toString()));
                Toast.makeText(AddItemActivity.this, itemAtttributes.toString(), Toast.LENGTH_SHORT).show();

            }
            catch (Exception e) {
                Toast.makeText(AddItemActivity.this, "Error creating item", Toast.LENGTH_SHORT).show();
            }

        });
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddItemActivity.this, "Sub Button", Toast.LENGTH_SHORT).show();
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddItemActivity.this, "Settings Button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}