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
public class PantallaPrincipal extends Fragment {

    Button b1, b2, b3, b4, b5;
    Fragment f2, f3, f4, f5, f6;
    FragmentManager fm;
    FragmentTransaction ft;


    public PantallaPrincipal() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.pantalla_principal, container, false);
        b1= (Button) view.findViewById(R.id.BtnEstablecerIM);
        b2= (Button) view.findViewById(R.id.BtnIngresarGasto);
        b3= (Button) view.findViewById(R.id.BtnConsultaWeb);
        b4= (Button) view.findViewById(R.id.Consulta);
        b5= (Button) view.findViewById(R.id.BtnSaldo);
        f2= new InsertarIngreso();
        f3= new InsertarGasto();
        f4= new PaginaWeb();
        f5= new ConsultaGastos();
        f6= new Saldo();
        fm= this.getFragmentManager();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fm.beginTransaction();
                ft.replace(R.id.activity_main, f2);
                ft.commit();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fm.beginTransaction();
                ft.replace(R.id.activity_main, f3);
                ft.commit();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fm.beginTransaction();
                ft.replace(R.id.activity_main, f4);
                ft.commit();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft= fm.beginTransaction();
                ft.replace(R.id.activity_main, f5);
                ft.commit();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft= fm.beginTransaction();
                ft.replace(R.id.activity_main, f6);
                ft.commit();
            }
        });

        return view;
    }

}
