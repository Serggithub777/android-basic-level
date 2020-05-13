package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements Constants{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Parсel parсel = (Parсel) getIntent().getSerializableExtra(KEY_PARCEL);
        TextView textViewID = findViewById(R.id.textViewID);
        textViewID.setText(parсel.id);
        TextView textViewName = findViewById(R.id.textViewNmae);
        textViewName.setText(parсel.name);



        Button buttonToMainActivity = findViewById(R.id.buttonSecondActivity);
        buttonToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onBackPressed();
                Intent intentResult = new Intent(); //создаем интент для отправки результата
                intentResult.putExtra(KEY_NAME, "HELLO");
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });
    }
}
