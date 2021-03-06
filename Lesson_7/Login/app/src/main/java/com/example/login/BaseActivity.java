package com.example.login;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    // Имя настроек
    private static final String NameSharedPreference = "LOGIN";
    // Имя параметра в настройках
    private static final String IsDarkTheme = "IS_DARK_THEME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isDarkTheme() ) {
            setTheme(R. style. AppDarkTheme) ;
        } else {
            setTheme(R. style. AppTheme) ;
        }
    }

    // Чтение настроек, параметр тема
    protected boolean isDarkTheme() {
    // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref =
                getSharedPreferences(NameSharedPreference, MODE_PRIVATE) ;
    //Прочитать тему, если настройка не найдена - взять по умолчанию true
        return sharedPref. getBoolean(IsDarkTheme, true) ;
    }

    // Сохранение настроек
    protected void setDarkTheme(boolean isDarkTheme) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference,
                MODE_PRIVATE) ;
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences. Editor editor = sharedPref. edit() ;
        editor. putBoolean(IsDarkTheme, isDarkTheme) ;
        editor. apply() ;
    }
}
