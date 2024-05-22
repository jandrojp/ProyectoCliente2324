package com.example.miravereda.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miravereda.activities.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.miravereda.R;

public class CestaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Pelicula> peliculas;
    private Pelicula p;
    private TextView costeTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);

        recyclerView = findViewById(R.id.recyclerPeliculasAdquiridas);
        costeTotal = findViewById(R.id.tvTotalPagar);
        peliculas = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        p = (Pelicula) extras.get("pelicula");
        peliculas.add(p);

        costeTotal.setText("PRECIO TOTAL:  " + p.preciovisionado + " €");
        recyclerView.setAdapter(new AdaptadorPeliculasAdquiridas(this, peliculas));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
