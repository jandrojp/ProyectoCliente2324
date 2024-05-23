package com.example.miravereda.activities;

import android.content.Context;
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
 * Clase que muestra los datos 1 a 1 de cada pelicula, para que se puedan mostrar en el Recycler
 */
public class AdaptadorPeliculasAdquiridas extends RecyclerView.Adapter<AdaptadorPeliculasAdquiridas.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Pelicula> peliculas;

    /**
     * Constructor para crear un objeto Adaptador
     * @param context de que clase se va a obtener la información
     * @param peliculas lista de peliculas, las cuales se van a visualizar
     */
    public AdaptadorPeliculasAdquiridas(@NonNull Context context, List<Pelicula> peliculas) {
        this.context = context;
        this.peliculas = peliculas;
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
    public AdaptadorPeliculasAdquiridas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element_adquiridas, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Muestra la información de todas las peliculas a medida que vas deslizando
     * @param viewHolder Donde estan los datos de cada una de las películas
     * @param position La cual esta la pelicula que va iterando
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tvNombreContenido.setText(peliculas.get(position).titulo);
        viewHolder.tvCoste.setText(String.valueOf((int) peliculas.get(position).preciovisionado));
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + peliculas.get(position).portada, viewHolder.iContenido);
    }

    /**
     * Devuelve el tamaño de la lista de peliculas
     * @return El tamaño de la lista
     */
    @Override
    public int getItemCount() {
        return peliculas.size();
    }


    /**
     * Clase donde se enlaza los datos de las peliculas con la app
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iContenido;
        private TextView tvNombreContenido;
        private TextView tvCoste;

        /**
         * Enlazamos los atributos de la clase con los elementos del layout
         * @param itemView Define cata item (pelicula) del recycler
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iContenido = itemView.findViewById(R.id.ivContenidoAdquirido);
            tvNombreContenido = itemView.findViewById(R.id.tvContenidoAdquirido);
            tvCoste = itemView.findViewById(R.id.tvPrecioAdquirido);
        }
    }

}

