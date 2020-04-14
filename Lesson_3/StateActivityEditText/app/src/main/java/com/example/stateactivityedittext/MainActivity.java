package com.example.stateactivityedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int counter;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;

        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else instanceState = "Повторный запуск!";
        Toast.makeText(getApplicationContext(), "onCreate()" + instanceState, Toast.LENGTH_SHORT).show();

        text = findViewById(R.id.editTextViewCounter);
        text.setText(((Integer) counter).toString());
        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                text.setText(((Integer) counter).toString());
            }
        });
    }}