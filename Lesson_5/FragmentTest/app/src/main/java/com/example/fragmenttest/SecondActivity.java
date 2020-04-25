package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //так как отображение в данной активити только портретное то проверяем
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish(); //закрываем актиыити
            return;
        }
         // если портретное отображаем второй фрагмент с результатом метода setTextSMSBody
        String bodySms = getIntent().getStringExtra("SMS");
        FragmentManager fm = getSupportFragmentManager();
        SecondFragment secondFragment = (SecondFragment) fm.findFragmentById(R.id.fragmentSecond);
        secondFragment.setTextSmsBody(bodySms);

    }
}
