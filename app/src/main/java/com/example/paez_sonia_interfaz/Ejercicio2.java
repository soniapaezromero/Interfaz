package com.example.paez_sonia_interfaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;
import android.view.View;

import com.example.paez_sonia_interfaz.databinding.ActivityEjercicio1Binding;

import java.util.ArrayList;
import java.util.List;

import com.example.paez_sonia_interfaz.databinding.ActivityEjercicio2Binding;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase principal del ejercicio2
 */

public class Ejercicio2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        RecyclerView rvLibros= (RecyclerView)findViewById(R.id.rvLibros);
        List<Libro> libros = lista();
        LibrosAdapter adaptador= new LibrosAdapter(this, libros);
        rvLibros.setAdapter(adaptador);
        rvLibros.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Libro>lista(){
        List<Libro> lista = new ArrayList<>();
        lista.add(new Libro("Aquitania", "García Sáenz de Urturi, Eva", "Planeta", "05-11-2020", "El duque de Aquitania —la región más codiciada de Francia— aparece muerto en Compostela. El cuerpo queda de color azul y con la marca del «águila de sangre»", R.drawable.libro1));
        lista.add(new Libro("La Ciudad de Vapor","Ruiz Zafón, Carlos","Planeta","17-11-2020","Un muchacho decide hacerse escritor al descubrir que sus invenciones le regalan un rato más de interés por parte de la niña rica que le ha robado el corazón. Un arquitecto huye de Constantinopla con los planos de una biblioteca inexpugnable.",R.drawable.libro2));
        lista.add(new Libro("Rey blanco","Gómez-Jurado, Juan","Ediciones B","05-11-2020","ESPERO QUE NO TE HA YAS OLVIDADO DE MÍ.¿JUGAMOS? Cuando Antonia Scott recibe este mensaje, sabe muy bien quién se lo envía. También sabe que ese juego es casi imposible de ganar»",R.drawable.libro3));
        lista.add (new Libro("Línea de fuego","Pérez-Reverte, Arturo","ALFAGUARA","06-10-2020"," Ésta no es una novela sobre la Guerra Civil, sino sobre los hombres y mujeres que combatieron en ella. La historia de los padres y abuelos de numerosos españoles de hoy",R.drawable.libro4));
        lista.add(new Libro("Las tinieblas y el alba (La precuela de Los pilares de la Tierra)","Follett, Ken","PLAZA & JANES","15-09-2020","Año 997, finales de la Edad Oscura. Inglaterra se enfrenta a los ataques de los galeses por el oeste y de los vikingos por el este. La vida es difícil y aquellos que ostentan algo de poder lo ejercen con puño de hierro y, a menudo, en conflicto con el propio rey. En estos tiempos turbulentos, tres vidas se entrecruzan: el joven constructor de barcos Edgar,Ragna, la rebelde hija de un noble normando,y  Aldred, un monje idealista",R.drawable.libro5));
        return lista;

    }
    }
