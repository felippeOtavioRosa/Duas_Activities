package com.example.duas_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "com.example.duas_activities.extra.MESSAGE";

    private EditText mMessageEditText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_Main);
    }

    public void launchSecondActivity(View view) {
        Log.d(TAG, "launchSecondActivity: Botão pressionado");
        //cria o objeto que permite comunicar uma activity com outra
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString(); // obtem o texto digitado no editText
        intent.putExtra(EXTRA_MESSAGE, message); // insere mensagem no "balaio" (extra)
        startActivity(intent);
    }
}