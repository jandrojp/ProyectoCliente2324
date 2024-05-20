package com.example.miravereda.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miravereda.activities.model.Pelicula;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import es.ieslavereda.miravereda.R;

public class DetailsActivity extends AppCompatActivity {

    private Button btnRestar;
    private Button btnSumar;
    private TextView valoracion;
    private double auxiliar;
    private FloatingActionButton guardarValoracion;
    private Button adquirir;
    private TextView titulo;
    private TextView autor;
    private TextView precio;
    private TextView genero;
    private TextView notaMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        btnRestar = findViewById(R.id.bttnMenos);
        btnSumar = findViewById(R.id.bttnMas);
        valoracion = findViewById(R.id.tvValoracionContenido);
        auxiliar = 5;
        guardarValoracion = findViewById(R.id.fabGuardar);
        adquirir = findViewById(R.id.bttnAdquirir);

        titulo = findViewById(R.id.tvTitulo);
        autor = findViewById(R.id.tvAutor);
        precio = findViewById(R.id.tvPrecio);
        genero = findViewById(R.id.tvGenero);
        notaMedia = findViewById(R.id.tvNotaMedia);


        Pelicula p = (Pelicula) getIntent().getExtras().get("lista");
        int position = (int) getIntent().getExtras().get("position");

        // Falta imagen
        titulo.setText(p.titulo);
        autor.setText(p.director);
        //precio.setText(p.precio);
        genero.setText(p.genero);
        notaMedia.setText(String.valueOf(p.valoracion_media));




        btnRestar.setOnClickListener(view -> {
            if (auxiliar > 0) {
                auxiliar -= 0.5;
                valoracion.setText(String.valueOf(auxiliar));
            }
        });

        btnSumar.setOnClickListener(view -> {
            if (auxiliar < 10) {
                auxiliar += 0.5;
                valoracion.setText(String.valueOf(auxiliar));
            }
        });

        guardarValoracion.setOnClickListener(view -> {
            auxiliar = 5;
            valoracion.setText(String.valueOf(auxiliar));
            Toast.makeText(this, "Su valoración ha sido guardada", Toast.LENGTH_SHORT).show();
        });

        adquirir.setOnClickListener(view -> {
            Toast.makeText(this, "Se ha añadido correctamente a la cesta", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
