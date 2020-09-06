package com.example.app2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ElectionAdapter extends RecyclerView.Adapter<ElectionAdapter.ElectionViewHolder> {
    ArrayList<String> election_type;


    @NonNull
    @Override
    public ElectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_elections,parent,false);
        return new ElectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ElectionViewHolder holder, int position) {
        holder.textView.setText(election_type.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.textView.getContext(),MainActivity3.class);
                intent.putExtra("Election_name",holder.textView.getText().toString());
                holder.itemView.getContext().startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return election_type.size();
    }

    public static class ElectionViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public ElectionViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.election_name);


        }

    }

    public ElectionAdapter(ArrayList<String> election_type){
        this.election_type = election_type;


    }
}
