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
 * Clase donde podemos ver las peliculas que se han adquirido y que vamos a comprar
 */
public class CestaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Pelicula> peliculas;
    private Pelicula p;
    private TextView costeTotal;
    private FloatingActionButton floatingActionButton;

    /**
     * Lanzamos la app y la enlazamos con su layout
     * @param savedInstanceState Contenedor donde se va a almacenar
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);

        recyclerView = findViewById(R.id.recyclerPeliculasAdquiridas);
        costeTotal = findViewById(R.id.tvTotalPagar);
        floatingActionButton = findViewById(R.id.fabR);
        peliculas = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        p = (Pelicula) extras.get("pelicula");
        peliculas.add(p);

        floatingActionButton.setOnClickListener(view -> finish());

        costeTotal.setText("PRECIO TOTAL:  " + p.preciovisionado + " €");
        recyclerView.setAdapter(new AdaptadorPeliculasAdquiridas(this, peliculas));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
