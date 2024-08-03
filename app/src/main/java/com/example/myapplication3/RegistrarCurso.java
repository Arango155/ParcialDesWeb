package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarCurso extends AppCompatActivity {
    EditText id, nombre, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarview);
        this.id = findViewById(R.id.idNombre);
        this.nombre = findViewById(R.id.nombreUsuario);
        this.telefono = findViewById(R.id.categoria);
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnRegistrar:
                this.registrarCurso();
                break;

            case R.id.btnCancelar:
                intent = new Intent(getApplicationContext(), MainActivity3.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    private void registrarCurso() {
        try {
            Conexion conexion = new Conexion(this, Assets.DB_NAME, null, Assets.DB_VERSION);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Assets.CAMPO_ID, id.getText().toString());
            values.put(Assets.CAMPO_NOMBRE, nombre.getText().toString());
            values.put(Assets.CAMPO_TELEFONO, telefono.getText().toString());

            Long result = db.insert(Assets.TABLA_CURSOS, null, values);
            Toast.makeText(getApplicationContext(), "Curso Registrado", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
