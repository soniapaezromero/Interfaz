package com.example.paez_sonia_interfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase principal que abre los distintos ejercicios
 */

public class MainActivity extends AppCompatActivity {
    Button ejercicio1;
    Button ejercicio2;
    Button ejercicio3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ejercicio1=(Button)findViewById(R.id.ejercicio1);
        ejercicio2= (Button)findViewById(R.id.ejercicio2);
        ejercicio3= (Button)findViewById(R.id.ejercicio3);
        ejercicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(v.getContext(),Ejercicio1.class);
                startActivity(intento);
            }
        });
        ejercicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(v.getContext(),Ejercicio2.class);
                startActivity(intento);
            }
        });
        ejercicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(v.getContext(),Ejercicio3.class);
                startActivity(intento);
            }
        });
    }
}