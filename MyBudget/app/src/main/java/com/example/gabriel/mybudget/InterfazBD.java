package com.example.gabriel.mybudget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class InterfazBD {
    ConexionBD con;
    SQLiteDatabase db;

    public InterfazBD(Context context){
        con=new ConexionBD(context);
    }

    public void open() throws SQLiteException {
        db=con.getWritableDatabase();
    }

    public void close() throws SQLiteException {
        con.close();
    }

    public long insertarDatos(String tipo, String gasto){
        ContentValues valores;
        open();
        valores=new ContentValues();
        valores.put("tipo",tipo);
        valores.put("gasto","$"+gasto);
        long clave=db.insert("tablaprueba", null, valores);
        close();
        return clave;
    }

    public void insertarDatosPrueba(){
        ContentValues valores;
        open();

        valores=new ContentValues();
        valores.put("tipo","comida");
        valores.put("gasto", "$100");
        db.insert("tablaprueba", null, valores);
        valores=new ContentValues();
        valores.put("tipo","entretenimiento");
        valores.put("gasto", "$220");
        db.insert("tablaprueba", null, valores);
    }

    public String traerDato(long clave){
        open();
        String claveString=Long.toString(clave);
        String query="select * from tablaprueba where _id="+claveString+";";
        Cursor c=db.rawQuery(query,null);
        c.moveToNext();
        String res=c.getString(1)+","+c.getString(2);
        c.close();
        close();
        return res;
    }

    public Cursor traerTodosDatos(){
        Cursor res=null;
        open();
        String query="select * from tablaprueba;";
        res=db.rawQuery(query,null);
        if(res.getCount()==0){
            insertarDatosPrueba();
            res=db.rawQuery(query,null);
        }
        //cerrar bd?
        return res;
    }

    public void borrarDatos(long id){
        open();
        String query="delete from tablaprueba where _id="+id+";";
        db.execSQL(query);
    }
}

