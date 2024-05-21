package com.example.miravereda.activities.preferencias;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import es.ieslavereda.miravereda.R;


public class GestionPreferencias {

    private SharedPreferences pref;
    private static GestionPreferencias gestionPreferencias;

    private GestionPreferencias(){

    }

    public static GestionPreferencias getInstance(){
        if(gestionPreferencias==null)
            gestionPreferencias = new GestionPreferencias();
        return gestionPreferencias;
    }

    private void inicializa(Context context) {
        if (pref == null)
            pref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getIP(Context context){
        inicializa(context);
        return pref.getString("etpIP","172.30.198.217");
    }

    public String getPort(Context context){
        inicializa(context);
        return pref.getString("etpPort","8080");
    }


    public String getSchema(Context context){
        inicializa(context);
        return pref.getString("etpSchema","java");
    }

    public String getIdiom(Context context){
        inicializa(context);
        return pref.getString(context.getString(R.string.settings_idiom_key),IdiomSetUp.Idiom.ESPANYOL.name());
    }


    public String getTheme(Context context){
        inicializa(context);
        return pref.getString(context.getString(R.string.settings_theme_key),ThemeSetup.Mode.DEFAULT.name());
    }


}