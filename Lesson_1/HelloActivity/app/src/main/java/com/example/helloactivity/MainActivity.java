package com.example.helloactivity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText enterText;
    private TextView textOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterText = findViewById(R.id.editTextEnter);
        textOut = findViewById(R.id.textViewOut);
        ImageButton imageButton = findViewById(R.id.imageButton);
        Button buttonGo = findViewById(R.id.buttonGo);

        View.OnClickListener listener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonGo:
                        Toast.makeText(MainActivity.this,"Push Button GO!",Toast.LENGTH_SHORT).show();
                        String str = enterText.getText().toString();
                        textOut.setText(str);
                        break;
                    case R.id.imageButton:
                        Toast.makeText(MainActivity.this,"Push Image Button!",Toast.LENGTH_SHORT).show();
                        String text = "Push Image Button!!";
                        textOut.setText(text);
                        break;
                }

            }
        };
        buttonGo.setOnClickListener(listener);
        imageButton.setOnClickListener(listener);
    }
}
