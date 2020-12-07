package com.example.paez_sonia_interfaz;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase Libro utilizada en  Ejercicio2 y se implementa clase Parcelable para el Ejercicio3
 *
 * */
public class Libro implements Parcelable {
    public static final String TAG ="Libro" ;
    private String titulo;
    private String autor;
    private String  editorial;
    private String fechaDePublicacion;
    private String sipnosis;
    private int fotoPortada;

    public Libro(String titulo, String autor, String editorial, String fechaDePublicacion, String sipnosis, int fotoPortada) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaDePublicacion = fechaDePublicacion;
        this.sipnosis = sipnosis;
        this.fotoPortada = fotoPortada;
    }

    protected Libro(Parcel in) {
        titulo = in.readString();
        autor = in.readString();
        editorial = in.readString();
        fechaDePublicacion = in.readString();
        sipnosis = in.readString();
        fotoPortada = in.readInt();
    }

    public static final Creator<Libro> CREATOR = new Creator<Libro>() {

        @Override
        public Libro createFromParcel(Parcel in) {
            return new Libro(in);
        }

        @Override
        public Libro[] newArray(int size) {
            return new Libro[size];
        }
    };


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(String fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public int getFotoPortada() {
        return fotoPortada;
    }

    public void setFotoPortada(int fotoPortada) {
        this.fotoPortada = fotoPortada;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(autor);
        dest.writeString(editorial);
        dest.writeString(fechaDePublicacion);
        dest.writeString(sipnosis);
        dest.writeInt(fotoPortada);

    }
}
