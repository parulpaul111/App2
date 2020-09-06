package com.example.app2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder> {
    public static ArrayList<AllCandidates> all_candidates;


    @NonNull
    @Override
    public CandidateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_candidates,parent,false);
        return new CandidateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CandidateViewHolder holder, final int position) {
        holder.textView.setText(all_candidates.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.textView.getContext(),MainActivity5.class);
                intent.putExtra("Name",all_candidates.get(position).getName());
                intent.putExtra("Age",all_candidates.get(position).getAge());
                intent.putExtra("Gender",all_candidates.get(position).getGender());
                intent.putExtra("Political Party",all_candidates.get(position).getPolitical_Party());
                intent.putExtra("Political Experience",all_candidates.get(position).getPolitical_Experience());
                intent.putExtra("Father",all_candidates.get(position).getFathers_Name());
                intent.putExtra("Mother",all_candidates.get(position).getMothers_Name());
                intent.putExtra("Spouse",all_candidates.get(position).getSpouse_Name());
                intent.putExtra("Educational Qualification",all_candidates.get(position).getEducational_Qualification());
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return all_candidates.size();
    }

    public static class CandidateViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public CandidateViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.candidate_name);
        }

    }

    public CandidateAdapter(ArrayList<AllCandidates> all_candidates){
        this.all_candidates = all_candidates;
    }
}
