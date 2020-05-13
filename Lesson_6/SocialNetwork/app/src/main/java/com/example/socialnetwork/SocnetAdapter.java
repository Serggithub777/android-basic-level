package com.example.socialnetwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SocnetAdapter extends RecyclerView.Adapter<SocnetAdapter.ViewHolder> {


    private String[] dataSource;
    // Передаем в конструктор источник данных
    // В нашем случае это массив, но может быть и запросом к БД
    public SocnetAdapter(String[] dataSource) {
        this.dataSource = dataSource;
    }
    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @NonNull
    @Override
    public SocnetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item, viewGroup, false);
        // Здесь можно установить всякие параметры
        return new ViewHolder(v);
    }
    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(@NonNull SocnetAdapter.ViewHolder viewHolder, int i) {
        // Получить элемент из источника данных (БД, интернет. . . )
       // Вынести на экран используя ViewHolder
        viewHolder.getTextView().setText(dataSource[i]);
    }

    @Override  // размер данных
    public int getItemCount() {
        return dataSource.length;
    }

    // Этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на
    // один пункт списка
    public class ViewHolder extends RecyclerView.ViewHolder{
      private   TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView;
        }

        public TextView getTextView() {
            return textView;
        }
    }

}
