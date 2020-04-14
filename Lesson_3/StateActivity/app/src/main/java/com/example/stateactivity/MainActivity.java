package com.example.stateactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int counter;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;

        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else instanceState = "Повторный запуск!";
        Toast.makeText(getApplicationContext(), "onCreate()" + instanceState, Toast.LENGTH_SHORT).show();

        text = findViewById(R.id.textViewCounter);
        text.setText(((Integer) counter).toString());
        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                text.setText(((Integer) counter).toString());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        saveInstanceState.putInt("Counter", counter);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "Повторный запуск! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        counter = savedInstanceState.getInt("Counter");
        text.setText(((Integer)counter).toString());
    }
}
