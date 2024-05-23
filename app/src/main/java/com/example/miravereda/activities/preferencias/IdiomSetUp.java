package com.example.miravereda.activities.preferencias;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

/**
 * Clase la cual modifica el idioma de la App
 */
public final class IdiomSetUp {

    /**
     * Constructor sin parámetros
     */
    private IdiomSetUp() {
    }

    /**
     * Clase enum que defino los idiomas posibles
     */
    public enum Idiom {
        ESPANYOL, INGLES
    }

    /**
     * Clase el cual aplica el idioma dependiendo cuál esté seleccionado
     * @param idiom El idioma que se quiere aplicar
     * @param context La clase de donde se recibe la información
     */
    public static void applyIdiom(Idiom idiom, Context context) {
        switch (idiom) {
            case INGLES:
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = context.getResources().getConfiguration();
                config.locale = locale;
                context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
                break;
        }
    }

    /**
     * Aplica el idoma y cambia el idioma de la App
     * @param context La clase de donde se recibe la información
     */
    public static void applyPreferenceIdiom(Context context) {
        applyIdiom(Idiom.valueOf(GestionPreferencias.getInstance().getIdiom(context)), context);
    }
}
