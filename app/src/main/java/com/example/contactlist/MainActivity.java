package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    FloatingActionButton add_button ;


    DatabaseHelper myDb ;
    ArrayList<String> id , username , userphone ;
    CustomAdapter customAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.floatingActionButton);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , AddActivity.class);
                startActivity(intent);
            }
        });

        myDb = new DatabaseHelper(MainActivity.this);
        id = new ArrayList<>();
        username = new ArrayList<>() ;
        userphone = new ArrayList<>() ;


        storeData();

        customAdapter = new CustomAdapter(MainActivity.this,username,userphone);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }


    void storeData(){
        Cursor cursor = myDb.readAllData();
        if(cursor.getCount() ==0 ){
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                username.add(cursor.getString(1));
                userphone.add(cursor.getString(2));

            }


        }


    }


}