package com.example.miravereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miravereda.API.Connector;

import com.example.miravereda.activities.model.Pelicula;
import com.example.miravereda.base.BaseActivity;
import com.example.miravereda.base.CallInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import es.ieslavereda.miravereda.R;

public class RecyclerActivity extends BaseActivity implements CallInterface {

    private List<Pelicula> peliculas;
    private RecyclerView recyclerView;
    private FloatingActionButton botonCarrito;
    private Switch sOrden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        sOrden = findViewById(R.id.sOrdenar);

        showProgress();
        executeCall(this);
    }

    // Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {
        peliculas = Connector.getConector().getAsList(Pelicula.class, "peliculas");
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();

        recyclerView = findViewById(R.id.recycler);
        botonCarrito = findViewById(R.id.bttnCompra);

        recyclerView.setAdapter(new Adaptador(this, peliculas));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        botonCarrito.setOnClickListener(view -> {
            Intent intent = new Intent(this, CestaActivity.class);
            startActivity(intent);
        });
    }
}