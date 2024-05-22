package com.example.miravereda.base;

import android.content.Context;

import com.example.miravereda.activities.preferencias.GestionPreferencias;

public class Parameters {


    private static Context context;

    public static String IP = GestionPreferencias.getInstance().getIP(context);
    public static String PUERTO = GestionPreferencias.getInstance().getPort(context);
    String schema = GestionPreferencias.getInstance().getSchema(context);




    public final static String URL = "http://172.30.198.217:8080/miraveredaAPI/";
    public final static String ICON_URL_PRE = "https://image.tmdb.org/t/p/w500";

}
