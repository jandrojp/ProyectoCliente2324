package com.example.miravereda.activities.preferencias;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Clase que muestra las preferencias de la App
 */
public class PreferenciasActivity extends AppCompatActivity {

    /**
     * Lanzamos la app y la enlazamos con su layout
     * @param savedInstanceState Contenedor donde se va a almacenar
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferenciasFragment())
                .commit();
    }
}