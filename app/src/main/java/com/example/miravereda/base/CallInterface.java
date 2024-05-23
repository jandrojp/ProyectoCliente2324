package com.example.miravereda.base;

/**
 * Interfaz que define dos métodos para ejecutar tareas en segundo plano y en la interfaz de usuario.
 */
public interface CallInterface {

    /**
     * Método para realizar tareas en segundo plano.
     */
    void doInBackground();

    /**
     * Método para realizar tareas en la interfaz de usuario.
     */
    void doInUI();

}

