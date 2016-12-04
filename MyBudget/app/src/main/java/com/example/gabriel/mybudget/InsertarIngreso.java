package com.example.gabriel.mybudget;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertarIngreso extends Fragment {
    Button regresar, guardar;
    Fragment f1;
    FragmentManager fm;
    FragmentTransaction ft;
    InterfazBD iBD;
    EditText ingreso;
    TextView presupuesto;


    public InsertarIngreso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.insertar_ingreso, container, false);

        regresar = (Button)view.findViewById(R.id.Regresar);
        guardar= (Button) view.findViewById(R.id.Guardar);
        ingreso= (EditText) view.findViewById(R.id.ingreso);
        presupuesto= (TextView) view.findViewById(R.id.presupuestoActual);
        iBD =  new InterfazBD(view.getContext());
        presupuesto.setText(iBD.consultaPresupuesto().toString());

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cad= ingreso.getText().toString();
                long clave;

                iBD= new InterfazBD(v.getContext());
                iBD.borrarIngreso();
                clave= iBD.insertarIngreso(cad);

                if(clave!=-1) {
                    Toast.makeText(v.getContext(), "Guardado", Toast.LENGTH_SHORT).show();
                    presupuesto.setText(iBD.consultaPresupuesto().toString());
                }else{
                    Toast.makeText(v.getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f1 = new PantallaPrincipal();
                fm= getFragmentManager();
                ft= fm.beginTransaction();
                ft.replace(R.id.activity_main, f1);
                ft.commit();
            }
        });


        return view;
    }

}
