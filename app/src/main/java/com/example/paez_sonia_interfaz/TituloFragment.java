package com.example.paez_sonia_interfaz;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase Fragment principal que tiene el Recyclerview y utiliza el adaptador
 */

public class TituloFragment extends Fragment {
    public static final String TAG ="TituloFragment" ;
    private RecyclerView rvLibro;
    private RecyclerView.Adapter adaptadorLibro;
    private LibrosAdapterEj3.OnItemClickListener listener;
    private  ListTituloFragmentCallback callback;

    interface ListTituloFragmentCallback {
        void  onLibroView(Libro libro);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (ListTituloFragmentCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement ListTituloFragmentCallback");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_titulo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Libro> lista = new ArrayList<>();
        lista.add(new Libro("Aquitania", "García Sáenz de Urturi, Eva", "Planeta", "05-11-2020", "El duque de Aquitania —la región más codiciada de Francia— aparece muerto en Compostela. El cuerpo queda de color azul y con la marca del «águila de sangre»", R.drawable.libro1));
        lista.add(new Libro("La Ciudad de Vapor","Ruiz Zafón, Carlos","Planeta","17-11-2020","Un muchacho decide hacerse escritor al descubrir que sus invenciones le regalan un rato más de interés por parte de la niña rica que le ha robado el corazón. Un arquitecto huye de Constantinopla con los planos de una biblioteca inexpugnable.",R.drawable.libro2));
        lista.add(new Libro("Rey blanco","Gómez-Jurado, Juan","Ediciones B","05-11-2020","ESPERO QUE NO TE HA YAS OLVIDADO DE MÍ.¿JUGAMOS? Cuando Antonia Scott recibe este mensaje, sabe muy bien quién se lo envía. También sabe que ese juego es casi imposible de ganar»",R.drawable.libro3));
        lista.add (new Libro("Línea de fuego","Pérez-Reverte, Arturo","ALFAGUARA","06-10-2020"," Ésta no es una novela sobre la Guerra Civil, sino sobre los hombres y mujeres que combatieron en ella. La historia de los padres y abuelos de numerosos españoles de hoy",R.drawable.libro4));
        lista.add(new Libro("Las tinieblas y el alba (La precuela de Los pilares de la Tierra)","Follett, Ken","PLAZA & JANES","15-09-2020","Año 997, finales de la Edad Oscura. Inglaterra se enfrenta a los ataques de los galeses por el oeste y de los vikingos por el este. La vida es difícil y aquellos que ostentan algo de poder lo ejercen con puño de hierro y, a menudo, en conflicto con el propio rey. En estos tiempos turbulentos, tres vidas se entrecruzan: el joven constructor de barcos Edgar,Ragna, la rebelde hija de un noble normando,y  Aldred, un monje idealista",R.drawable.libro5));
        rvLibro = view.findViewById(R.id.rvLibros);
        rvLibro.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        listener = new LibrosAdapterEj3.OnItemClickListener() {
            @Override
            public void onItemClick(Libro libro) {
                callback.onLibroView(libro);

            }
        };
        adaptadorLibro = new LibrosAdapterEj3(lista, listener);
        rvLibro.setAdapter(adaptadorLibro);
    }
}

