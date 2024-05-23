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

/**
 * Clase que muestra los datos 1 a 1 de cada pelicula adquirida, para que se puedan mostrar en el Recycler
 */
public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Pelicula> peliculaList;

    /**
     * Constructor para crear un objeto Adaptador
     * @param context de que clase se va a obtener la información
     * @param peliculaList lista de peliculas adquiridas, las cuales se van a visualizar
     */
    public Adaptador(@NonNull Context context, List<Pelicula> peliculaList) {
        this.context = context;
        this.peliculaList = peliculaList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Enlazamos con su layout el adaptador
     * @param parent el padre de donde obtiene la informacón
     * @param viewType la vista presente
     * @return un objeto de tipo ViewHolder
     */
    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Muestra la información de todas las peliculas a medida que vas deslizando
     * @param viewHolder Donde estan los datos de cada una de las películas adquiridas
     * @param position La cual esta la pelicula que va iterando
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tvNombreContenido.setText(peliculaList.get(position).titulo);
        viewHolder.tvValoracion.setText(String.valueOf(peliculaList.get(position).valoracion_media));

        Double tiempo = (double) (peliculaList.get(position).duracion / 60);
        viewHolder.tvDuracion.setText(tiempo + " h");
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + peliculaList.get(position).portada, viewHolder.iContenido);

        viewHolder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailsActivity.class);
            intent.putExtra("lista", peliculaList.get(position));
            intent.putExtra("position", position);

            view.getContext().startActivity(intent);
        });
    }

    /**
     * Devuelve el tamaño de la lista de peliculas adquiridas
     * @return El tamaño de la lista
     */
    @Override
    public int getItemCount() {
        return peliculaList.size();
    }

    /**
     * Clase donde se enlaza los datos de las peliculas adquiridas con la app
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iContenido;
        private TextView tvNombreContenido;
        private TextView tvValoracion;
        private TextView tvDuracion;

        /**
         * Enlazamos los atributos de la clase con los elementos del layout
         * @param itemView Define cata item (pelicula) del recycler
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iContenido = itemView.findViewById(R.id.iContenido);
            tvNombreContenido = itemView.findViewById(R.id.tvNombreContenido);
            tvValoracion = itemView.findViewById(R.id.tvValoracion);
            tvDuracion = itemView.findViewById(R.id.tvDuracion);
        }
    }

}


