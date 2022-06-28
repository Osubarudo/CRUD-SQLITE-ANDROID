package com.example.crud2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//clase para poder crear la base de datos
public class BaseHelper extends SQLiteOpenHelper {

    String tabla = "CREATE TABLE personas (id INTEGER PRIMARY KEY, nombre TEXT, apellido TEXT)";
    public BaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE personas");
        sqLiteDatabase.execSQL(tabla);
    }
}
