package com.example.miravereda.API;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

/**
 * Interfaz que define los métodos de la API para realizar operaciones HTTP.
 */
public interface APIService {

    /**
     * Realiza una solicitud GET a la URL especificada.
     *
     * @param url la URL a la que se realizará la solicitud GET
     * @return un objeto Call que contiene la respuesta del servidor
     */
    @GET
    Call<ResponseBody> getCall(@Url String url);

    /**
     * Realiza una solicitud POST a la URL especificada con los datos proporcionados en el cuerpo de la solicitud.
     *
     * @param url la URL a la que se realizará la solicitud POST
     * @param data el cuerpo de la solicitud POST
     * @return un objeto Call que contiene la respuesta del servidor
     */
    @POST
    Call<ResponseBody> postCall(@Url String url, @Body RequestBody data);

    /**
     * Realiza una solicitud PUT a la URL especificada con los datos proporcionados en el cuerpo de la solicitud.
     *
     * @param url la URL a la que se realizará la solicitud PUT
     * @param data el cuerpo de la solicitud PUT
     * @return un objeto Call que contiene la respuesta del servidor
     */
    @PUT
    Call<ResponseBody> putCall(@Url String url, @Body RequestBody data);

    /**
     * Realiza una solicitud DELETE a la URL especificada.
     *
     * @param url la URL a la que se realizará la solicitud DELETE
     * @return un objeto Call que contiene la respuesta del servidor
     */
    @DELETE
    Call<ResponseBody> deleteCall(@Url String url);
}