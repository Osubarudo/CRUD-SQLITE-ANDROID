package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {
    ListView lvListado;
    ArrayList listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lvListado = (ListView) findViewById(R.id.lvListado);
        cargarListado();
    }
     private void cargarListado(){
        listado = listaPersonas();//el metodo listaPersonas se va guardar en la variable lsitado.
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listado);
         lvListado.setAdapter(adapter);

     }


    private ArrayList<String> listaPersonas(){
        ArrayList<String> datos = new ArrayList<String>();
        BaseHelper helper = new BaseHelper(this, "demo", null,1);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT id, nombre, apellido FROM personas";
        Cursor c = db.rawQuery(sql, null);
        if(c.moveToFirst()){
            do {
                String linea = c.getInt(0) + " " + c.getString(1) + " " + c.getString(2);
                datos.add(linea);
            }while (c.moveToNext());
        }
        db.close();
        return datos;
    }
}