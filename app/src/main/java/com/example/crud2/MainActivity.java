package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellido;
    Button guardar, mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.etNombre);
        apellido = (EditText) findViewById(R.id.etApellido);
        guardar = (Button) findViewById(R.id.btGuardar);
        mostrar = (Button) findViewById(R.id.btMostrar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(nombre.getText().toString(), apellido.getText().toString());
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Listado.class));
            }
        });
    }


    //Metodo para guardar un registro en la base de datos
    private void guardar (String nom, String ape){
        BaseHelper helper = new BaseHelper(this, "demo", null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            ContentValues c = new ContentValues();//contenedor de valores
            c.put("nombre", nom);
            c.put("apellido", ape);
            db.insert("personas",null,c);
            db.close();
            Toast.makeText(this, "Registro Insertado", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


}