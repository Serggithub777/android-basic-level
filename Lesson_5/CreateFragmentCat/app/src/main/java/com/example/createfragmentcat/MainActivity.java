package com.example.createfragmentcat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.OnSelectedButtonListener {
    boolean mIsDynamic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        //получаем ссылку на второй фрагмент по ID
        Fragment2 fragment2 = (Fragment2) fragmentManager.findFragmentById(R.id.fragment2);
        mIsDynamic = fragment2 == null || !fragment2.isInLayout();
        Toast.makeText(getApplicationContext(), mIsDynamic+" ", Toast.LENGTH_SHORT).show();

        if (mIsDynamic) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            //создаем и добавляем новый фрагмент
            Fragment1 fragment1 = new Fragment1();
            ft.add(R.id.container, fragment1,"fragment1");
            //подтверждаем транзакцию
            ft.commit();

        }
    }

    @Override
    public void onButtonSelected(int buttonIndex) {
        //подключаем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //получаем ссылку на второй фрагмент по ID
        Fragment2 fragment2 ;
        /*//выводим нужную информацию
        if (fragment2 != null) {
            fragment2.setDescription(buttonIndex);
        }*/
        //если фрагмента не существует или он невидим
        if (mIsDynamic) {
            //запускаем вторую активность
            /*Intent intent = new Intent(getApplicationContext(), Activity_second.class);
            intent.putExtra("buttonIndex", buttonIndex);
            startActivity(intent);*/

            FragmentTransaction ft = fragmentManager.beginTransaction();
            fragment2 = new Fragment2();
            //подготавливаем аргументы
            Bundle args = new Bundle();
            args.putInt(Fragment2.BUTTON_INDEX,buttonIndex);
            fragment2.setArguments(args);

            ft.replace(R.id.container, fragment2, "fragment2");
            ft.addToBackStack(null);
            ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            ft.commit();
        } else {
            //выводим информацию во втором фрагменте
            fragment2 = (Fragment2) fragmentManager.findFragmentById(R.id.fragment2);
            fragment2.setDescription(buttonIndex);
        }
    }
}
