package com.example.gabriel.mybudget;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultaGastos extends Fragment {

    android.app.Fragment lista, f1, f2;
    FragmentManager fm;
    FragmentTransaction ft;
    Button regresar, borrar;
    InterfazBD iBD;

    public ConsultaGastos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_consulta_gastos, container, false);

        regresar= (Button) v.findViewById(R.id.Regresar);
        borrar= (Button) v.findViewById(R.id.EliminarGasto);
        iBD= new InterfazBD(v.getContext());
        lista= new Lista();
        fm= getFragmentManager();
        ft= fm.beginTransaction();
        ft.add(R.id.Lista, lista);
        ft.commit();

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f1= new PantallaPrincipal();
                ft= fm.beginTransaction();
                ft.replace(R.id.activity_main, f1);
                ft.commit();
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f2= new EliminarGasto();
                fm= getFragmentManager();
                ft= fm.beginTransaction();
                ft.replace(R.id.activity_main, f2);
                ft.commit();
            }
        });

        return v;
    }

}
