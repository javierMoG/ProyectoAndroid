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

public class Lista extends ListFragment {

    InterfazBD iBD;
    Cursor res;
    SimpleCursorAdapter sca;
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

        String []arregloColumnas={"tipo","gasto"};
        int []to={R.id.columna1,R.id.columna2};
        iBD=new InterfazBD(getActivity());
        res=iBD.traerTodosDatos();
        sca=new SimpleCursorAdapter(this.getActivity(), R.layout.formato_renglon, res, arregloColumnas, to, 0);
        this.setListAdapter(sca);


        return v;
    }

    /* (non-Javadoc)
     * @see android.app.ListFragment#onListItemClick(android.widget.ListView, android.view.View, int, long)
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        if(iBD==null){
            iBD=new InterfazBD(this.getActivity());
        }

        String s=iBD.traerDato(id);
        Toast t=Toast.makeText(getActivity(),s, Toast.LENGTH_LONG);
        t.show();
    }
}