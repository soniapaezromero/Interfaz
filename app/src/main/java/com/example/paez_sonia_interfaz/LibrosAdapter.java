package com.example.paez_sonia_interfaz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/**
 * @author sonia páez Romero
 * @version 07/12/2020
 * Clase adapter del ejercicio 2 del Recycler
 */

public class LibrosAdapter extends RecyclerView.Adapter<LibrosAdapter.MyViewHolder> {
    public List<Libro> libros;
    private Context context;
    public LibrosAdapter(Context context,List<Libro>libros){
        this.context=context;
        this.libros=libros;
    }
    private OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        public TextView tituloTextView;
        public TextView autorTextView;
        public TextView editorialTextView;
        public TextView fechaPublicacionTextView;
        public TextView sipnosisTextView;
        public ImageView fotoPortadaImageView;
        private View layoutprincipal;
        @SuppressLint("WrongViewCast")
        public MyViewHolder(View itemView){
            super(itemView);
            tituloTextView = (TextView) itemView.findViewById(R.id.titulo);
            autorTextView = (TextView) itemView.findViewById(R.id.autor);
            editorialTextView = (TextView) itemView.findViewById(R.id.editorial);
            fechaPublicacionTextView = (TextView) itemView.findViewById(R.id.fechaPublicacion);
            sipnosisTextView = (TextView) itemView.findViewById(R.id.sipnosis);
            fotoPortadaImageView = (ImageView) itemView.findViewById(R.id.fotoPortada);
            layoutprincipal=itemView.findViewById(R.id.layout);

        }
        @Override
        public void onClick(View view) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(itemView, position);
                }
            }

        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Inflate the custom layout
        View libroView = inflater.inflate(R.layout.item_libro,parent,false);

        // Return a new holder instance
        MyViewHolder viewHolder = new MyViewHolder(libroView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Libro libro= libros.get(position);
        holder.tituloTextView.setText(libro.getTitulo());
        holder.autorTextView.setText(libro.getAutor());
        holder.editorialTextView.setText(libro.getEditorial());
        holder.fechaPublicacionTextView.setText(libro.getFechaDePublicacion());
        holder.sipnosisTextView.setText(libro.getSipnosis());
        holder.fotoPortadaImageView.setImageResource(libro.getFotoPortada());
        holder.layoutprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String autor = libros.get(position).getAutor();
                String fecha = libros.get(position).getFechaDePublicacion();
                Toast.makeText(context, autor + "\n" + fecha, Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public int getItemCount() {
        return libros.size();
    }
}
