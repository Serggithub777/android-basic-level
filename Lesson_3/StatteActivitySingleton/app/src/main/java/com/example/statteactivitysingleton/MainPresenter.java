package com.example.statteactivitysingleton;

import java.util.Map;

public final class MainPresenter {
    //внутреннее поле будет хранить единственный экземпляр класса

    private static MainPresenter instance = null;

    //поле для синхронизации
    public static final Object syncObj = new Object();

    //это счетчик
   private int counter;

    //Конструктор не может быть вызван извне
    private MainPresenter() {
        counter = 0;
    }

    //метод инкрементирующий счетчик
    public void incrementCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    //метод получения единственного экземпляра класса
    //если объекта нет он создает его
    public static MainPresenter getInstance() {
        synchronized (syncObj) {
            if (instance == null) {
                instance = new MainPresenter();
            }
        }
        return instance;
    }
}
