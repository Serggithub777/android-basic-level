package com.example.weathermoscow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.weathermoscow.data.WeatherRequest;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "WEATHER";
    public static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?lat=55.75&lon=37.62&appid=";
   // public static final String WEATHER_API_KEY = "1186203397d0695eb17fe6d368432737";

    private EditText city;
    private EditText temperature;
    private EditText pressure;
    private EditText humidity;
    private EditText windSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        city = findViewById(R.id.textCity);
        temperature = findViewById(R.id.textTemprature);
        pressure = findViewById(R.id.textPressure);
        humidity = findViewById(R.id.textHumidity);
        windSpeed = findViewById(R.id.textWindspeed);
        Button refresh = findViewById(R.id.buttonRefresh);
        refresh.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                final URL uri = new URL(WEATHER_URL + BuildConfig.WEATHER_API_KEY);
                final Handler handler = new Handler(); //запоминаем основной поток
                new Thread(new Runnable() {//запускаем поток в котром совершаем соединене и запрос с результатом
                    @Override
                    public void run() {
                        HttpsURLConnection urlConnection = null;
                        try {
                            urlConnection = (HttpsURLConnection) uri.openConnection(); //открываем соединение по ссылке
                            urlConnection.setRequestMethod("GET"); //устанавливаем метод результата - получить
                            urlConnection.setReadTimeout(10000);// таймаут для считывания
                            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                            //создаем поток и читаемданные из соединения в него
                            String result = getLines(reader);
                            //преобразование данных запроса в DATA
                            Gson gson = new Gson();
                            final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);
                            //возвращаемся к основному потоку
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    displayWeather(weatherRequest);
                                }
                            });

                        } catch (Exception e) {
                            Log.e(TAG, "Fail Connection", e);
                            e.printStackTrace();
                        } finally {
                            if (urlConnection != null) {
                                urlConnection.disconnect();
                            }
                        }
                    }
                }).start();


            } catch (MalformedURLException e) {
                Log.e(TAG, "Fail URI", e);
                e.printStackTrace();
            }
        }
        private String getLines(BufferedReader reader) {
          return   reader.lines().collect(Collectors.joining("\n"));
        }
        private void displayWeather(WeatherRequest weatherRequest) {
            city.setText(weatherRequest.getName());
            temperature.setText(String.format("%f2",weatherRequest.getMain().getTemp()));
            pressure.setText(String.format("%d", weatherRequest.getMain().getPressure()));
            humidity.setText(String.format("%d", weatherRequest.getMain().getHumidity()));
            windSpeed.setText(String.format("%d", weatherRequest.getWind().getSpeed()));
        }
    };
}
