package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    String Name,Age,Gender,Political_Party,Political_Experience,Father,Mother,Spouse,Educational_Qualification;
    Intent intent;
    TextView Candidate_Name,Candidate_Age,Candidate_Gender,Candidate_Political_Party,Candidate_Political_Experience,Candidate_Fathers_Name,Candidate_Mothers_Name,Candidate_Spouse_Name,Candidate_Educational_Qualification;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidate_data);

        intent = getIntent();
        Name = intent.getStringExtra("Name");
        Age = intent.getStringExtra("Age");
        Gender = intent.getStringExtra("Gender");
        Political_Party = intent.getStringExtra("Political Party");
        Political_Experience = intent.getStringExtra("Political Experience");
        Father = intent.getStringExtra("Father");
        Mother = intent.getStringExtra("Mother");
        Spouse = intent.getStringExtra("Spouse");
        Educational_Qualification = intent.getStringExtra("Educational Qualification");


       Candidate_Name =  findViewById(R.id.Name);
       Candidate_Age = findViewById(R.id.Age);
        Candidate_Gender = findViewById(R.id.Gender);
        Candidate_Political_Party = findViewById(R.id.Political_Party);
       Candidate_Political_Experience =  findViewById(R.id.Political_Experience);
        Candidate_Fathers_Name = findViewById(R.id.Fathers_Name);
        Candidate_Mothers_Name = findViewById(R.id.Mothers_Name);
        Candidate_Spouse_Name = findViewById(R.id.Spouse_Name);
        Candidate_Educational_Qualification = findViewById(R.id.Educational_Qualification);

        Candidate_Name.setText(Name);
        Candidate_Age.setText(Age);
        Candidate_Gender.setText(Gender);
        Candidate_Political_Party.setText(Political_Party);
        Candidate_Political_Experience.setText(Political_Experience);
        Candidate_Fathers_Name.setText(Father);
        Candidate_Mothers_Name.setText(Mother);
        Candidate_Spouse_Name.setText(Spouse);
        Candidate_Educational_Qualification.setText(Educational_Qualification);



    }
}