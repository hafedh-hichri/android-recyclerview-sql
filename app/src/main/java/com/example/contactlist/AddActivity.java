package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText name , phone  ;
    Button button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.userName);
        phone = findViewById(R.id.phoneNumber);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseHelper myDB = new DatabaseHelper(AddActivity.this);
                myDB.addContact(name.getText().toString().trim(),
                        Integer.parseInt(phone.getText().toString().trim()));
            }
        });

        
    }
}