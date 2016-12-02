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

    Button b1;
    Button b2;
    Button b3;
    Fragment f2;
    Fragment f3;
    Fragment f4;
    FragmentManager fm;
    FragmentTransaction ft;


    public PantallaPrincipal() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);
        b1= (Button) view.findViewById(R.id.BtnEstablecerIM);
        b2= (Button) view.findViewById(R.id.BtnIngresarGasto);
        b3= (Button) view.findViewById(R.id.BtnConsultaWeb);
        f2= new InsertarIngreso();
        f3= new InsertarGasto();
        f4= new Fragmento4();
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



        return view;
    }

}
