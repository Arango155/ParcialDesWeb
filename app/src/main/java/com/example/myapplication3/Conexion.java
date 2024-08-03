package com.example.myapplication3;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {


    public Conexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Assets.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Assets.TABLA_USUARIOS);
        onCreate(db);
    }

    public int actualizarUsuario(String id, String nombre, String telefono) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Assets.CAMPO_NOMBRE, nombre);
        values.put(Assets.CAMPO_TELEFONO, telefono);

        // Actualiza el registro correspondiente al id dado
        return db.update(Assets.TABLA_USUARIOS, values, Assets.CAMPO_ID + " = ?", new String[]{id});
    }

    public int eliminarUsuario(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Elimina el registro correspondiente al id dado
        return db.delete(Assets.TABLA_USUARIOS, Assets.CAMPO_ID + " = ?", new String[]{id});
    }
}

//AQUI SOLAMENTE TENGO QUE VER QUE LOS DATOS COINCIDAN CON LA CLASE ASSETS. QUE TENGAN LOS MISMOS NOMBRE Y CAMPOS.



