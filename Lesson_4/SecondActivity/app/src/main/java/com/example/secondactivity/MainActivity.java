package com.example.secondactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Constants{
  private  EditText textNameToSecondActivity ;
  private EditText textIDtoSecondActivity ;

  public static final int REQUEST_CODE_2_ACTIVITY=1; //для того чтобы знать от какой активити возвращается
    //результат создаем константу int REQUEST_CODE_2_ACTIVITY

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
                intent.putExtra(KEY_PARCEL, createParcel());
               startActivityForResult(intent, REQUEST_CODE_2_ACTIVITY);
            }
        });
    }

    @Override//переопределяем метод onActivityResult для обработки возвращенного результата
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_2_ACTIVITY && resultCode == RESULT_OK) {
            textNameToSecondActivity.setText(data.getStringExtra(KEY_NAME));
        } else if (requestCode!=REQUEST_CODE_2_ACTIVITY)//если requestCode не равен значит данные не этой активити
            //обрабатываются для выхода в супер классе
            super.onActivityResult(requestCode, resultCode, data);
    }

    private Parсel createParcel() {
        Parсel parсel = new Parсel();
        parсel.id = textIDtoSecondActivity.getText().toString();
        parсel.name = textNameToSecondActivity.getText().toString();
        return parсel;
    }
}
