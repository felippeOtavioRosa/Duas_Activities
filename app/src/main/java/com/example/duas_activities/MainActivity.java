package com.example.duas_activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "com.example.duas_activities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText mMessageEditText;
    private TextView mRepalyHeadTextView; // cabeçalho
    private TextView mReplayTextView; // text view com a mensagem
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_Main);
        mRepalyHeadTextView = findViewById(R.id.text_header_replay);
        mReplayTextView=findViewById(R.id.text_message_replay);
    }

    public void launchSecondActivity(View view) {
        Log.d(TAG, "launchSecondActivity: Botão pressionado");
        //cria o objeto que permite comunicar uma activity com outra
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString(); // obtem o texto digitado no editText
        intent.putExtra(EXTRA_MESSAGE, message); // insere mensagem no "balaio" (extra)
        startActivityForResult(intent, TEXT_REQUEST);
    }

    // quando a resposta chegar vou receber o código da requisição, da resposta e o intent
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                String repaly = data.getStringExtra(SecondActivity.EXTRA_REPLAY);
                mRepalyHeadTextView.setVisibility(View.VISIBLE);
                mReplayTextView.setText(repaly);
                mReplayTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}