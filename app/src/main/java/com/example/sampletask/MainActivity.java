package com.example.sampletask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showMe(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("name", "LGH");
        startActivity(intent);
    }

    @Override
    // launchMode로 Task를 사용한 경우 메인 액티비티 쪽에 전달되는 인텐트는 onNewIntent메서드로 전달받아야함
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String name = intent.getStringExtra("name");
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        }
    }
}