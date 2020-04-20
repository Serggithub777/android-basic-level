package com.example.sendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText enterSMStext = findViewById(R.id.editTextEnterSMS);
        Button buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsBody = enterSMStext.getText().toString();
                Intent smsSend = new Intent(Intent.ACTION_SENDTO); //создаем интент с действием ACTION_SENDTO
                smsSend.setData(Uri.parse("smsto:")); //устанавливаем в интент Uri данные в виде прсинга строки "smsto:"
                smsSend.putExtra("sms_body", smsBody); //прикрепляем тело смс
                PackageManager packageManager;
                ComponentName component;
                ActivityInfo activityInfo = smsSend.resolveActivityInfo(getPackageManager(), smsSend.getFlags());
                //запрашиваем информацию по активити может ли система обработать данную активити
                if (activityInfo != null) {
                    startActivity(smsSend);
                }
            }
        });
    }
}
