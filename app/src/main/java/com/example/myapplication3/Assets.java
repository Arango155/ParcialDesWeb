package com.example.myapplication3;

public class Assets {
    public static int DB_VERSION = 1;
    public static String DB_NAME = "bd_usuarios";

    // Tabla Usuarios
    public static String TABLA_USUARIOS = "USUARIOS";
    public static String CAMPO_ID = "ID";
    public static String CAMPO_NOMBRE = "NOMBRE";
    public static String CAMPO_TELEFONO = "TELEFONO";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIOS +
            " (" + CAMPO_ID + " TEXT primary key, "
            + CAMPO_NOMBRE + " TEXT,  "
            + CAMPO_TELEFONO + " TEXT)";
}
//AQUI SE CREA LA BASE DE DATOS CON LA CUAL VOY A TRABAJAR.