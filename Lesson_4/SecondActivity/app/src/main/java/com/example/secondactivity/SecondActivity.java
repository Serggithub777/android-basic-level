package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements Constants{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String text = getIntent().getStringExtra(KEY_TEXT);
        TextView textViewFromMain = findViewById(R.id.textViewSecondActivity);
        textViewFromMain.setText(text);

        Button buttonToMainActivity = findViewById(R.id.buttonSecondActivity);
        buttonToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onBackPressed();
                finish();
            }
        });
    }
}
