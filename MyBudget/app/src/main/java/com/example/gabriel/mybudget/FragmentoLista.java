package com.example.gabriel.mybudget;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

//El listFragment siempre usa un ListView en la interfaz grafica
public class FragmentoLista extends ListFragment {

    //Clase donde estan los metodos de la bd
    InterfazBD iBD;
    //Lector que tiene los datos despues de una busqueda
    Cursor res;
    //Conexion entre datos y el fragmento - usa el cursor
    SimpleCursorAdapter sca;
    //El fragmento...
    ListView lv;

    /* (non-Javadoc)
     * @see android.app.ListFragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @SuppressWarnings("deprecation")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v=super.onCreateView(inflater, container, savedInstanceState);

        //Nombres de las columnas en la bd
        String []arregloColumnas={"_id","datos","info"};
        //Textviews del renglon donde se van a guardar los datos
        int []to={R.id.texto1,R.id.texto2,R.id.texto3};
        //crear conexion con la bd
        iBD=new InterfazBD(this.getActivity());
        //crear cursor de la bd con los resultados de la tabla
        res=iBD.traerTodosDatos();
        //Pasarle el cursor a la actividad
        //startManagingCursor(res);
        //Crear el adaptador para mostrar los datos
        sca=new SimpleCursorAdapter(
                this.getActivity(), //Actividad papa de todos
                R.layout.formato_renglon, //Formato que se repite en la lista
                res, //Cursor que tiene los datos de la consulta
                arregloColumnas, //Nombres de las columnas de la bd
                to, //Elementos destino en el layout del renglon
                0); //Este cero no hay que pelarlo
        //Pegar el adaptador a la lista
        this.setListAdapter(sca);


        return v;
    }

    /* (non-Javadoc)
     * @see android.app.ListFragment#onListItemClick(android.widget.ListView, android.view.View, int, long)
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        //super.onListItemClick(l, v, position, id);
        if(iBD==null){
            iBD=new InterfazBD(this.getActivity());
        }

        String s=iBD.traerDato(id);
        Toast t=Toast.makeText(getActivity(),s, Toast.LENGTH_LONG);
        t.show();
    }
}