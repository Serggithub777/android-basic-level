package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.onSelectedButtonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override //реализуем метод интерфейса
    public void onButtonSelected(String bodySms) {
        //вызываем менеджер фрагментов
        FragmentManager fm = getSupportFragmentManager();
        //получаем ссылку на второй фрагмент
        SecondFragment secondFragment = (SecondFragment) fm.findFragmentById(R.id.fragmentSecond);
        //если второй фрагмент не создан или не видим создаем и запускаем активность
        if (secondFragment == null || !secondFragment.isVisible()) {
           Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("SMS", bodySms);
            startActivity(intent);
        }else{
            secondFragment.setTextSmsBody(bodySms);
        }

    }
}
