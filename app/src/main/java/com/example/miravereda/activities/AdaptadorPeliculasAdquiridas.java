package com.example.miravereda.activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miravereda.activities.model.Pelicula;
import com.example.miravereda.base.ImageDownloader;
import com.example.miravereda.base.Parameters;

import java.util.List;

import es.ieslavereda.miravereda.R;

public class AdaptadorPeliculasAdquiridas extends RecyclerView.Adapter<AdaptadorPeliculasAdquiridas.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Pelicula> peliculas;

    public AdaptadorPeliculasAdquiridas(@NonNull Context context, List<Pelicula> peliculas) {
        this.context = context;
        this.peliculas = peliculas;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public AdaptadorPeliculasAdquiridas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element_adquiridas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tvNombreContenido.setText(peliculas.get(position).titulo);
        viewHolder.tvCoste.setText(String.valueOf((int) peliculas.get(position).preciovisionado));
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + peliculas.get(position).portada, viewHolder.iContenido);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iContenido;
        private TextView tvNombreContenido;
        private TextView tvCoste;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iContenido = itemView.findViewById(R.id.ivContenidoAdquirido);
            tvNombreContenido = itemView.findViewById(R.id.tvContenidoAdquirido);
            tvCoste = itemView.findViewById(R.id.tvPrecioAdquirido);
        }
    }

}

