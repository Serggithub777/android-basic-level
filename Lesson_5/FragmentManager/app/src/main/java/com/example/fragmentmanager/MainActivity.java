package com.example.fragmentmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private FragmentOne fragmentOne;
   private FragmentTwo fragmentTwo;
   private FragmentThree fragmentThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentThree = new FragmentThree();

        //обработка кнопок
        Button add1 = findViewById(R.id.buttonAddOne);
        add1.setOnClickListener(new ListenerOnAdd(fragmentOne));

        Button add2 = findViewById(R.id.buttonAddTwo);
        add2.setOnClickListener(new ListenerOnAdd(fragmentTwo));

        Button add3 = findViewById(R.id.buttonAddThree);
        add3.setOnClickListener(new ListenerOnAdd(fragmentThree));

        Button remove1 = findViewById(R.id.buttonRemoveOne);
        remove1.setOnClickListener(new ListenerOnRemove(fragmentOne));

        Button remove2 = findViewById(R.id.buttonRemoveTwo);
        remove2.setOnClickListener(new ListenerOnRemove(fragmentTwo));

        Button remove3 = findViewById(R.id.buttonRemoveThree);
        remove3.setOnClickListener(new ListenerOnRemove(fragmentThree));

        Button replace1 = findViewById(R.id.buttonReplaceOne);
        replace1.setOnClickListener(new ListenerOnReplace(fragmentOne));

        Button replace2 = findViewById(R.id.buttonReplaceTwo);
        replace2.setOnClickListener(new ListenerOnReplace(fragmentTwo));

        Button replace3 = findViewById(R.id.buttonReplaceThree);
        replace3.setOnClickListener(new ListenerOnReplace(fragmentThree));
    }
    private class ListenerOnAdd implements View.OnClickListener{

        private final Fragment fragment;

        ListenerOnAdd(Fragment fragment){
            this.fragment = fragment;
        }

        @Override
        public void onClick(View v) {
            addFragment();
        }

        // Добавить фрагмент
        private void addFragment(){
            // Открыть транзакцию
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            // Добавить фрагмент
            fragmentTransaction.add(R.id.fragmentContainer, fragment);
            // Закрыть транзакцию
            fragmentTransaction.commit();
        }
    }
    class  ListenerOnReplace implements View.OnClickListener{

        Fragment fragment​;

        ListenerOnReplace (Fragment fragment){
           this.fragment​=fragment;
        }


        @Override
        public void onClick(View v) {
            replaceFragment();
        }

       private void replaceFragment(){
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer,fragment​);
            fragmentTransaction.commit();
        }
    }

    private class ListenerOnRemove implements View.OnClickListener{

        private final Fragment fragment;

        ListenerOnRemove(Fragment fragment){
            this.fragment = fragment;
        }

        @Override
        public void onClick(View v) {
            removeFragment();
        }

        // Удалить фрагмент
        private void removeFragment(){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
    }


}
