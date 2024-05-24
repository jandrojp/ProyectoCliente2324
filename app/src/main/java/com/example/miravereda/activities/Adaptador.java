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
 * Clase que sirve como adaptador para mostrar una lista de películas en un RecyclerView.
 */
public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Pelicula> peliculaList;

    /**
     * Constructor para crear un objeto Adaptador.
     *
     * @param context      El contexto de donde se obtendrá la información.
     * @param peliculaList La lista de películas que se visualizará.
     */
    public Adaptador(@NonNull Context context, List<Pelicula> peliculaList) {
        this.context = context;
        this.peliculaList = peliculaList;
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
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element, parent, false);
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
        viewHolder.tvNombreContenido.setText(peliculaList.get(position).titulo);
        viewHolder.tvValoracion.setText(String.valueOf(peliculaList.get(position).valoracion_media));


        viewHolder.tvDuracion.setText(peliculaList.get(position).duracion + " min");
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + peliculaList.get(position).portada, viewHolder.iContenido);

        // Acción al hacer clic en un elemento de la lista
        viewHolder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailsActivity.class);
            intent.putExtra("lista", peliculaList.get(position));
            intent.putExtra("position", position);

            view.getContext().startActivity(intent);
        });
    }

    /**
     * Devuelve el número total de elementos en la lista de películas.
     *
     * @return El tamaño de la lista de películas.
     */
    @Override
    public int getItemCount() {
        return peliculaList.size();
    }

    /**
     * Clase que representa un elemento de la vista de la lista de películas.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iContenido;
        private TextView tvNombreContenido;
        private TextView tvValoracion;
        private TextView tvDuracion;

        /**
         * Constructor que enlaza los elementos de la vista con los atributos de la clase.
         *
         * @param itemView La vista que representa un elemento de la lista.
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


