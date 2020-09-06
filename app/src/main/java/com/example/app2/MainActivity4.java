package com.example.app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    Intent intent;
    String string2,string3,name_of_election;
    DatabaseReference reference;
    ArrayList<AllCandidates> Candidates = new ArrayList<AllCandidates>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView = findViewById(R.id.Name_of_Election);


        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        intent = getIntent();
        name_of_election =  intent.getStringExtra("election_name");
        string2 = intent.getStringExtra("string");
        string3 = intent.getStringExtra("string1");

        textView.setText(name_of_election);
        get_candidates(MainActivity2.State,MainActivity2.District,name_of_election,string2,string3);

    }

    private void get_candidates(String state, String district, String name_of_election, String string2, String string3) {
        if (string3.isEmpty()){
        reference = FirebaseDatabase.getInstance().getReference("Users").child("India").child(state).child(district).child(name_of_election).child(string2).child("Candidate");
        }else {
            reference = FirebaseDatabase.getInstance().getReference("Users").child("India").child(state).child(district).child(name_of_election).child(string2).child(string3).child("Candidate");
        }



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Candidates.add(dataSnapshot1.getValue(AllCandidates.class));
                }

                adapter = new CandidateAdapter(Candidates);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







    }


}