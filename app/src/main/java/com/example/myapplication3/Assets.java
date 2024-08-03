package com.example.myapplication3;

public class Assets {
    public static int DB_VERSION = 1;
    public static String DB_NAME = "examen_desweb";

    // Tabla Cursos
    public static String TABLA_CURSOS = "CURSOS";
    public static String CAMPO_ID = "ID";
    public static String CAMPO_NOMBRE = "NOMBRE";
    public static String CAMPO_TELEFONO = "TELEFONO";

    public static final String CREAR_TABLA_CURSO = "CREATE TABLE " + TABLA_CURSOS +
            " (" + CAMPO_ID + " TEXT primary key, "
            + CAMPO_NOMBRE + " TEXT,  "
            + CAMPO_TELEFONO + " TEXT)";
}
