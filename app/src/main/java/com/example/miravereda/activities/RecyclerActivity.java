package com.example.miravereda.activities;

import android.os.Bundle;
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

/**
 * Actividad que muestra una lista de películas utilizando un RecyclerView.
 */
public class RecyclerActivity extends BaseActivity implements CallInterface {

    private List<Pelicula> peliculas;
    private RecyclerView recyclerView;
    private FloatingActionButton bttnExit;

    /**
     * Método llamado al crear la actividad. Se encarga de inicializar la interfaz de usuario y realizar la llamada para obtener los datos.
     *
     * @param savedInstanceState Objeto donde se almacena el estado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // Mostrar la barra de progreso
        showProgress();
        // Realizar la llamada para obtener los datos
        executeCall(this);
    }

    /**
     * Método para realizar la llamada y obtener los datos en segundo plano.
     */
    @Override
    public void doInBackground() {
        // Obtener la lista de películas desde el conector
        peliculas = Connector.getConector().getAsList(Pelicula.class, "peliculas");
    }

    /**
     * Método llamado una vez que se ha realizado la llamada en segundo plano. Se encarga de ocultar la barra de progreso y presentar los datos en el RecyclerView.
     */
    @Override
    public void doInUI() {
        // Ocultar la barra de progreso
        hideProgress();

        // Inicialización del RecyclerView y del botón de salida
        recyclerView = findViewById(R.id.recycler);
        bttnExit = findViewById(R.id.bttnExit);

        // Configuración del adaptador y del diseño del RecyclerView
        Adaptador adaptador = new Adaptador(this, peliculas);
        recyclerView.setAdapter(adaptador);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Configuración del botón de salida para cerrar la actividad
        bttnExit.setOnClickListener(view -> finish());
    }

}
