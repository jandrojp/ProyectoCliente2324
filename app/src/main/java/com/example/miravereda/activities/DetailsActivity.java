package com.example.miravereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.miravereda.activities.model.Pelicula;
import com.example.miravereda.base.BaseActivity;
import com.example.miravereda.base.ImageDownloader;
import com.example.miravereda.base.Parameters;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import es.ieslavereda.miravereda.R;

/**
 * Actividad que muestra los detalles de una película y permite al usuario interactuar con ellos.
 */
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
    private FloatingActionButton floatingActionButton;

    /**
     * Método llamado al crear la actividad. Se encarga de inicializar la interfaz de usuario y los componentes.
     *
     * @param savedInstanceState Objeto donde se almacena el estado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Inicialización de los componentes de la interfaz de usuario
        btnRestar = findViewById(R.id.bttnMenos);
        btnSumar = findViewById(R.id.bttnMas);
        valoracion = findViewById(R.id.tvValoracionContenido);
        auxiliar = 5;
        guardarValoracion = findViewById(R.id.fabGuardar);
        adquirir = findViewById(R.id.bttnAdquirir);
        image = findViewById(R.id.iContenidoDetalle);
        floatingActionButton = findViewById(R.id.fabVolver);

        titulo = findViewById(R.id.tvTitulo);
        autor = findViewById(R.id.tvAutor);
        precio = findViewById(R.id.tvPrecio);
        genero = findViewById(R.id.tvGenero);
        notaMedia = findViewById(R.id.tvNotaMedia);

        // Obtención de los datos de la película enviados desde la actividad anterior
        Pelicula p = (Pelicula) getIntent().getExtras().get("lista");

        // Configuración de los datos de la película en la interfaz de usuario
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + p.portada, image);
        titulo.setText(p.titulo.toUpperCase());
        autor.setText(p.director);
        precio.setText(String.valueOf((int)p.preciovisionado));
        genero.setText(p.genero);
        notaMedia.setText(String.valueOf(p.valoracion_media));

        // Configuración del botón flotante para regresar a la actividad anterior
        floatingActionButton.setOnClickListener(view -> finish());

        // Configuración de los botones para aumentar o disminuir la valoración de la película
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

        // Configuración del botón para guardar la valoración
        guardarValoracion.setOnClickListener(view -> {

            DecimalFormat df = new DecimalFormat("#.0");
            auxiliar = 5;
            double mediaTotal = Double.parseDouble(df.format((Double.parseDouble(notaMedia.getText().toString()) + Double.parseDouble(valoracion.getText().toString())) / 2));
            notaMedia.setText(String.valueOf(mediaTotal));

            valoracion.setText(String.valueOf(auxiliar));

            Toast.makeText(getApplicationContext(), "Su valoración ha sido guardada", Toast.LENGTH_SHORT).show();
        });

        // Configuración del botón para adquirir la película y abrir la actividad de la cesta de compras
        adquirir.setOnClickListener(view -> {

            Intent intent = new Intent(this, CestaActivity.class);
            intent.putExtra("pelicula", p);
            startActivity(intent);

        });
    }
}
