package com.example.paez_sonia_interfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.paez_sonia_interfaz.databinding.ActivityEjercicio1Binding;

import static com.example.paez_sonia_interfaz.Conversion.convertirDolares;
import static com.example.paez_sonia_interfaz.Conversion.convertirEuros;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase principal del ejercicio Conversion
 */


public class Ejercicio1 extends AppCompatActivity implements View.OnClickListener {
    private ActivityEjercicio1Binding binding;
    Conversion convert = new Conversion();
    double cambio = 1.20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        binding = ActivityEjercicio1Binding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        binding.botonconv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.botonconv) {

            try {
                if (binding.eurosDolares.isChecked()) {
                    binding.dolares.setText(convertirDolares(binding.euros.getText().toString(), cambio));
                } else {
                    binding.euros.setText(convertirEuros(binding.dolares.getText().toString(), cambio));
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Error en la conversión: " + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
    }
}
