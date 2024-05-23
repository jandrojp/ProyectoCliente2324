package com.example.miravereda.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miravereda.activities.model.Pelicula;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import es.ieslavereda.miravereda.R;

/**
 * Actividad que muestra la cesta de compras de películas.
 */
public class CestaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Pelicula> peliculas;
    private Pelicula p;
    private TextView costeTotal;
    private FloatingActionButton floatingActionButton;

    /**
     * Método llamado al crear la actividad. Se encarga de inicializar la interfaz de usuario y los componentes.
     *
     * @param savedInstanceState Objeto donde se almacena el estado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);

        // Inicialización de los componentes de la interfaz de usuario
        recyclerView = findViewById(R.id.recyclerPeliculasAdquiridas);
        costeTotal = findViewById(R.id.tvTotalPagar);
        floatingActionButton = findViewById(R.id.fabR);
        peliculas = new ArrayList<>();

        // Obtención de la película seleccionada desde los extras del intent
        Bundle extras = getIntent().getExtras();
        p = (Pelicula) extras.get("pelicula");
        peliculas.add(p);

        // Configuración del botón flotante para regresar
        floatingActionButton.setOnClickListener(view -> finish());

        // Configuración del precio total a pagar en la interfaz de usuario
        costeTotal.setText("PRECIO TOTAL:  " + p.preciovisionado + " €");

        // Configuración del RecyclerView y su adaptador
        recyclerView.setAdapter(new AdaptadorPeliculasAdquiridas(this, peliculas));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
