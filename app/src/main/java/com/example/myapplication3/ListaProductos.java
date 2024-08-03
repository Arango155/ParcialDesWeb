package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaProductos extends AppCompatActivity {
    Conexion conexion;
    ListView listViewUsuarios;
    ArrayList<String> listado;
    ArrayList<Producto> listaUsuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaview);

        conexion = new Conexion(getApplicationContext(), "bd_usuarios", null, 1);
        listViewUsuarios = (ListView) findViewById(R.id.listUsuarios);
        consultarInventario();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        listViewUsuarios.setAdapter(adapter);

        listViewUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String datos = "id: "+ listaUsuarios.get(position).getId()+"\n";
                datos+= "Nombre: "+ listaUsuarios.get(position).getNombre()+"\n";
                datos+= "telefono: "+ listaUsuarios.get(position).getTelefono()+"\n";

                Toast.makeText(ListaProductos.this, datos, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void consultarInventario(){
        try {
            SQLiteDatabase db =conexion.getReadableDatabase();
            Producto producto=null;
            listaUsuarios = new ArrayList<Producto>();
            Cursor cursor= db.rawQuery("SELECT * FROM " + Assets.TABLA_USUARIOS, null);

            while(cursor.moveToNext()){
                producto = new Producto();
                producto.setId(cursor.getString(0));
                producto.setNombre(cursor.getString(1));
                producto.setTelefono(cursor.getString(2));
                listaUsuarios.add(producto);
        }
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listado = new ArrayList<String>();
        for (int i=0; i<listaUsuarios.size(); i++){
            listado.add(listaUsuarios.get(i).getId()+"-"+listaUsuarios.get(i).getNombre()+"-"+listaUsuarios.get(i).getTelefono());
        }
    }
}

//AQUI SOLO TENGO QUE SUSTITUIR LOS NOMBRES DE LOS CAMPOS Y CAMBIAR LAS VARIABLES DE LOS PUBLIC PRINCIPALES.