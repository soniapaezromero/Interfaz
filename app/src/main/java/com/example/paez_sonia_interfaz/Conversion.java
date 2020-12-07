package com.example.paez_sonia_interfaz;

import java.text.DecimalFormat;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase implanta métodos del ejercicio1 conversion
 */

public class Conversion {
    public  static String convertirEuros( String cantidad,double cambio)throws NumberFormatException{
        DecimalFormat formato= new DecimalFormat("#.00");
        double cantEuros;
        cantEuros= Double.parseDouble(cantidad)/cambio;
        String resultado=formato.format(cantEuros);
        return resultado;
    }
    public static String convertirDolares(String cantidad, double cambio)throws NumberFormatException{
        DecimalFormat formato= new DecimalFormat("#.00");
        double cantEuros;
        cantEuros= Double.parseDouble(cantidad)*cambio;
        String resultado=formato.format(cantEuros);
        return resultado;
    }
}
