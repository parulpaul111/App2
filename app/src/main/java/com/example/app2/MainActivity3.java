package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Intent intent;
    EditText editText,editText1;
    TextView textView,textView1;
    Button button,button1;
    public static String[] election_names = {"Gram Panchayat Elections","Zila Panchayat Sadasya Elections","Municipality Elections","Municipal Corporation Elections","Nagar Panchayat Sadasya Elections","State Assembly Elections"};
    String string,string1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       intent = getIntent();

       final String election_name = intent.getStringExtra("Election_name");

       editText = findViewById(R.id.editText);
       editText1 = findViewById(R.id.editText1);
       textView = findViewById(R.id.text);
       textView1 = findViewById(R.id.text1);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

        if (election_name.equals(election_names[0])){
            textView.setText("Enter Name of Your Block");
            textView1.setText("Enter Name of Your Gram Panchayat");

        }else if (election_name.equals(election_names[1])){
            textView.setText("Enter Name of Your Ward");
            editText1.setAlpha(0);
            textView1.setAlpha(0);
            button.setText("NEXT");
            button1.setAlpha(0);


        }else if (election_name.equals(election_names[2]) || election_name.equals(election_names[3]) || election_name.equals(election_names[4])){
            textView.setText("Enter Name of Your Area");
            textView1.setText("Enter Name of Your Ward");
            editText1.setAlpha(0);



        }else {
            textView.setText("Enter Name of Your Constituency");
            editText1.setAlpha(0);
            textView1.setAlpha(0);
            button.setText("NEXT");
            button1.setAlpha(0);


        }


       if (editText1.getAlpha()!=0){
           button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (!editText.getText().toString().isEmpty()){
                       string = editText.getText().toString();
                   }else  {
                       Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_LONG).show();

                   }

               }
           });

           button1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (!editText1.getText().toString().isEmpty()){
                       string1 = editText1.getText().toString();
                       Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                       intent.putExtra("election_name",election_name);
                       intent.putExtra("string",string);
                       intent.putExtra("string1",string1);
                       startActivity(intent);
                   }else  {
                       Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_LONG).show();

                   }
               }
           });

       }else {
           button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (!editText.getText().toString().isEmpty()){
                       string = editText.getText().toString();
                       if (!string.isEmpty()){
                           Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                           intent.putExtra("election_name",election_name);
                           intent.putExtra("string",string);
                           intent.putExtra("string1","");
                           startActivity(intent);
                       }
                   }else  {
                       Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_LONG).show();
                   }
               }
           });
       }

    }






}