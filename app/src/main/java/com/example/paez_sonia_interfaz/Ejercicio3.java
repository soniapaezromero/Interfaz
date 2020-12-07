package com.example.paez_sonia_interfaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase principal del Ejercicio3 que implementa el  Fragment principal
 */

public class Ejercicio3 extends AppCompatActivity implements TituloFragment.ListTituloFragmentCallback{
    private LibrosFragment librosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.Fragment,new TituloFragment(),TituloFragment.TAG);
        ft.addToBackStack(null);
        ft.commit();

    }


    @Override
    public void onLibroView(Libro libro) {
        FragmentManager fm=getSupportFragmentManager();
        librosFragment = (LibrosFragment) fm.findFragmentByTag(LibrosFragment.TAG);

        if (librosFragment == null) {
            Bundle bundle= null;
            if (libro!=null){
                bundle= new Bundle();
                bundle.putParcelable(Libro.TAG,libro);
            }
            librosFragment = (LibrosFragment) LibrosFragment.newInstance(bundle);
        }

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.Fragment, librosFragment, LibrosFragment.TAG);
        ft.addToBackStack(null);
        ft.commit();
    }
}