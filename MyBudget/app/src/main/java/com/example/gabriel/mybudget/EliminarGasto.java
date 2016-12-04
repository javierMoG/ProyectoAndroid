package com.example.gabriel.mybudget;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class EliminarGasto extends Fragment {

    Button regresar;
    Fragment lista, f1;
    FragmentManager fm;
    FragmentTransaction ft;

    public EliminarGasto() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_eliminar_gasto, container, false);

        lista= new FragmentoLista();
        fm= getFragmentManager();
        ft= fm.beginTransaction();
        ft.add(R.id.Lista2, lista);
        ft.commit();

        regresar= (Button) v.findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f1= new ConsultaGastos();
                ft= fm.beginTransaction();
                ft.replace(R.id.activity_main, f1);
                ft.commit();
            }
        });

        return v;
    }

}
