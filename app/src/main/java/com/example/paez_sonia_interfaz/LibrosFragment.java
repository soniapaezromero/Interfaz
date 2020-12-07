package com.example.paez_sonia_interfaz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase Fragment que muestra los datos el libro
 */

public class LibrosFragment extends Fragment {
    public static final String TAG = "LibrosFragment";
    TextView autor;
    TextView titulo;
    TextView fechapublicacion;
    TextView sinopsis;
    ImageView portada;

    public static Fragment newInstance(Bundle bundle) {
        LibrosFragment fragment = new LibrosFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_libros, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        autor = view.findViewById(R.id.autorLista);
        titulo = view.findViewById(R.id.tituloLista);
        fechapublicacion= view.findViewById(R.id.fechaPublicacionLista);
        sinopsis = view.findViewById(R.id.sipnosisLista);
        portada = view.findViewById(R.id.fotoPortadaLista);
        if (getArguments() != null) {
            Libro libro = getArguments().getParcelable(Libro.TAG);
            autor.setText(libro.getAutor());
            titulo.setText(libro.getTitulo());
            fechapublicacion.setText(libro.getFechaDePublicacion());
            sinopsis.setText(libro.getSipnosis());
            portada.setImageResource(libro.getFotoPortada());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}