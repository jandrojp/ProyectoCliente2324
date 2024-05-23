package com.example.miravereda.API;

import com.example.miravereda.base.Parameters;
import java.io.IOException;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Clase que proporciona métodos para realizar llamadas a una API utilizando Retrofit.
 *
 * @param <T> el tipo de datos que se espera recibir en las respuestas de las llamadas a la API
 */
public class CallMethods<T> {

    private Retrofit retrofit = new Retrofit.Builder().baseUrl(Parameters.URL).build();
    private APIService service = retrofit.create(APIService.class);
    private static CallMethods callMethods;

    /**
     * Obtiene una instancia singleton de CallMethods.
     *
     * @return la instancia singleton de CallMethods
     */
    public static CallMethods getCallMethodsObject() {
        if (callMethods == null) {
            callMethods = new CallMethods();
        }
        return callMethods;
    }

    /**
     * Realiza una solicitud GET a la URL especificada.
     *
     * @param url la URL a la que se realizará la solicitud GET
     * @return la respuesta de la solicitud como una cadena de texto, o null si ocurre una excepción
     */
    public String get(String url) {
        Call<ResponseBody> call = service.getCall(url);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Realiza una solicitud POST a la URL especificada con los datos proporcionados.
     *
     * @param url la URL a la que se realizará la solicitud POST
     * @param data el cuerpo de la solicitud POST
     * @return la respuesta de la solicitud como una cadena de texto, o null si ocurre una excepción
     */
    public String post(String url, RequestBody data) {
        Call<ResponseBody> call = service.postCall(url, data);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Realiza una solicitud PUT a la URL especificada con los datos proporcionados.
     *
     * @param url la URL a la que se realizará la solicitud PUT
     * @param data el cuerpo de la solicitud PUT
     * @return la respuesta de la solicitud como una cadena de texto, o null si ocurre una excepción
     */
    public String put(String url, RequestBody data) {
        Call<ResponseBody> call = service.putCall(url, data);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Realiza una solicitud DELETE a la URL especificada.
     *
     * @param url la URL a la que se realizará la solicitud DELETE
     * @return la respuesta de la solicitud como una cadena de texto, o null si ocurre una excepción
     */
    public String delete(String url) {
        Call<ResponseBody> call = service.deleteCall(url);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}