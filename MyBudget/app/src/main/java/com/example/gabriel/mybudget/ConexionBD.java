package com.example.gabriel.mybudget;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionBD extends SQLiteOpenHelper {

    String cadenaCreate="create table if not exists tablaprueba (_id integer primary key autoincrement,tipo text not null, gasto text not null);";

    public ConexionBD(Context context) {
        super(context,"prueba.db", null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(cadenaCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        //Borra los datos del usuario!!! no usar la siguientes lineas en despliegue de
        //la app
        String cadenaUpdate="drop table if exists tablaprueba;";
        db.execSQL(cadenaUpdate);
        onCreate(db);
    }

}