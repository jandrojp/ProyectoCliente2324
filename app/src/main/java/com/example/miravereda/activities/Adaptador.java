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

import java.util.List;

import es.ieslavereda.miravereda.R;


public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Pelicula> peliculaList;

    public Adaptador(@NonNull Context context, List<Pelicula> peliculaList) {
        this.context = context;
        this.peliculaList = peliculaList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tvNombreContenido.setText(peliculaList.get(position).titulo);
        //viewHolder.tvValoracion.setText((int) root.peliculas.get(position).valoracion_media);

        viewHolder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailsActivity.class);
           // intent.putExtra("root", peliculaList);
            intent.putExtra("position", position);

            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return peliculaList.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iContenido;
        private TextView tvNombreContenido;
        private TextView tvValoracion;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iContenido = itemView.findViewById(R.id.iContenido);
            tvNombreContenido = itemView.findViewById(R.id.tvNombreContenido);
            tvValoracion = itemView.findViewById(R.id.tvValoracion);
        }
    }

}


