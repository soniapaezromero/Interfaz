package com.example.paez_sonia_interfaz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase Adaptader del Ejercicio3 utilizando el item_view wl ejercicio2
 */
public class LibrosAdapterEj3 extends RecyclerView.Adapter<LibrosAdapterEj3.ViewHolder> {

    public List<Libro> lista;
    private LibrosAdapterEj3.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Libro libro);
    }

    public LibrosAdapterEj3(List<Libro> lista, LibrosAdapterEj3.OnItemClickListener listener) {
        this.lista = lista;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tituloLibro.setText(lista.get(position).getTitulo());
        holder.portadaLibro.setImageResource((lista.get(position).getFotoPortada()));
        holder.bind(lista.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tituloLibro;
        ImageView portadaLibro;
        LinearLayout linearLayout;

        public ViewHolder(final View view) {
            super(view);
            this.tituloLibro = view.findViewById(R.id.titulo);
            this.portadaLibro = view.findViewById(R.id.fotoPortada);
            linearLayout = itemView.findViewById(R.id.layout);
        }

        public void bind(final Libro libro, final OnItemClickListener listener) {
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(libro);
                }
            });
        }
    }
}