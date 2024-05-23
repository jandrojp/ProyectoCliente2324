package com.example.miravereda.base;

import android.widget.ImageView;
import com.android.volley.RequestQueue;
import com.squareup.picasso.Picasso;

/**
 * Clase que permite descargar las imágenes de las películas
 */
public class ImageDownloader {

    private static RequestQueue colaPeticiones ;
    private final static String TAG = ImageDownloader.class.getName();

    /**
     * Descarga la imagen y la aplica a la imágen del layout
     * @param url Link de la imágen para descargarla
     * @param imageView Donde se va a aplicar para visualizarla
     */
    public static void downloadImage(String url, ImageView imageView){
        Picasso.get().load(url).into(imageView);
    }

    /*
    public static void downloadImage(Context context, String url, ImageView imageView, int defaultDrawable){
        ImageRequest peticion = new ImageRequest(
                url,
                new Response.Listener<Bitmap>() {
                    @Override public void onResponse(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, null, // maxWidth, maxHeight, decodeConfig
                new Response.ErrorListener() {
                    @Override public void onErrorResponse(VolleyError error) {
                        imageView.setImageResource(defaultDrawable);
                        Log.e(TAG,error.getMessage());
                    }
                }
        );
        getRequestQueue(context).add(peticion);
    }

    private static RequestQueue getRequestQueue(Context context){
        if(colaPeticiones==null)
            colaPeticiones = Volley.newRequestQueue(context);
        return colaPeticiones;
    }

     */
}
