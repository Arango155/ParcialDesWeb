package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);
    }

    public void onClick(View view){
        Intent intent = null;
        intent = new Intent(this, MainActivity.class );

        switch (view.getId()){
            case R.id.btnInsert:
                intent = new Intent(this, RegistrarProducto.class );
                break;
            case R.id.btnListar:
                intent = new Intent(this, ListaProductos.class );
                break;

        }
        if (intent!=null){
            startActivity(intent);
        }
    }
}