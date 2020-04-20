package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Constants{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textToSecondActivity = findViewById(R.id.editTextMainActivity);

        Button buttonToCecondActivity = findViewById(R.id.buttonMainActivity);
        buttonToCecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = textToSecondActivity.getText().toString();
               Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra(KEY_TEXT, txt);
               startActivity(intent);
            }
        });
    }
}
