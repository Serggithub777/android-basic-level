package com.example.login;

import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.widget.SwitchCompat;

public class SettingActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        SwitchCompat switchDarkTheme = findViewById(R. id. switch1) ;
        switchDarkTheme. setChecked(isDarkTheme() ) ;
        switchDarkTheme. setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean
                    isChecked) {
                setDarkTheme(isChecked) ;
                recreate() ;
            }
        } ) ;
    }
}
