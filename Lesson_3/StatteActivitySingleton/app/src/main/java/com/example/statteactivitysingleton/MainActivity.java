package com.example.statteactivitysingleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
        final TextView textCounter = findViewById(R.id.textViewCounter);
        final MainPresenter presenter = MainPresenter.getInstance();
        textCounter.setText(((Integer)presenter.getCounter()).toString());
        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.incrementCounter();
                textCounter.setText(((Integer)presenter.getCounter()).toString());
            }
        });
    }
}
