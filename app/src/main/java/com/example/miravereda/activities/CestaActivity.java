package com.example.miravereda.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miravereda.activities.model.Pelicula;

import java.util.List;

import es.ieslavereda.miravereda.R;

public class CestaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Pelicula> peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);

        recyclerView = findViewById(R.id.recyclerPeliculasAdquiridas);

        recyclerView.setAdapter(new AdaptadorPeliculasAdquiridas(this, peliculas));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
