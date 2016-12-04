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
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertarGasto extends Fragment {

    Button regresar;
    RadioButton comida, ropa, ent, gas, otro;
    Fragment f1;
    FragmentManager fm;
    FragmentTransaction ft;
    Button guardar;
    EditText gastoET;
    InterfazBD iBD;

    public InsertarGasto() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_insertar_gasto, container, false);

        guardar = (Button) v.findViewById(R.id.Guardar);
        regresar= (Button) v.findViewById(R.id.Regresar);
        gastoET = (EditText) v.findViewById(R.id.gastoET);
        comida = (RadioButton)v.findViewById(R.id.radioButtonComida);
        ropa = (RadioButton) v.findViewById(R.id.radioButtonRopa);
        ent = (RadioButton) v.findViewById(R.id.radioButtonEntretenimiento);
        gas = (RadioButton) v.findViewById(R.id.radioButtonGasolina);
        otro = (RadioButton) v.findViewById(R.id.radioButtonOtro);

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

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gasto =gastoET.getText().toString();
                String tipo = "";

                if(comida.isChecked()){
                    tipo= "comida";
                }else{
                    if(ropa.isChecked()){
                        tipo= "ropa";
                    }else{
                        if(ent.isChecked()){
                            tipo= "entretenimiento";
                        }else{
                            if(gas.isChecked()){
                                tipo= "gasolina";
                            }else{
                                if(otro.isChecked()){
                                    tipo= "otro";
                                }
                            }
                        }
                    }
                }


                if(!tipo.equals("")){
                    iBD=new InterfazBD(v.getContext());
                    iBD.insertarDatos(tipo, gasto);
                    Toast.makeText(v.getContext(),"Guardado",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

}
