package com.example.contactlist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context ;
    ArrayList username , userphone ;


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
        holder.viewname.setText(String.valueOf(username.get(position)));
        holder.viewphone.setText(String.valueOf(userphone.get(position)));
        
    }



    @Override
    public int getItemCount() {
        return username.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView viewname , viewphone ;
        ImageButton viewedit , viewdelete ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            viewname = itemView.findViewById(R.id.textViewName);
            viewphone = itemView.findViewById(R.id.textViewPhone);
            viewedit = itemView.findViewById(R.id.editButton);
            viewdelete = itemView.findViewById(R.id.deleteButton);

        }
    }
}


