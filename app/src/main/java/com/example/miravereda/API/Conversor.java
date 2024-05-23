package com.example.miravereda.API;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
/**
 * Clase que proporciona métodos para convertir objetos Java a JSON y viceversa utilizando la biblioteca Gson.
 */
public class Conversor {
    private static Gson gson;
    private static Conversor conversor;

    /**
     * Obtiene una instancia singleton de Conversor.
     *
     * @return la instancia singleton de Conversor
     */
    public static Conversor getConversor() {
        if (conversor == null) {
            gson = new Gson();
            conversor = new Conversor();
        }
        return conversor;
    }

    /**
     * Convierte un objeto Java en formato JSON.
     *
     * @param <T> el tipo de objeto a convertir
     * @param data el objeto Java a convertir
     * @return una cadena de texto que representa el objeto en formato JSON
     */
    public <T> String toJson(T data) {
        String json = gson.toJson(data);
        return json;
    }

    /**
     * Convierte una lista de objetos Java en formato JSON.
     *
     * @param <T> el tipo de objetos en la lista
     * @param data la lista de objetos Java a convertir
     * @return una cadena de texto que representa la lista en formato JSON
     */
    public <T> String toJson(List<T> data) {
        String json = gson.toJson(data);
        return json;
    }

    /**
     * Convierte una cadena de texto JSON en un objeto Java de la clase especificada.
     *
     * @param <T> el tipo de objeto a convertir
     * @param json la cadena de texto JSON a convertir
     * @param clazz la clase del objeto a convertir
     * @return el objeto Java resultante de la conversión
     */
    public <T> T fromJson(String json, Class<T> clazz) {
        T object = gson.fromJson(json, clazz);
        return object;
    }

    /**
     * Convierte una cadena de texto JSON en una lista de objetos Java del tipo especificado.
     *
     * @param <T> el tipo de objetos en la lista
     * @param json la cadena de texto JSON a convertir
     * @param clazz la clase de los objetos en la lista
     * @return la lista de objetos Java resultante de la conversión
     */
    public <T> List<T> fromJsonList(String json, Class<T> clazz) {
        Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
        List<T> object = gson.fromJson(json, typeOfT);
        return object;
    }
}