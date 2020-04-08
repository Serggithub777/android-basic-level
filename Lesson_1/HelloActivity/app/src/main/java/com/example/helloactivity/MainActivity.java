package com.example.helloactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText enterText;
    private TextView textOut;
    View.OnClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterText = findViewById(R.id.editTextEnter);
        textOut = findViewById(R.id.textViewOut);
        ImageButton imageButton = findViewById(R.id.imageButton);
        Button buttonGo = findViewById(R.id.buttonGo);

        buttonGo.setOnClickListener(listener);

        listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonGo:
                        String str = enterText.getText().toString();
                        textOut.setText(str);
                        break;
                    case R.id.imageButton:
                        textOut.setText("Push Image Button!");
                }

            }
        };

    }
}
