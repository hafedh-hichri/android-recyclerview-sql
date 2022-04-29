package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateActivity extends AppCompatActivity {
    EditText username , userphone ;
    Button update ;
    String id ,name , phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);
        username = findViewById(R.id.userName2);
        userphone = findViewById(R.id.phoneNumber2);
        update = findViewById(R.id.button2);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper myDB = new DatabaseHelper(updateActivity.this);
                name = username.getText().toString().trim();
                phone = userphone.getText().toString().trim();
                myDB.updateData(id, name, phone);
            }
        });



        getAndSetIntentData();

    }

    void getAndSetIntentData(){
        if((getIntent().hasExtra("position"))&&(getIntent().hasExtra("username"))&&getIntent().hasExtra("userphone") ){
            //Getting Data from Intent
            //id = getIntent().getStringExtra("position");
            id = getIntent().getStringExtra("position");
            name = getIntent().getStringExtra("username");
            phone = getIntent().getStringExtra("userphone");
            username.setText(name);
            userphone.setText(phone);

            //Setting Intent Data
            /*
            title_input.setText(title);
            author_input.setText(author);
            pages_input.setText(pages);
            Log.d("stev", title+" "+author+" "+pages);*/
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }



}