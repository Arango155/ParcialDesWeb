package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);
    }

    public void onClick(View view){
        Intent intent = null;
        intent = new Intent(this, MainActivity3.class );

        if (intent!=null){
            startActivity(intent);
        }
    }
}