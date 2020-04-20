package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Constants{
  private  EditText textNameToSecondActivity ;
  private EditText textIDtoSecondActivity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNameToSecondActivity = findViewById(R.id.editTextMainActivityName);
        textIDtoSecondActivity = findViewById(R.id.editTextMainID);

        Button buttonToSecondActivity = findViewById(R.id.buttonMainActivity);
        buttonToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra(KEY_TEXT, createParcel());
               startActivity(intent);
            }
        });
    }

    private Parсel createParcel() {
        Parсel parсel = new Parсel();
        parсel.id = textIDtoSecondActivity.getText().toString();
        parсel.name = textNameToSecondActivity.getText().toString();
        return parсel;
    }
}
