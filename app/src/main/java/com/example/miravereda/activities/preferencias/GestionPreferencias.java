package com.example.miravereda.activities.preferencias;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import es.ieslavereda.miravereda.R;

/**
 * La cual definira los datos que aparezcan al visualizar el layout menu
 */
public class GestionPreferencias {

    private SharedPreferences pref;
    private static GestionPreferencias gestionPreferencias;

    /**
     * Constructor sin parametros
     */
    private GestionPreferencias(){

    }

    /**
     * Se crea un objeto GestionPreferencias si es null
     * @return el atributo static ya creado
     */
    public static GestionPreferencias getInstance(){
        if(gestionPreferencias==null)
            gestionPreferencias = new GestionPreferencias();
        return gestionPreferencias;
    }

    /**
     * Inicializa el objeto SharedPreferences
     * @param context La clase de donde se recibe la información
     */
    private void inicializa(Context context) {
        if (pref == null)
            pref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Obtenemos la IP actual
     * @param context La clase de donde se recibe la información
     * @return La IP definida
     */
    public String getIP(Context context){
        inicializa(context);
        return pref.getString("etpIP","172.30.198.217");
    }

    /**
     * Obtenemos la IP actual
     * @param context La clase de donde se recibe la información
     * @return La IP definida
     */
    public String getPort(Context context){
        inicializa(context);
        return pref.getString("etpPort","8080");
    }

    /**
     * Obtenemos el esquema actual
     * @param context La clase de donde se recibe la información
     * @return El esquema definido
     */
    public String getSchema(Context context){
        inicializa(context);
        return pref.getString("etpSchema","java");
    }

    /**
     * Obtenemos el idioma actual
     * @param context La clase de donde se recibe la información
     * @return El idioma definido
     */
    public String getIdiom(Context context){
        inicializa(context);
        return pref.getString(context.getString(R.string.settings_idiom_key),IdiomSetUp.Idiom.ESPANYOL.name());
    }

    /**
     * Obtenemos el tema actual
     * @param context La clase de donde se recibe la información
     * @return El tema definido
     */
    public String getTheme(Context context){
        inicializa(context);
        return pref.getString(context.getString(R.string.settings_theme_key),ThemeSetup.Mode.DEFAULT.name());
    }


}