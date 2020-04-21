package com.example.intentprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    private static final String KEY_PARAM = "PARAM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //Bundle args = getIntent().getExtras();
        //if (args == null) {
        //    return;
        //}
        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri == null) {
            return;
        }

        //String text = args.getString(KEY_PARAM);
        String text = uri.getLastPathSegment();
        TextView textView = findViewById(R.id.textView);
        textView.setText(text);
    }
}
