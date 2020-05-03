package com.example.socialnetwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = getResources().getStringArray(R.array.items);

        initRecyclerView (data);
    }

    private void initRecyclerView(String[] data) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
// Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Будем работать со встроенным менеджером
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        //установим менеджер в recycler view
        recyclerView.setLayoutManager(linearLayoutManager);

        //создадим адаптер
        SocnetAdapter socnetAdapter = new SocnetAdapter(data);
        //установим адаптер
        recyclerView.setAdapter(socnetAdapter);

    }
}
