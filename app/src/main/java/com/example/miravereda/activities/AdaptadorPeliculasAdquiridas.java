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
import com.example.miravereda.activities.model.Root;
import es.ieslavereda.miravereda.R;

public class AdaptadorPeliculasAdquiridas extends RecyclerView.Adapter<AdaptadorPeliculasAdquiridas.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private Root root;

    public AdaptadorPeliculasAdquiridas(@NonNull Context context, Root root) {
        this.context = context;
        this.root = root;
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

        viewHolder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailsActivity.class);
            intent.putExtra("root", root);
            intent.putExtra("position", position);


            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 0;
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

