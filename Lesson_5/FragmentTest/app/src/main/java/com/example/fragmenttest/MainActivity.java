package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.onSelectedButtonListener {
    private boolean mIsDynamic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        SecondFragment secondFragment = (SecondFragment) fm.findFragmentById(R.id.fragmentSecond);
        mIsDynamic = secondFragment == null || !secondFragment.isInLayout();
        if (mIsDynamic) {
            FragmentTransaction ft = fm.beginTransaction();
            FirstFragment firstFragment = new FirstFragment();
            ft.add(R.id.container, firstFragment, "first_fragment");
            ft.commit();

        }

    }

    @Override //реализуем метод интерфейса
    public void onButtonSelected(String bodySms) {
        //вызываем менеджер фрагментов
        FragmentManager fm = getSupportFragmentManager();
        SecondFragment secondFragment;

        //получаем ссылку на второй фрагмент
        //SecondFragment secondFragment = (SecondFragment) fm.findFragmentById(R.id.fragmentSecond);
        //если второй фрагмент не создан или не видим создаем и запускаем активность
        if (mIsDynamic) {
           /*Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("SMS", bodySms);
            startActivity(intent);*/
            secondFragment = new SecondFragment();
            FragmentTransaction ft = fm.beginTransaction();
            //Подготовим аргументы для отсылки в second fragment
            Bundle args = new Bundle();
            args.putString(SecondFragment.SMA_BODY, bodySms);
            secondFragment.setArguments(args);

            ft.replace(R.id.container, secondFragment, "second_fragment");
            ft.addToBackStack(null);
            ft.commit();
        }else{
            secondFragment = (SecondFragment) fm.findFragmentById(R.id.fragmentSecond);
            secondFragment.setTextSmsBody(bodySms);
        }

    }
}
