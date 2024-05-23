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
 * Clase que sirve como adaptador para mostrar una lista de películas adquiridas en un RecyclerView.
 */
public class AdaptadorPeliculasAdquiridas extends RecyclerView.Adapter<AdaptadorPeliculasAdquiridas.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Pelicula> peliculas;

    /**
     * Constructor para crear un objeto Adaptador de películas adquiridas.
     *
     * @param context   El contexto de donde se obtendrá la información.
     * @param peliculas La lista de películas adquiridas que se visualizará.
     */
    public AdaptadorPeliculasAdquiridas(@NonNull Context context, List<Pelicula> peliculas) {
        this.context = context;
        this.peliculas = peliculas;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Crea una nueva instancia de ViewHolder al inflar el diseño de un elemento de la lista.
     *
     * @param parent   El ViewGroup al que se añadirá la vista después de ser unida a la ventana.
     * @param viewType El tipo de vista del nuevo ViewHolder.
     * @return Un objeto ViewHolder que contiene la vista del elemento de la lista.
     */
    @NonNull
    @Override
    public AdaptadorPeliculasAdquiridas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element_adquiridas, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Vincula los datos de una película específica con los elementos de la vista.
     *
     * @param viewHolder El ViewHolder que debe ser actualizado para representar el contenido del elemento.
     * @param position   La posición del elemento en la lista de datos.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // Configuración de los elementos de la vista con los datos de la película en la posición dada
        viewHolder.tvNombreContenido.setText(peliculas.get(position).titulo);
        viewHolder.tvCoste.setText(String.valueOf((int) peliculas.get(position).preciovisionado));
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + peliculas.get(position).portada, viewHolder.iContenido);
    }

    /**
     * Devuelve el número total de elementos en la lista de películas adquiridas.
     *
     * @return El tamaño de la lista de películas adquiridas.
     */
    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    /**
     * Clase que representa un elemento de la vista de la lista de películas adquiridas.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iContenido;
        private TextView tvNombreContenido;
        private TextView tvCoste;

        /**
         * Constructor que enlaza los elementos de la vista con los atributos de la clase.
         *
         * @param itemView La vista que representa un elemento de la lista.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iContenido = itemView.findViewById(R.id.ivContenidoAdquirido);
            tvNombreContenido = itemView.findViewById(R.id.tvContenidoAdquirido);
            tvCoste = itemView.findViewById(R.id.tvPrecioAdquirido);
        }
    }
}
