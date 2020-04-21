package com.example.startintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_PARAM = "PARAM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text = findViewById(R.id.editTextName);
        Button runEcho = findViewById(R.id.buttonRunEcho);
        String str = text.getText().toString();
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        runEcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("example://intent");
                Intent runEchoIntent = new Intent(Intent.ACTION_VIEW, uri);
                runEchoIntent.putExtra(KEY_PARAM, text.getText().toString());
                startActivity(runEchoIntent);
            }
        });
    }
}
