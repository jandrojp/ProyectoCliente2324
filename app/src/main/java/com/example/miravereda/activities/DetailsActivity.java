package com.example.miravereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miravereda.API.Connector;
import com.example.miravereda.activities.model.Pelicula;
import com.example.miravereda.activities.model.Usuario;
import com.example.miravereda.base.BaseActivity;
import com.example.miravereda.base.CallInterface;
import com.example.miravereda.base.ImageDownloader;
import com.example.miravereda.base.Parameters;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import es.ieslavereda.miravereda.R;

public class DetailsActivity extends BaseActivity {

    private ImageView image;
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
        image = findViewById(R.id.iContenidoDetalle);

        titulo = findViewById(R.id.tvTitulo);
        autor = findViewById(R.id.tvAutor);
        precio = findViewById(R.id.tvPrecio);
        genero = findViewById(R.id.tvGenero);
        notaMedia = findViewById(R.id.tvNotaMedia);

        Pelicula p = (Pelicula) getIntent().getExtras().get("lista");

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + p.portada, image);
        titulo.setText(p.titulo.toUpperCase());
        autor.setText(p.director);
        precio.setText(String.valueOf((int)p.preciovisionado));
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

            DecimalFormat df = new DecimalFormat("#.0");
            auxiliar = 5;
            double mediaTotal = Double.parseDouble(df.format((Double.parseDouble(notaMedia.getText().toString()) + Double.parseDouble(valoracion.getText().toString())) / 2));
            notaMedia.setText(String.valueOf(mediaTotal));

            valoracion.setText(String.valueOf(auxiliar));

            Toast.makeText(getApplicationContext(), "Su valoración ha sido guardada", Toast.LENGTH_SHORT).show();
        });


        /*
        guardarValoracion.setOnClickListener(
                v -> {
                    showProgress();
                    executeCall(new CallInterface() {

                        @Override
                        public void doInBackground() {

                            double valoracionGuardada = Double.parseDouble(valoracion.getText().toString());

                            Pelicula pelicula = new Pelicula(p.id,
                                    p.tipo,
                                    p.titulo,
                                    p.idioma,
                                    p.genero,
                                    p.descripcion,
                                    p.director,
                                    p.actores,
                                    p.duracion,
                                    (valoracionGuardada + p.valoracion_media) / 2,
                                    p.preciovisionado,
                                    p.portada);

                            pelicula = Connector.getConector().put(Pelicula.class, pelicula, "peliculas");

                        }

                        @Override
                        public void doInUI() {
                            hideProgress();
                            auxiliar = 5;
                            Toast.makeText(getApplicationContext(), "Su valoración ha sido guardada", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
        );

         */



        adquirir.setOnClickListener(view -> {

            Intent intent = new Intent(this, CestaActivity.class);
            intent.putExtra("pelicula", p);
            startActivity(intent);

        });
    }
}
