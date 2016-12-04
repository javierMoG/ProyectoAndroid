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

    public long insertarIngreso(String cantidad){
        ContentValues valores;
        open();
        valores=new ContentValues();
        valores.put("cantidad", "$"+cantidad);
        long clave=db.insert("ingreso", null, valores);
        close();
        return clave;
    }

    public long insertarDatos(String tipo, String gasto){
        ContentValues valores;
        open();
        valores=new ContentValues();
        valores.put("tipo",tipo);
        valores.put("gasto", "$"+gasto);
        long clave=db.insert("tablaprueba", null, valores);
        close();
        return clave;
    }

    public void inicializarP(){
        ContentValues valores;
        open();
        valores= new ContentValues();
        valores.put("cantidad", "$0");
        db.insert("ingreso", null, valores);
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
        return res;
    }

    public double totalGastos(){
        Cursor cur=null;
        String[] datos;
        double total=0;
        int cont=0;
        open();
        String query="select gasto from tablaprueba;";
        cur=db.rawQuery(query,null);
        datos= new String[cur.getCount()];
        while (cont<datos.length){
            cur.moveToNext();
            datos[cont]= cur.getString(0).substring(1);
            cont++;
        }
        total= cuenta(datos);
        cur.close();
        close();
        return total;
    }

    public double cuenta(String[] arr){
        int i=0;
        double tot=0;
        while(i<arr.length){
            double aux= Double.parseDouble(arr[i]);
            tot+=aux;
            i++;
        }
        return tot;
    }

    public String consultaPresupuesto(){
        open();
        String query="select cantidad from ingreso;";
        Cursor c=db.rawQuery(query,null);
        if(c.getCount()==0){
            inicializarP();
            c=db.rawQuery(query,null);
        }
        c.moveToNext();
        String res=c.getString(0);
        c.close();
        close();
        return res;
    }

    public void borrarIngreso(){
        open();
        String query="delete from ingreso;";
        db.execSQL(query);
        close();
    }

    public void borrarDatos(long id){
        open();
        String query="delete from tablaprueba where _id="+id+";";
        db.execSQL(query);
        close();
    }
}

