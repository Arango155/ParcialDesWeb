package com.example.myapplication3;

public class Producto {

    private String id;
    private String nombre;
    private String telefono;

    public Producto(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Producto(){

    }

}

//AQUI CREO LO QUE SON LOS CONSTRUCTORES Y GETTERS AND SETTERS.
