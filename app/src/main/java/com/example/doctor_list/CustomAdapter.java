package com.example.doctor_list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<String> docNames;
    ArrayList<String> designations;
    ArrayList<String> hospitals;
    Context context;
    public CustomAdapter(Context context, ArrayList<String>docNames , ArrayList<String> designations, ArrayList<String> hospitals) {
        this.context = context;
        this.docNames = docNames;
        this.designations = designations;
        this.hospitals = hospitals;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {
        //i = holder.getAdapterPosition();
        // set the data in items

        holder.name.setText(docNames.get(i));
        holder.designation.setText(designations.get(i));
        holder.hospital.setText(hospitals.get(i));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                //Toast.makeText(context, docNames.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public int getItemCount() {
        return docNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, designation, hospital;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
             designation = (TextView) itemView.findViewById(R.id.designation);
            hospital = (TextView) itemView.findViewById(R.id.hospital);

        }
    }









}
