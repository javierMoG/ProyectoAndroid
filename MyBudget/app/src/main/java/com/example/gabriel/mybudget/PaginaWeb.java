package com.example.gabriel.mybudget;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaginaWeb extends Fragment {

    WebView wb;
    Button regresar;
    android.app.Fragment f1;
    FragmentManager fm;
    FragmentTransaction ft;

    public PaginaWeb() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pagina_web, container, false);

        wb=(WebView) view.findViewById(R.id.WebView);
        regresar= (Button) view.findViewById(R.id.button2);

        wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl("http://mx.cotizacion-dolar.com/mexico/economia/bolsa_mexicana_valores/");
        wb.setWebViewClient(new MiWebViewClient());

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

        return view;
    }

    class MiWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
