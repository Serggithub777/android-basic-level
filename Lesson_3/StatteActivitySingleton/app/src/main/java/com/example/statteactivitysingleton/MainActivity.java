package com.example.statteactivitysingleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else instanceState = "Второй запуск!";
        Toast.makeText(getApplicationContext(), "onCreate() " + instanceState, Toast.LENGTH_SHORT).show();

    }
}
