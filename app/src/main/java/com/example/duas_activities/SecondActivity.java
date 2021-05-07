package com.example.duas_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent(); //pega o intent
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); // recebe a mensagem
        TextView textView = findViewById(R.id.text_message); // referencia textview
        textView.setText(message); //imprime a mensagem na tela
    }
}