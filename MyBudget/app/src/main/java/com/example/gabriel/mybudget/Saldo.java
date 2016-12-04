package com.example.gabriel.mybudget;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
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
public class Saldo extends Fragment {

    Fragment f1;
    Button regresar;
    TextView saldo, advertencia;
    InterfazBD iBD;
    FragmentManager fm;
    FragmentTransaction ft;

    public Saldo() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_saldo, container, false);

        regresar= (Button) v.findViewById(R.id.Regresar);
        saldo= (TextView) v.findViewById(R.id.saldo);
        advertencia= (TextView) v.findViewById(R.id.advertencia);
        iBD= new InterfazBD(v.getContext());

        double totGastos= iBD.totalGastos();
        String p= iBD.consultaPresupuesto().substring(1);
        double presupuesto= Double.parseDouble(p);
        double s= presupuesto-totGastos;
        saldo.setText("$"+s);

        if(s<(presupuesto*0.10)) {
            advertencia.setText("Te acercas al límite de tu presupuesto");
        }
        if(s<(presupuesto*0.05)){
            advertencia.setTextColor(Color.YELLOW);
            advertencia.setText("Cuidado! Pronto sobre pasarás el presupuesto establecido");
        }
        if (s == 0) {
            advertencia.setTextColor(Color.GRAY);
            advertencia.setText("Has alcanzado el límite de tu presupuesto");
        }
        if(s<0) {
            advertencia.setTextColor(Color.RED);
            advertencia.setText("Ya has sobrepasado tu presupuesto");
        }


        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f1= new PantallaPrincipal();
                fm= getFragmentManager();
                ft= fm.beginTransaction();
                ft.replace(R.id.activity_main, f1);
                ft.commit();
            }
        });

        return v;
    }

}
