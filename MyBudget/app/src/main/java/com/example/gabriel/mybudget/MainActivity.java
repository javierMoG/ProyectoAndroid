package com.example.gabriel.mybudget;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Fragment f1;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f1 = new PantallaPrincipal();
        fm = this.getFragmentManager();
        ft=fm.beginTransaction();
        ft.add(R.id.activity_main,f1);
        ft.commit();
    }
}
