package com.example.createfragmentcat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.OnSelectedButtonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onButtonSelected(int buttonIndex) {
        //подключаем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //получаем ссылку на второй фрагмент по ID
        Fragment2 fragment2 = (Fragment2) fragmentManager.findFragmentById(R.id.fragment2);
        /*//выводим нужную информацию
        if (fragment2 != null) {
            fragment2.setDescription(buttonIndex);
        }*/
        //если фрагмента не существует или он невидим
        if (fragment2 == null || !fragment2.isVisible()) {
            //запускаем вторую активность
            Intent intent = new Intent(getApplicationContext(), Activity_second.class);
            intent.putExtra("buttonIndex", buttonIndex);
            startActivity(intent);
        } else {
            //выводим информацию во втором фрагменте
            fragment2.setDescription(buttonIndex);
        }
    }
}
