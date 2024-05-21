package com.example.miravereda.activities;

import android.content.Intent;
import android.os.Bundle;
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
        titulo.setText(p.titulo);
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

        guardarValoracion.setOnClickListener(
                v -> {
                    showProgress();
                    executeCall(new CallInterface() {
                        auxiliar = 5;

                        @Override
                        public void doInBackground() {
                            usuarios =  Connector.getConector().getAsList(Usuario.class, "usuarios");
                            String user = usuarioActualizar.getText().toString();
                            String pass = nuevaContrasenya.getText().toString();

                            if (!usuarioActualizar.getText().toString().isEmpty() && !nuevaContrasenya.getText().toString().isEmpty()) {
                                Optional<Usuario> optional = usuarios.stream().filter(usu -> usu.usuario.equals(user)).findFirst();

                                if (optional.isPresent()) {
                                    Usuario usuarioSeleccionado = optional.get();

                                    Usuario u = new Usuario(usuarioSeleccionado.dni,
                                            usuarioSeleccionado.usuario,
                                            pass,
                                            usuarioSeleccionado.nombre,
                                            usuarioSeleccionado.apellidos,
                                            usuarioSeleccionado.email,
                                            usuarioSeleccionado.domicilio,
                                            usuarioSeleccionado.codigo_postal,
                                            usuarioSeleccionado.fecha_nacimiento,
                                            usuarioSeleccionado.tarjeta_credito);

                                    u = Connector.getConector().put(Usuario.class, u, "usuarios");
                                    result = 1;
                                }

                            }

                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

                            if (result == 1) {
                                Toast.makeText(getApplicationContext(), "Tu contraseña ha sido actualizada", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "Algo ha ido mal. Revisa los campos", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
        );

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
