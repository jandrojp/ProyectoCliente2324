package com.example.miravereda.API;

import com.example.miravereda.base.Parameters;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Clase que proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * mediante llamadas a una API, utilizando Retrofit y un conversor JSON.
 */
public class Connector {

    private static Connector connector;
    private static Conversor conversor;
    private static CallMethods callMethodsObject;

    /**
     * Obtiene una instancia singleton de Connector.
     *
     * @return la instancia singleton de Connector
     */
    public static Connector getConector() {
        if (connector == null) {
            connector = new Connector();
            conversor = Conversor.getConversor();
            callMethodsObject = CallMethods.getCallMethodsObject();
        }
        return connector;
    }

    /**
     * Realiza una solicitud GET a la URL especificada y devuelve la respuesta como una lista de objetos.
     *
     * @param <T> el tipo de los objetos en la lista
     * @param clazz la clase de los objetos en la lista
     * @param path la ruta de la URL a la que se realizará la solicitud GET
     * @return una lista de objetos de tipo T, o null si ocurre una excepción o la respuesta es null
     */
    public <T> List<T> getAsList(Class<T> clazz, String path) {
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.get(url);
        if (jsonResponse != null)
            return conversor.fromJsonList(jsonResponse, clazz);
        return null;
    }

    /**
     * Realiza una solicitud GET a la URL especificada y devuelve la respuesta como un objeto.
     *
     * @param <T> el tipo del objeto
     * @param clazz la clase del objeto
     * @param path la ruta de la URL a la que se realizará la solicitud GET
     * @return un objeto de tipo T, o null si ocurre una excepción o la respuesta es null
     */
    public <T> T get(Class<T> clazz, String path) {
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.get(url);
        if (jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    /**
     * Realiza una solicitud POST a la URL especificada con los datos proporcionados y devuelve la respuesta como un objeto.
     *
     * @param <T> el tipo del objeto
     * @param clazz la clase del objeto
     * @param data el objeto a enviar en la solicitud POST
     * @param path la ruta de la URL a la que se realizará la solicitud POST
     * @return un objeto de tipo T, o null si ocurre una excepción o la respuesta es null
     */
    public <T> T post(Class<T> clazz, T data, String path) {
        String url = Parameters.URL + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.post(url, body);
        if (jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    /**
     * Realiza una solicitud PUT a la URL especificada con los datos proporcionados y devuelve la respuesta como un objeto.
     *
     * @param <T> el tipo del objeto
     * @param clazz la clase del objeto
     * @param data el objeto a enviar en la solicitud PUT
     * @param path la ruta de la URL a la que se realizará la solicitud PUT
     * @return un objeto de tipo T, o null si ocurre una excepción o la respuesta es null
     */
    public <T> T put(Class<T> clazz, T data, String path) {
        String url = Parameters.URL + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.put(url, body);
        if (jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    /**
     * Realiza una solicitud DELETE a la URL especificada y devuelve la respuesta como un objeto.
     *
     * @param <T> el tipo del objeto
     * @param clazz la clase del objeto
     * @param path la ruta de la URL a la que se realizará la solicitud DELETE
     * @return un objeto de tipo T, o null si ocurre una excepción o la respuesta es null
     */
    public <T> T delete(Class<T> clazz, String path) {
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.delete(url);
        if (jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }
}
