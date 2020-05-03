package com.example.login;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText loginInputEditText;
    private TextInputEditText passwordInputEditText;
    private TextInputLayout loginLayout;
    private TextInputLayout passwordLayout;

    // Регулярные выражения позволяют проверить на соответствие шаблону
    // Это имя. Первая буква большая латинская, остальные маленькие латинские
    Pattern checkLogin = Pattern. compile("^[A-Z][a-z]{2,}$");
    // Это пароль, минимум 6 символов, обязательны маленькая буква, большая буква, цифра
    Pattern checkPassword = Pattern. compile("^(?=^.{6,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginInputEditText = findViewById(R.id.inputLoginName);
        passwordInputEditText = findViewById(R.id.inputPassword);
        loginLayout = findViewById(R.id.loginNameLayout);
        passwordLayout = findViewById(R.id.passwordInputLayout);

        //устанавливаем фокус слушатель на логин и реализуем метод onFocusChange с проверкой паттерна и отменой ошибки
        loginInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    return;
                    TextView tv = (TextView) v;
                validate(tv, checkLogin, loginLayout, "It's not Name!");
            }
            });
        //устанавливаем фокус слушатель на пароль и реализуем метод onFocusChange с проверкой паттерна и отменой ошибки

        passwordInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) return;
                TextView tv = (TextView) v;
                validate(tv, checkPassword, passwordLayout, "You entered SIMPLE password!");
           }
        });
    }

    private void validate(TextView tv, Pattern pattern, TextInputLayout textInputLayout, String message) {
        String value = tv.getText().toString();
        if (pattern.matcher(value).matches()) {
            //tv.setError(null);
            showError(textInputLayout, null);
        } else {
            showError(textInputLayout, message);
            //tv.setError(message);
        }
    }

    private void showError(TextInputLayout textInputLayout, String message) {
        textInputLayout.setError(message);
    }
}
