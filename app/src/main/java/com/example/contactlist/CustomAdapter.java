package com.example.contactlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context ;
    ArrayList username , userphone ;
    String person ;




    CustomAdapter(Context context , ArrayList username , ArrayList userphone){
        this.context = context ;
        this.username = username ;
        this.userphone = userphone ;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        person = String.valueOf(username.get(position)) ;
        holder.viewname.setText(person);
        holder.viewphone.setText(String.valueOf(userphone.get(position)));
        holder.pos = holder.getAdapterPosition();


    }



    @Override
    public int getItemCount() {
        return username.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView viewname , viewphone ;
        ImageButton viewedit , viewdelete ;
        int pos ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            DatabaseHelper myDb = new DatabaseHelper(context);
            viewname = itemView.findViewById(R.id.textViewName);
            viewphone = itemView.findViewById(R.id.textViewPhone);
            viewedit = itemView.findViewById(R.id.editButton);
            viewdelete = itemView.findViewById(R.id.deleteButton);
            viewdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("test","deleted "+pos);
                    //deleteContact(pos );
                    myDb.deleteContact(pos);
                }
            });
            viewedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("test","edited "+pos);
                    Intent intent = new Intent (context, updateActivity.class);
                    intent.putExtra("position", pos);
                    intent.putExtra("username", String.valueOf(username.get(pos)));
                    intent.putExtra("userphone", String.valueOf(userphone.get(pos)));

                    context.startActivity(intent);
                }
            });
        }
    }
}


